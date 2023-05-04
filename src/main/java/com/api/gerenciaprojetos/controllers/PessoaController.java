package com.api.gerenciaprojetos.controllers;

import com.api.gerenciaprojetos.dtos.PessoaDto;
import com.api.gerenciaprojetos.models.PessoaModel;
import com.api.gerenciaprojetos.services.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/pessoa")
public class PessoaController {

    final PessoaService pessoaService;

    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    public ResponseEntity<Object> saveProjeto(@RequestBody @Valid PessoaDto pessoaDto) {

        var pessoaModel = new PessoaModel();
        BeanUtils.copyProperties(pessoaDto, pessoaModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.save(pessoaModel));
    }

    @GetMapping
    public ResponseEntity<List<PessoaModel>> getAllPessoas() {
       return ResponseEntity.status(HttpStatus.OK).body(pessoaService.findAll());
    }

    @GetMapping("/{idPessoa}")
    public ResponseEntity<Object> getOnePessoa(@PathVariable(value = "idPessoa") Long idPessoa) {
        Optional<PessoaModel> pessoaModelOptional = pessoaService.findById(idPessoa);
        if(!pessoaModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada");
        }
        return ResponseEntity.status(HttpStatus.OK).body(pessoaModelOptional.get());

    }

    @DeleteMapping("/{idPessoa}")
    public ResponseEntity<Object> deletePessoa(@PathVariable(value = "idPessoa") Long idPessoa) {
        Optional<PessoaModel> pessoaModelOptional = pessoaService.findById(idPessoa);
        if(!pessoaModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada");
        }
        pessoaService.delete(pessoaModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Pessoa removida com sucesso");
    }

    @PutMapping("/{idPessoa}")
    public ResponseEntity<Object> updatePessoa(@PathVariable(value = "idPessoa") Long idPessoa, @RequestBody @Valid PessoaDto pessoaDto)  {
        Optional<PessoaModel> pessoaModelOptional = pessoaService.findById(idPessoa);
        if(!pessoaModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada");
        }

        var pessoaModel = new PessoaModel();
        BeanUtils.copyProperties(pessoaDto, pessoaModel);
        pessoaModel.setIdPessoa(pessoaModelOptional.get().getIdPessoa());

        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.save(pessoaModel));

    }


}
