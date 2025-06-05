package BodasAto.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "boda_plato")
public class BodaPlato {

    @EmbeddedId
    private BodaPlatoId id = new BodaPlatoId();

    @ManyToOne
    @MapsId("idBoda")
    @JoinColumn(name = "id_boda")
    private Boda boda;

    @ManyToOne
    @MapsId("idPlato")
    @JoinColumn(name = "id_plato")
    private Plato plato;

    public BodaPlato() {}

    public BodaPlato(Boda boda, Plato plato) {
        this.boda = boda;
        this.plato = plato;
        this.id = new BodaPlatoId(boda.getIdBoda(), plato.getIdPlato());
    }


    public BodaPlatoId getId() {
        return id;
    }

    public void setId(BodaPlatoId id) {
        this.id = id;
    }

    public Boda getBoda() {
        return boda;
    }

    public void setBoda(Boda boda) {
        this.boda = boda;
    }

    public Plato getPlato() {
        return plato;
    }

    public void setPlato(Plato plato) {
        this.plato = plato;
    }
}
