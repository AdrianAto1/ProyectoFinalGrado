package BodasAto.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import BodasAto.dto.InvitadoAlergiaDTO;
import BodasAto.entity.Alergia;
import BodasAto.entity.Invitado;
import BodasAto.entity.InvitadoAlergia;
import BodasAto.entity.InvitadoAlergiaId;
import BodasAto.repository.AlergiaRepository;
import BodasAto.repository.InvitadoAlergiaRepository;
import BodasAto.repository.InvitadoRepository;
import jakarta.persistence.EntityNotFoundException;

@Service
public class InvitadoAlergiaService {

    private final InvitadoAlergiaRepository invitadoAlergiaRepository;
    private final InvitadoRepository invitadoRepository;
    private final AlergiaRepository alergiaRepository;

    public InvitadoAlergiaService(
        InvitadoAlergiaRepository invitadoAlergiaRepository,
        InvitadoRepository invitadoRepository,
        AlergiaRepository alergiaRepository) {
        this.invitadoAlergiaRepository = invitadoAlergiaRepository;
        this.invitadoRepository = invitadoRepository;
        this.alergiaRepository = alergiaRepository;
    }

    public List<InvitadoAlergiaDTO> findAll() {
        return invitadoAlergiaRepository.findAll().stream()
            .map(ia -> new InvitadoAlergiaDTO(ia.getInvitado().getIdInvitado(), ia.getAlergia().getIdAlergia()))
            .collect(Collectors.toList());
    }

    public InvitadoAlergiaDTO create(InvitadoAlergiaDTO dto) {
        Invitado invitado = invitadoRepository.findById(dto.getIdInvitado())
            .orElseThrow(() -> new EntityNotFoundException("Invitado no encontrado con id " + dto.getIdInvitado()));
        Alergia alergia = alergiaRepository.findById(dto.getIdAlergia())
            .orElseThrow(() -> new EntityNotFoundException("Alergia no encontrada con id " + dto.getIdAlergia()));

        InvitadoAlergia entity = new InvitadoAlergia(invitado, alergia);
        invitadoAlergiaRepository.save(entity);
        return dto;
    }

    public void delete(Long idInvitado, Integer idAlergia) {
        InvitadoAlergiaId id = new InvitadoAlergiaId();
        id.setInvitado(idInvitado);
        id.setAlergia(idAlergia);

        if (!invitadoAlergiaRepository.existsById(id)) {
            throw new EntityNotFoundException("Relación no encontrada");
        }

        invitadoAlergiaRepository.deleteById(id);
    }
}
