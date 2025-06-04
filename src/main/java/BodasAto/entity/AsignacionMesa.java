package BodasAto.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "asignacion_mesa")
public class AsignacionMesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer idAsignacionMesa;

    @ManyToOne
    @JoinColumn(name = "id_mesa", nullable = false)
    @JsonBackReference
    protected Mesa mesa;

    @ManyToOne
    @JoinColumn(name = "id_invitado", nullable = false)
    @JsonBackReference
    protected Invitado invitado;

    public AsignacionMesa() { }

    public AsignacionMesa(Integer idAsignacionMesa, Mesa mesa, Invitado invitado) {
        this.idAsignacionMesa = idAsignacionMesa;
        this.mesa = mesa;
        this.invitado = invitado;
    }

    public Integer getIdAsignacionMesa() {
        return idAsignacionMesa;
    }

    public void setIdAsignacionMesa(Integer idAsignacionMesa) {
        this.idAsignacionMesa = idAsignacionMesa;
    }

    public Mesa getMesa() {
        return mesa;
    }

    public void setMesa(Mesa mesa) {
        this.mesa = mesa;
    }

    public Invitado getInvitado() {
        return invitado;
    }

    public void setInvitado(Invitado invitado) {
        this.invitado = invitado;
    }
}
