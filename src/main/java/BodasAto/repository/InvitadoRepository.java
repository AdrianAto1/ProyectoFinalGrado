package BodasAto.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import BodasAto.entity.Invitado;

@Repository
public interface InvitadoRepository extends JpaRepository<Invitado, Long> {
	
	List<Invitado> findByBoda_IdBoda(Long idBoda);

}