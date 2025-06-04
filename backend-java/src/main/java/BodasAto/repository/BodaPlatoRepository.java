package BodasAto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import BodasAto.entity.BodaPlato;
import BodasAto.entity.BodaPlatoId;

import java.util.List;

@Repository
public interface BodaPlatoRepository extends JpaRepository<BodaPlato, BodaPlatoId> {

    // Obtener todas las relaciones plato-boda de una boda específica
    List<BodaPlato> findByBoda_IdBoda(Long idBoda);

    // Obtener todas las relaciones plato-boda de un plato específico
    List<BodaPlato> findByPlato_IdPlato(Integer idPlato);

    // Eliminar todos los platos asignados a una boda (opcional)
    void deleteByBoda_IdBoda(Long idBoda);
    
}

