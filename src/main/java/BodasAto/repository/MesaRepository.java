package BodasAto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import BodasAto.entity.Mesa;

@Repository
public interface MesaRepository extends JpaRepository<Mesa, Long> {
    
}