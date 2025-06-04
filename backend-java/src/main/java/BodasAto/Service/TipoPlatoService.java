package BodasAto.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import BodasAto.dto.TipoPlatoDTO;
import BodasAto.entity.TipoPlato;
import BodasAto.repository.TipoPlatoRepository;

@Service
public class TipoPlatoService {

    @Autowired
    private TipoPlatoRepository tipoPlatoRepository;

    public TipoPlatoDTO saveTipoPlato(TipoPlatoDTO dto) {
        TipoPlato tipoPlato = new TipoPlato();

        if (dto.getIdTipoPlato() != null) {
            tipoPlato.setIdTipoPlato(dto.getIdTipoPlato());
        }

        tipoPlato.setNombre(dto.getNombre());

        TipoPlato saved = tipoPlatoRepository.save(tipoPlato);
        return mapToDTO(saved);
    }

    public List<TipoPlatoDTO> getAllTipos() {
        return tipoPlatoRepository.findAll().stream()
                .map(this::mapToDTO)
                .collect(Collectors.toList());
    }

    public Optional<TipoPlatoDTO> getTipoById(Integer id) {
        return tipoPlatoRepository.findById(id).map(this::mapToDTO);
    }

    public TipoPlatoDTO updateTipoPlato(Integer id, TipoPlatoDTO dto) {
        Optional<TipoPlato> opt = tipoPlatoRepository.findById(id);
        if (opt.isEmpty()) {
            throw new RuntimeException("TipoPlato no encontrado con id: " + id);
        }
        TipoPlato tipo = opt.get();
        tipo.setNombre(dto.getNombre());

        TipoPlato updated = tipoPlatoRepository.save(tipo);
        return mapToDTO(updated);
    }

    public boolean deleteTipoPlato(Integer id) {
        if (tipoPlatoRepository.existsById(id)) {
            tipoPlatoRepository.deleteById(id);
            return true;
        }
        return false;
    }

    private TipoPlatoDTO mapToDTO(TipoPlato tipoPlato) {
        return new TipoPlatoDTO(tipoPlato.getIdTipoPlato(), tipoPlato.getNombre());
    }
}
