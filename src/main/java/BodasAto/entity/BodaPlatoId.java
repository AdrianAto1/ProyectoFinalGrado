package BodasAto.entity;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class BodaPlatoId implements Serializable {

    private Long idBoda;
    private Integer idPlato;

    public BodaPlatoId() {}

    public BodaPlatoId(Long idBoda, Integer idPlato) {
        this.idBoda = idBoda;
        this.idPlato = idPlato;
    }

    public Long getIdBoda() {
        return idBoda;
    }

    public void setIdBoda(Long idBoda) {
        this.idBoda = idBoda;
    }

    public Integer getIdPlato() {
        return idPlato;
    }

    public void setIdPlato(Integer idPlato) {
        this.idPlato = idPlato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BodaPlatoId)) return false;
        BodaPlatoId that = (BodaPlatoId) o;
        return Objects.equals(idBoda, that.idBoda) &&
               Objects.equals(idPlato, that.idPlato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idBoda, idPlato);
    }
}
