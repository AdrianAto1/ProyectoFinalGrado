package BodasAto.dto;

public class AsignacionMesaDTO {
    private Integer idAsignacionMesa;
    private Long idMesa;
    private Long idInvitado;

    public AsignacionMesaDTO() { }

    public AsignacionMesaDTO(Integer idAsignacionMesa, Long idMesa, Long idInvitado) {
        this.idAsignacionMesa = idAsignacionMesa;
        this.idMesa = idMesa;
        this.idInvitado = idInvitado;
    }

    public Integer getIdAsignacionMesa() {
        return idAsignacionMesa;
    }

    public void setIdAsignacionMesa(Integer idAsignacionMesa) {
        this.idAsignacionMesa = idAsignacionMesa;
    }

    public Long getIdMesa() {
        return idMesa;
    }

    public void setIdMesa(Long idMesa) {
        this.idMesa = idMesa;
    }

    public Long getIdInvitado() {
        return idInvitado;
    }

    public void setIdInvitado(Long idInvitado) {
        this.idInvitado = idInvitado;
    }
}
