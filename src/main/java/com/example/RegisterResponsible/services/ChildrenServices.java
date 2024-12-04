package com.example.RegisterResponsible.services;

import com.example.RegisterResponsible.entities.Children;
import com.example.RegisterResponsible.entities.Responsibles;
import com.example.RegisterResponsible.exceptions.ConflictExceptionCpf;
import com.example.RegisterResponsible.exceptions.CpfNotFound;
import com.example.RegisterResponsible.exceptions.IdNotFoundException;
import com.example.RegisterResponsible.repositories.ChildrenRepository;
import com.example.RegisterResponsible.repositories.ResponsiblesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChildrenServices {

    private final ChildrenRepository repository;
    private final ResponsiblesRepository responsibleRepository;

    public ChildrenServices(ChildrenRepository repository, ResponsiblesRepository responsibleRepository) {
        this.repository = repository;
        this.responsibleRepository = responsibleRepository;
    }


    //LISTAR TODOS OS REGISTROS
    public List<Children> getAllChildren() {
        return repository.findAll();
    }

    //BUSCAR POR CPF
    public ResponseEntity<Children> getChildrenByCpf(String cpf) {
        Children children = repository.findByCpf(cpf).orElseThrow(CpfNotFound::new);
        return ResponseEntity.status(HttpStatus.OK).body(children);
    }

    //BUSSCAR PELO ID
    public ResponseEntity<Children> getChildrenById(UUID id) {
        Children children = repository.findById(id).orElseThrow(IdNotFoundException::new);
        return ResponseEntity.status(HttpStatus.OK).body(children);
    }

    //DELETAR CRIANÇA DO BANCO
    public void deleteChildrenByCpf(UUID id) {
        repository.deleteById(id);
    }

    //METODO PARA ATUALIZAR CADASTRO
    public Children upadteChildren(UUID id, Children upadateChildren) {
        return repository.findById(id)
                .map(existingChildren -> {
                    existingChildren.setCpf(upadateChildren.getCpf());
                    existingChildren.setName(upadateChildren.getName());
                    return repository.save(existingChildren);
                })
                .orElseThrow(IdNotFoundException::new);
    }

    //ADICIONAR NOVA CRIANÇA VINCULADA A UM RESPONSAVEL
    public Children addChildToResponsible(UUID responsibleId, Children children) {
        //VERIFICA SE JA EXISTE CPF NO BANCO
        if (repository.findByCpf(children.getCpf()).isPresent()) {
            throw new ConflictExceptionCpf();
        }

        // Busca o Responsible pelo ID
        Responsibles responsible = responsibleRepository.findById(responsibleId)
                .orElseThrow(IdNotFoundException::new);

        // Define o Responsible no objeto Children
        children.setResponsible(responsible);

        // Salva o Children no banco
        return repository.save(children);
    }
}


