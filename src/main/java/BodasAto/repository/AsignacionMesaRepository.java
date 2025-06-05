package BodasAto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import BodasAto.entity.AsignacionMesa;

@Repository
public interface AsignacionMesaRepository extends JpaRepository<AsignacionMesa, Integer> {
	
    List<AsignacionMesa> findByInvitadoNombre(String nombre);
}

