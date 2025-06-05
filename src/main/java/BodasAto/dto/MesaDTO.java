package BodasAto.dto;

import java.util.List;

public class MesaDTO {
    private Long idMesa;
    private Integer numeroMesa;
    private Long idBoda; 
    private List<Long> idInvitados; 

    public MesaDTO() {}

    public MesaDTO(Long idMesa, Integer numeroMesa, Long idBoda, List<Long> idInvitados) {
        this.idMesa = idMesa;
        this.numeroMesa = numeroMesa;
        this.idBoda = idBoda;
        this.idInvitados = idInvitados;
    }

    public Long getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(Long idMesa) {
        this.idMesa = idMesa;
    }

    public Integer getNumeroMesa() {
        return numeroMesa;
    }

    public void setNumeroMesa(Integer numeroMesa) {
        this.numeroMesa = numeroMesa;
    }

    public Long getIdBoda() {
        return idBoda;
    }

    public void setIdBoda(Long idBoda) {
        this.idBoda = idBoda;
    }

    public List<Long> getIdInvitados() {
        return idInvitados;
    }

    public void setIdInvitados(List<Long> idInvitados) {
        this.idInvitados = idInvitados;
    }
}
