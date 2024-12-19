package com.example.RegisterResponsible.services;


import com.example.RegisterResponsible.email.SendingEmail;
import com.example.RegisterResponsible.entities.Responsibles;
import com.example.RegisterResponsible.exceptions.ConflictExceptionCpf;
import com.example.RegisterResponsible.exceptions.ConflictExceptionEmail;
import com.example.RegisterResponsible.exceptions.CpfNotFound;
import com.example.RegisterResponsible.exceptions.IdNotFoundException;
import com.example.RegisterResponsible.repositories.ResponsiblesRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.UUID;

@Service
public class ResponsiblesServices {

    private final ResponsiblesRepository repository;
    private final SendingEmail sendingEmail;

    //Injeção de Dependencia
    public ResponsiblesServices(ResponsiblesRepository repository, SendingEmail sendingEmail) {
        this.repository = repository;
        this.sendingEmail = sendingEmail;
    }

    //MÉTODO PARA ADICIONAR UM RESPONSÁVEL COM VERIFICAÇÃO DE CPF(O CPF DEVE SER UNICO NO BANCO)
    public ResponseEntity<?> register(Responsibles responsibles) {
        if (repository.findByCpf(responsibles.getCpf()).isPresent()) {
            throw new ConflictExceptionCpf();
        }
        if (repository.findByEmail(responsibles.getEmail()).isPresent()) {
            throw new ConflictExceptionEmail();
        }
        //ENVIDO DO EMAIL DE CONFIRMAÇÃO DE REGISTRO
        sendingEmail.sendEmail(responsibles.getEmail(), "Registration Confimation!","Responsible person successfully registered");
        return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(responsibles));
    }

    //BUSCAR(LISTAR) TODOS OS RESPONSÁVEIS SALVOS NO BANCO
    public List<Responsibles> buscarRegistros() {
        return repository.findAll();
    }

    //METODO PARA BUSCAR O RESPONSÁVEL PELO ID
    public ResponseEntity<Responsibles> buscarResponsiblePorId(UUID id) {

        Responsibles responsible = repository.findById(id).orElseThrow(IdNotFoundException::new);
        return ResponseEntity.ok(responsible);
    }

    //MÉTODO PARA DELETAR UM RESPONSÁVEL DO BANCO ATRAVPES DO ID
    public void deleteResponsible(UUID id) {
        repository.deleteById(id);
    }

    //METODO PARA BUSCAR O RESPONSÁVEL PELO CPF
    public ResponseEntity<Responsibles> findByCpf(String cpf) {
        Responsibles responsibles = repository.findByCpf(cpf).orElseThrow(CpfNotFound::new);
        return ResponseEntity.ok(responsibles);
    }
    //METODO PARA ATUALIZAR CADASTRO
    public Responsibles upadateResponsible(UUID id, Responsibles responsibles) {

        return repository.findById(id)
                .map(existingResponsibles -> {
                    existingResponsibles.setCpf(responsibles.getCpf());
                    existingResponsibles.setEmail(responsibles.getEmail());
                    existingResponsibles.setName(responsibles.getName());
                    existingResponsibles.setChildren(responsibles.getChildren());
                   return repository.save(existingResponsibles);
                })
                .orElseThrow(IdNotFoundException::new);
    }


}






