package org.wesley.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.wesley.entity.Proposta;

@Repository
public interface PropostaRepository extends JpaRepository<Proposta, Long> {
}
