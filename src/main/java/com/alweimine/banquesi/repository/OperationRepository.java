package com.alweimine.banquesi.repository;

import com.alweimine.banquesi.entities.Compte;
import com.alweimine.banquesi.entities.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OperationRepository extends JpaRepository<Operation,Long> {
    @Query("select o from Operation o where o.compte.CodeCompte=:x")
    public Page<Operation> getOperations(@Param("x") String codeCompte, Pageable pageable);
    //la meme comme getOperation mais moins optimale
    @Deprecated
    public Page<Operation> findByCompte(Compte cp,Pageable pageable);
}
