package BodasAto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import BodasAto.entity.TipoPlato;

@Repository
public interface TipoPlatoRepository extends JpaRepository<TipoPlato, Integer> {
}