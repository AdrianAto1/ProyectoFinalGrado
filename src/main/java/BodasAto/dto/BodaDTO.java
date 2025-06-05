package BodasAto.dto;

import java.time.LocalDate;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonProperty;

public class BodaDTO {

    private Long idBoda;
    private LocalDate fecha;
    private String lugar;
    @JsonProperty("nInvitados")
    private Integer nInvitados;
    private String nombreNovio1;
    private String nombreNovio2;

    private List<Long> idInvitados;
    private List<Long> idMesas;
    private List<Integer> idPlatos; 

    public BodaDTO() {
    }

    public BodaDTO(Long idBoda, LocalDate fecha, String lugar, Integer nInvitados, String nombreNovio1, String nombreNovio2,
                   List<Long> idInvitados, List<Long> idMesas, List<Integer> idPlatos) {
        this.idBoda = idBoda;
        this.fecha = fecha;
        this.lugar = lugar;
        this.nInvitados = nInvitados;
        this.nombreNovio1 = nombreNovio1;
        this.nombreNovio2 = nombreNovio2;
        this.idInvitados = idInvitados;
        this.idMesas = idMesas;
        this.idPlatos = idPlatos;
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

    public List<Long> getIdInvitados() {
        return idInvitados;
    }

    public void setIdInvitados(List<Long> idInvitados) {
        this.idInvitados = idInvitados;
    }

    public List<Long> getIdMesas() {
        return idMesas;
    }

    public void setIdMesas(List<Long> idMesas) {
        this.idMesas = idMesas;
    }

    public List<Integer> getIdPlatos() {
        return idPlatos;
    }

    public void setIdPlatos(List<Integer> idPlatos) {
        this.idPlatos = idPlatos;
    }
}
