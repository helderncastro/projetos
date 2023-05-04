package com.api.gerenciaprojetos.services;

import com.api.gerenciaprojetos.models.MembroModel;
import com.api.gerenciaprojetos.repositories.MembroRepository;
import com.api.gerenciaprojetos.util.FuncoesUteis;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MembroService {

    final MembroRepository membroRepository;

    public MembroService(MembroRepository membroRepository) {
        this.membroRepository = membroRepository;
    }

    @Transactional
    public MembroModel save(MembroModel membroModel) {

        Boolean pessoaFuncionario = FuncoesUteis.booleanOuNulo(membroModel.getPessoaMembro().getFuncionario());
        if (pessoaFuncionario) {
            return membroRepository.save(membroModel);
        }
        return null;

    }

    public List<MembroModel> findAll() {
        return membroRepository.findAll();
    }

    public Optional<MembroModel> findById(Long id) {
        return membroRepository.findById(id);
    }

    @Transactional
    public void delete(MembroModel membroModel) {
        membroRepository.delete(membroModel);
    }



}
