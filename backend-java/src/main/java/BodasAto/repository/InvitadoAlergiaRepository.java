package BodasAto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import BodasAto.entity.InvitadoAlergia;
import BodasAto.entity.InvitadoAlergiaId;

public interface InvitadoAlergiaRepository extends JpaRepository<InvitadoAlergia, InvitadoAlergiaId> {
}
