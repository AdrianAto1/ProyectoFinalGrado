package BodasAto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import BodasAto.entity.BodaPlato;
import BodasAto.entity.BodaPlatoId;

import java.util.List;

@Repository
public interface BodaPlatoRepository extends JpaRepository<BodaPlato, BodaPlatoId> {

    List<BodaPlato> findByBoda_IdBoda(Long idBoda);

    List<BodaPlato> findByPlato_IdPlato(Integer idPlato);

    void deleteByBoda_IdBoda(Long idBoda);
    
}

