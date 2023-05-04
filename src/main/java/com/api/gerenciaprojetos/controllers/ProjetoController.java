package com.api.gerenciaprojetos.controllers;

import com.api.gerenciaprojetos.dtos.ProjetoDto;
import com.api.gerenciaprojetos.enumeration.Status;
import com.api.gerenciaprojetos.models.ProjetoModel;
import com.api.gerenciaprojetos.services.ProjetoService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/projeto")
public class ProjetoController {

    final ProjetoService projetoService;

    public ProjetoController(ProjetoService projetoService) {
        this.projetoService = projetoService;
    }

    @PostMapping
    public ResponseEntity<Object> saveProjeto(@RequestBody @Valid ProjetoDto projetoDto) {

        var projetoModel = new ProjetoModel();
        BeanUtils.copyProperties(projetoDto, projetoModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(projetoService.save(projetoModel));
    }

    @GetMapping
    public ResponseEntity<List<ProjetoModel>> getAllprojetos() {
        return ResponseEntity.status(HttpStatus.OK).body(projetoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneProjeto(@PathVariable(value = "idProjeto") Long idProjeto) {
        Optional<ProjetoModel> projetoModelOptional = projetoService.findById(idProjeto);
        if(!projetoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Projeto não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(projetoModelOptional.get());

    }

    @DeleteMapping("/{idProjeto}")
    public ResponseEntity<Object> deleteProjeto(@PathVariable(value = "idProjeto") Long idProjeto) {
        boolean resultado = false;
        Optional<ProjetoModel> projetoModelOptional = projetoService.findById(idProjeto);

        if(!projetoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("projeto não encontrado");
        }

        resultado = projetoService.delete(projetoModelOptional.get());
        if (!resultado) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("projeto não foi removido com sucesso, status: " +
                        projetoModelOptional.get().getStatus().getLabel() );
        }

        return ResponseEntity.status(HttpStatus.OK).body("projeto removido com sucesso");

    }

    @PutMapping("/{idProjeto}")
    public ResponseEntity<Object> updateProjeto(@PathVariable(value = "idProjeto") Long idProjeto, @RequestBody @Valid ProjetoDto projetoDto)  {
        Optional<ProjetoModel> projetoModelOptional = projetoService.findById(idProjeto);
        if(!projetoModelOptional.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("projeto não encontrado");
        }

        var projetoModel = new ProjetoModel();
        BeanUtils.copyProperties(projetoDto, projetoModel);
        projetoModel.setIdProjeto(projetoModelOptional.get().getIdProjeto());

        return ResponseEntity.status(HttpStatus.OK).body(projetoService.save(projetoModel));

    }






}
