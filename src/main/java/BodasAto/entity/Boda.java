package BodasAto.entity;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.*;

@Entity
@Table(name = "boda")
public class Boda {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long idBoda;

    @Column(nullable = false)
    protected LocalDate fecha;

    @Column(length = 255)
    protected String lugar;

    @Column(nullable = false)
    protected Integer nInvitados;

    @Column(name = "nombre_novio_1", nullable = false, length = 100)
    protected String nombreNovio1;

    @Column(name = "nombre_novio_2", nullable = false, length = 100)
    protected String nombreNovio2;

    @OneToMany(mappedBy = "boda", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Invitado> invitados;

    @OneToMany(mappedBy = "boda")
    @JsonManagedReference
    protected List<Mesa> mesas;


    public Boda() { }

    public Boda(Long idBoda, LocalDate fecha, String lugar, Integer nInvitados, String nombreNovio1, String nombreNovio2,
                List<Invitado> invitados, List<Mesa> mesas) {
        this.idBoda = idBoda;
        this.fecha = fecha;
        this.lugar = lugar;
        this.nInvitados = nInvitados;
        this.nombreNovio1 = nombreNovio1;
        this.nombreNovio2 = nombreNovio2;
        this.invitados = invitados;
        this.mesas = mesas;
    }

    public Long getIdBoda() {
        return idBoda;
    }

    public void setIdBoda(Long idBoda) {
        this.idBoda = idBoda;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    public Integer getNInvitados() {
        return nInvitados;
    }

    public void setNInvitados(Integer nInvitados) {
        this.nInvitados = nInvitados;
    }

    public String getNombreNovio1() {
        return nombreNovio1;
    }

    public void setNombreNovio1(String nombreNovio1) {
        this.nombreNovio1 = nombreNovio1;
    }

    public String getNombreNovio2() {
        return nombreNovio2;
    }

    public void setNombreNovio2(String nombreNovio2) {
        this.nombreNovio2 = nombreNovio2;
    }

    public List<Invitado> getInvitados() {
        return invitados;
    }

    public void setInvitados(List<Invitado> invitados) {
        this.invitados = invitados;
    }

    public List<Mesa> getMesas() {
        return mesas;
    }

    public void setMesas(List<Mesa> mesas) {
        this.mesas = mesas;
    }

}
