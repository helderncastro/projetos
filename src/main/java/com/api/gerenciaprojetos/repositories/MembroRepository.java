package com.api.gerenciaprojetos.repositories;

import com.api.gerenciaprojetos.models.MembroModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembroRepository extends JpaRepository<MembroModel,Long> {

}

