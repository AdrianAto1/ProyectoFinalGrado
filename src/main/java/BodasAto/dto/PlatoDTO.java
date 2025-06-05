package BodasAto.dto;

public class PlatoDTO {
    private Integer idPlato;
    private String nombre;
    private String descripcion;
    private Integer idTipoPlato;
    private String nombreTipoPlato;

    public PlatoDTO() {}

    public PlatoDTO(Integer idPlato, String nombre, String descripcion, Integer idTipoPlato, String nombreTipoPlato) {
        this.idPlato = idPlato;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.idTipoPlato = idTipoPlato;
        this.nombreTipoPlato = nombreTipoPlato;
    }

	public Integer getIdPlato() {
		return idPlato;
	}

	public void setIdPlato(Integer idPlato) {
		this.idPlato = idPlato;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Integer getIdTipoPlato() {
		return idTipoPlato;
	}

	public void setIdTipoPlato(Integer idTipoPlato) {
		this.idTipoPlato = idTipoPlato;
	}

	public String getNombreTipoPlato() {
		return nombreTipoPlato;
	}

	public void setNombreTipoPlato(String nombreTipoPlato) {
		this.nombreTipoPlato = nombreTipoPlato;
	}
    
}
