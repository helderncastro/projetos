package com.api.gerenciaprojetos.controllers;

import com.api.gerenciaprojetos.dtos.MembroDto;
import com.api.gerenciaprojetos.dtos.PessoaDto;
import com.api.gerenciaprojetos.models.MembroModel;
import com.api.gerenciaprojetos.models.PessoaModel;
import com.api.gerenciaprojetos.services.MembroService;
import com.api.gerenciaprojetos.services.PessoaService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/membro")
public class MembroController {

    final MembroService membroService;
    @Autowired
    PessoaService pessoaService;

    public MembroController(MembroService membroService) {
        this.membroService = membroService;
    }

    @PostMapping
    public ResponseEntity<Object> saveMembro(@RequestBody @Valid MembroDto membroDto) {

        var membroModel = new MembroModel();
        BeanUtils.copyProperties(membroDto, membroModel);

        Optional<MembroModel> membroModelOptional = Optional.ofNullable(membroService.save(membroModel));
        if ( membroModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.CREATED).body(membroModelOptional.get());
        }
        return ResponseEntity.status(HttpStatus.CONFLICT).body("Pessoa informada não é funcionário");

    }

    @GetMapping
    public ResponseEntity<List<MembroModel>> getAllMembros() {
        return ResponseEntity.status(HttpStatus.OK).body(membroService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneMembro(@PathVariable(value = "id") Long id) {
        Optional<MembroModel> membroModelOptional = membroService.findById(id);
        if(!membroModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Membro não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(membroModelOptional.get());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteMembro(@PathVariable(value = "id") Long id) {
        Optional<MembroModel> membroModelOptional = membroService.findById(id);
        if(!membroModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Membro não encontrado");
        }
        membroService.delete(membroModelOptional.get());
        return ResponseEntity.status(HttpStatus.OK).body("Membro removido com sucesso");
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateMembro(@PathVariable(value = "id") Long id,
                                               @RequestBody @Valid MembroDto membroDto)  {

        Optional<MembroModel> membroModelOptional = membroService.findById(id);
        if(!membroModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Membro não encontrado");
        }

        var membroModel = membroModelOptional.get();
        membroModel.setPessoaMembro(membroDto.getPessoaMembro());

        return ResponseEntity.status(HttpStatus.OK).body(membroService.save(membroModel));

    }

}


