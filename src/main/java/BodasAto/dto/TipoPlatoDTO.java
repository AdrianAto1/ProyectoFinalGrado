package BodasAto.dto;

public class TipoPlatoDTO {
    private Integer idTipoPlato;
    private String nombre;

    public TipoPlatoDTO() {}

    public TipoPlatoDTO(Integer idTipoPlato, String nombre) {
        this.idTipoPlato = idTipoPlato;
        this.nombre = nombre;
    }

    public Integer getIdTipoPlato() {
        return idTipoPlato;
    }

    public void setIdTipoPlato(Integer idTipoPlato) {
        this.idTipoPlato = idTipoPlato;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
