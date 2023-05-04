package com.api.gerenciaprojetos.repositories;

import com.api.gerenciaprojetos.models.PessoaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PessoaRepository extends JpaRepository<PessoaModel,Long> {

     void delete(PessoaModel pessoaModel);

}
