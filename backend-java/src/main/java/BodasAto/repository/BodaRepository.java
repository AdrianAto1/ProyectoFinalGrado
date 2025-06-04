package BodasAto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import BodasAto.entity.Boda;

@Repository
public interface BodaRepository extends JpaRepository<Boda, Long> {
    
}
