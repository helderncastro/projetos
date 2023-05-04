package com.api.gerenciaprojetos.services;

import com.api.gerenciaprojetos.models.PessoaModel;
import com.api.gerenciaprojetos.repositories.PessoaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository){
        this.pessoaRepository = pessoaRepository;
    }

    @Transactional
    public PessoaModel save(PessoaModel pessoaModel) {
        return pessoaRepository.save(pessoaModel);
    }


    public List<PessoaModel> findAll() {
        return pessoaRepository.findAll();
    }

    public Optional<PessoaModel> findById(Long id) {
        return pessoaRepository.findById(id);
    }

    @Transactional
    public void delete(PessoaModel pessoaModel) {
        pessoaRepository.delete(pessoaModel);
    }
}
