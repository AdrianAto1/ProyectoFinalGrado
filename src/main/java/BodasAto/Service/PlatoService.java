package BodasAto.Service;

import BodasAto.dto.PlatoDTO;
import BodasAto.dto.BodaPlatoDTO;
import BodasAto.entity.*;
import BodasAto.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PlatoService {

    @Autowired
    private PlatoRepository platoRepository;

    @Autowired
    private BodaRepository bodaRepository;

    @Autowired
    private BodaPlatoRepository bodaPlatoRepository;

    public List<PlatoDTO> listarPlatos() {
        return platoRepository.findAll().stream().map(plato -> new PlatoDTO(
                plato.getIdPlato(),
                plato.getNombre(),
                plato.getDescripcion(),
                plato.getTipoPlato().getIdTipoPlato(),
                plato.getTipoPlato().getNombre()
        )).collect(Collectors.toList());
    }

    public void asignarPlatoABoda(BodaPlatoDTO dto) {
        Boda boda = bodaRepository.findById(dto.getIdBoda())
                .orElseThrow(() -> new RuntimeException("Boda no encontrada"));
        Plato plato = platoRepository.findById(dto.getIdPlato())
                .orElseThrow(() -> new RuntimeException("Plato no encontrado"));

        BodaPlato bp = new BodaPlato(boda, plato);
        bodaPlatoRepository.save(bp);
    }

    public List<PlatoDTO> listarPlatosPorBoda(Long idBoda) {
        return bodaPlatoRepository.findByBoda_IdBoda(idBoda).stream().map(bp -> {
            Plato p = bp.getPlato();
            return new PlatoDTO(
                p.getIdPlato(),
                p.getNombre(),
                p.getDescripcion(),
                p.getTipoPlato().getIdTipoPlato(),
                p.getTipoPlato().getNombre()
            );
        }).collect(Collectors.toList());
    }
}
