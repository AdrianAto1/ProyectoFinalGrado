package BodasAto.controller;

import BodasAto.dto.PlatoDTO;
import BodasAto.dto.BodaPlatoDTO;
import BodasAto.Service.PlatoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/platos")
@CrossOrigin(origins = "*") 
public class PlatoController {

    @Autowired
    private PlatoService platoService;

    @GetMapping
    public List<PlatoDTO> obtenerTodosLosPlatos() {
        return platoService.listarPlatos();
    }

    @PostMapping("/asignar-a-boda")
    public void asignarPlatoABoda(@RequestBody BodaPlatoDTO dto) {
        platoService.asignarPlatoABoda(dto);
    }

    @GetMapping("/por-boda/{idBoda}")
    public List<PlatoDTO> obtenerPlatosDeUnaBoda(@PathVariable Long idBoda) {
        return platoService.listarPlatosPorBoda(idBoda);
    }
}
