package BodasAto.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import BodasAto.dto.BodaDTO;
import BodasAto.entity.Boda;
import BodasAto.entity.Invitado;
import BodasAto.entity.Mesa;
import BodasAto.repository.BodaRepository;
import BodasAto.repository.InvitadoRepository;
import BodasAto.repository.MesaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class BodaService {

    private final BodaRepository bodaRepository;
    private final InvitadoRepository invitadoRepository;
    private final MesaRepository mesaRepository;

    public BodaService(
        BodaRepository bodaRepository,
        InvitadoRepository invitadoRepository,
        MesaRepository mesaRepository
    ) {
        this.bodaRepository = bodaRepository;
        this.invitadoRepository = invitadoRepository;
        this.mesaRepository = mesaRepository;
    }

    private Boda toEntity(BodaDTO dto) {
        Boda boda = new Boda();
        boda.setIdBoda(dto.getIdBoda());
        boda.setFecha(dto.getFecha());
        boda.setLugar(dto.getLugar());
        boda.setNInvitados(dto.getNInvitados() != null ? dto.getNInvitados() : 0);
        boda.setNombreNovio1(dto.getNombreNovio1());
        boda.setNombreNovio2(dto.getNombreNovio2());

        if (dto.getIdInvitados() != null) {
            List<Invitado> invitados = dto.getIdInvitados().stream()
                .map(invId -> invitadoRepository.findById(invId)
                    .orElseThrow(() -> new EntityNotFoundException("Invitado no encontrado con id " + invId)))
                .collect(Collectors.toList());
            boda.setInvitados(invitados);
        }
        if (dto.getIdMesas() != null) {
            List<Mesa> mesas = dto.getIdMesas().stream()
                .map(mesaId -> mesaRepository.findById(mesaId)
                    .orElseThrow(() -> new EntityNotFoundException("Mesa no encontrada con id " + mesaId)))
                .collect(Collectors.toList());
            boda.setMesas(mesas);
        }
        System.out.println("nInvitados en toEntity: " + boda.getNInvitados()); // 👈 LOG
        return boda;
    }

   
    private BodaDTO toDTO(Boda boda) {
        return new BodaDTO(
            boda.getIdBoda(),
            boda.getFecha(),
            boda.getLugar(),
            boda.getNInvitados(),
            boda.getNombreNovio1(),
            boda.getNombreNovio2(),
            boda.getInvitados() != null
                ? boda.getInvitados().stream().map(Invitado::getIdInvitado).collect(Collectors.toList())
                : null,
            boda.getMesas() != null
                ? boda.getMesas().stream().map(Mesa::getIdMesa).collect(Collectors.toList())
                : null,
            null 
        );
    }

    public List<BodaDTO> findAll() {
        return bodaRepository.findAll().stream()
            .map(this::toDTO)
            .collect(Collectors.toList());
    }

    public BodaDTO findById(Long id) {
        Boda boda = bodaRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Boda no encontrada con id " + id));
        return toDTO(boda);
    }

    public BodaDTO create(BodaDTO dto) {
        Boda boda = toEntity(dto);
        System.out.println("nInvitados antes de guardar: " + boda.getNInvitados()); // 👈 LOG
        Boda saved = bodaRepository.save(boda);
        return toDTO(saved);
    }

    public BodaDTO update(Long id, BodaDTO dto) {
        Boda existing = bodaRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Boda no encontrada con id " + id));

        existing.setFecha(dto.getFecha());
        existing.setLugar(dto.getLugar());
        existing.setNInvitados(dto.getNInvitados());
        existing.setNombreNovio1(dto.getNombreNovio1());
        existing.setNombreNovio2(dto.getNombreNovio2());

        if (dto.getIdInvitados() != null) {
            List<Invitado> invitados = dto.getIdInvitados().stream()
                .map(invId -> invitadoRepository.findById(invId)
                    .orElseThrow(() -> new EntityNotFoundException("Invitado no encontrado con id " + invId)))
                .collect(Collectors.toList());
            existing.setInvitados(invitados);
        }

        if (dto.getIdMesas() != null) {
            List<Mesa> mesas = dto.getIdMesas().stream()
                .map(mesaId -> mesaRepository.findById(mesaId)
                    .orElseThrow(() -> new EntityNotFoundException("Mesa no encontrada con id " + mesaId)))
                .collect(Collectors.toList());
            existing.setMesas(mesas);
        }

        Boda updated = bodaRepository.save(existing);
        return toDTO(updated);
    }

    public void delete(Long id) {
        if (!bodaRepository.existsById(id)) {
            throw new EntityNotFoundException("Boda no encontrada con id " + id);
        }
        bodaRepository.deleteById(id);
    }

    public List<List<String>> getAllCouples() {
        return bodaRepository.findAll().stream()
            .map(boda -> List.of(boda.getNombreNovio1(), boda.getNombreNovio2()))
            .collect(Collectors.toList());
    }
}
