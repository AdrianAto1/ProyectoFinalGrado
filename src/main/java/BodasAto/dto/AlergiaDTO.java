package BodasAto.dto;

import java.util.List;

public class AlergiaDTO {
    private Integer idAlergia;
    private String nombre;
    private List<Long> invitadosIds;

    public AlergiaDTO() {}

    public AlergiaDTO(Integer idAlergia, String nombre, List<Long> invitadosIds) {
        this.idAlergia = idAlergia;
        this.nombre = nombre;
        this.invitadosIds = invitadosIds;
    }

    public Integer getIdAlergia() {
        return idAlergia;
    }

    public void setIdAlergia(Integer idAlergia) {
        this.idAlergia = idAlergia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Long> getInvitadosIds() {
        return invitadosIds;
    }

    public void setInvitadosIds(List<Long> invitadosIds) {
        this.invitadosIds = invitadosIds;
    }
}
