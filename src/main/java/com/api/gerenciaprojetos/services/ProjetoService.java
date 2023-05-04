package com.api.gerenciaprojetos.services;

import com.api.gerenciaprojetos.enumeration.Status;
import com.api.gerenciaprojetos.models.ProjetoModel;
import com.api.gerenciaprojetos.repositories.ProjetoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjetoService {

    final ProjetoRepository projetoRepository;
    public ProjetoService(ProjetoRepository projetoRepository) {
        this.projetoRepository = projetoRepository;
    }

    @Transactional
    public ProjetoModel save (ProjetoModel projetoModel) {
        return projetoRepository.save(projetoModel);
    }

    public List<ProjetoModel> findAll() {
        return projetoRepository.findAll();
    }

    public Optional<ProjetoModel> findById(Long idProjeto) {
        return projetoRepository.findById(idProjeto);
    }

    @Transactional
    public boolean delete(ProjetoModel projetoModel) {

        Status statusRecebido =  projetoModel.getStatus() ;

        if ( (statusRecebido.equals(Status.INICIADO)) || (statusRecebido.equals(Status.ANDAMENTO)) || (statusRecebido.equals(Status.ENCERRADO))  ) {
            return false ;
        }

        projetoRepository.delete(projetoModel);

        return true;
    }


}
