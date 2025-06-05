package BodasAto.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BodasAto.dto.InvitadoDTO;
import BodasAto.entity.Alergia;
import BodasAto.entity.Boda;
import BodasAto.entity.Invitado;
import BodasAto.entity.Mesa;
import BodasAto.repository.AlergiaRepository;
import BodasAto.repository.BodaRepository;
import BodasAto.repository.InvitadoRepository;
import BodasAto.repository.MesaRepository;

@Service
public class InvitadoService {

    @Autowired
    private InvitadoRepository invitadoRepository;
  
    @Autowired
    private BodaRepository bodaRepository;

    @Autowired
    private AlergiaRepository alergiaRepository;

    @Autowired
    private MesaRepository mesaRepository;

    
    private Invitado dtoToEntity(InvitadoDTO dto) {
        Invitado invitado = new Invitado();

        invitado.setIdInvitado(dto.getIdInvitado());
        invitado.setNombre(dto.getNombre());
        invitado.setApellido(dto.getApellido());
        invitado.setTelefono(dto.getTelefono());
        invitado.setConfirmado(dto.getConfirmado());

        if (dto.getIdBoda() != null) {
            Optional<Boda> bodaOpt = bodaRepository.findById(dto.getIdBoda());
            bodaOpt.ifPresent(invitado::setBoda);
        } else {
            invitado.setBoda(null);
        }

        if (dto.getIdAlergias() != null) {
            List<Alergia> alergias = alergiaRepository.findAllById(dto.getIdAlergias());
            invitado.setAlergias(alergias);
        } else {
            invitado.setAlergias(null);
        }

        if (dto.getIdMesas() != null) {
            List<Mesa> mesas = mesaRepository.findAllById(dto.getIdMesas());
            invitado.setMesas(mesas);
        } else {
            invitado.setMesas(null);
        }

        return invitado;
    }

    private InvitadoDTO entityToDto(Invitado invitado) {
        InvitadoDTO dto = new InvitadoDTO();

        dto.setIdInvitado(invitado.getIdInvitado());
        dto.setNombre(invitado.getNombre());
        dto.setApellido(invitado.getApellido());
        dto.setTelefono(invitado.getTelefono());
        dto.setConfirmado(invitado.getConfirmado());

        if (invitado.getBoda() != null) {
            dto.setIdBoda(invitado.getBoda().getIdBoda());
        }

        if (invitado.getAlergias() != null) {
            List<Integer> idsAlergias = invitado.getAlergias().stream()
                    .map(Alergia::getIdAlergia)
                    .collect(Collectors.toList());
            dto.setIdAlergias(idsAlergias);
        }

        if (invitado.getMesas() != null) {
            List<Long> idsMesas = invitado.getMesas().stream()
                    .map(Mesa::getIdMesa)
                    .collect(Collectors.toList());
            dto.setIdMesas(idsMesas);
        }

        return dto;
    }


    public InvitadoDTO saveInvitado(InvitadoDTO dto) {
        Invitado invitado = dtoToEntity(dto);
        Invitado saved = invitadoRepository.save(invitado);
        return entityToDto(saved);
    }

    public List<InvitadoDTO> getAllInvitados() {
        return invitadoRepository.findAll()
                .stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }
    

    public Optional<InvitadoDTO> getInvitadoById(Long id) {
        return invitadoRepository.findById(id).map(this::entityToDto);
    }

    public Optional<InvitadoDTO> updateInvitado(Long id, InvitadoDTO dto) {
        if (invitadoRepository.existsById(id)) {
            Invitado invitado = dtoToEntity(dto);
            invitado.setIdInvitado(id);
            Invitado updated = invitadoRepository.save(invitado);
            return Optional.of(entityToDto(updated));
        }
        return Optional.empty();
    }

    public boolean deleteInvitado(Long id) {
        if (invitadoRepository.existsById(id)) {
            invitadoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean actualizarConfirmacion(Long idInvitado, boolean confirmado) {
        Optional<Invitado> invitadoOpt = invitadoRepository.findById(idInvitado);
        if (invitadoOpt.isPresent()) {
            Invitado invitado = invitadoOpt.get();
            invitado.setConfirmado(confirmado);
            invitadoRepository.save(invitado);
            return true;
        }
        return false;
    }
    public List<InvitadoDTO> getInvitadosByIdBoda(Long idBoda) {
        return invitadoRepository.findByBoda_IdBoda(idBoda)
                .stream()
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }
    
}
