package BodasAto.dto;

public class InvitadoAlergiaDTO {
    private Long idInvitado;
    private Integer idAlergia;

    public InvitadoAlergiaDTO() {
    }

    public InvitadoAlergiaDTO(Long idInvitado, Integer idAlergia) {
        this.idInvitado = idInvitado;
        this.idAlergia = idAlergia;
    }

    public Long getIdInvitado() {
        return idInvitado;
    }

    public void setIdInvitado(Long idInvitado) {
        this.idInvitado = idInvitado;
    }

    public Integer getIdAlergia() {
        return idAlergia;
    }

    public void setIdAlergia(Integer idAlergia) {
        this.idAlergia = idAlergia;
    }
}
