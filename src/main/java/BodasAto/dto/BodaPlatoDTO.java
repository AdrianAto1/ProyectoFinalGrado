package BodasAto.dto;

public class BodaPlatoDTO {
    private Long idBoda;
    private Integer idPlato;

    public BodaPlatoDTO() {}

    public BodaPlatoDTO(Long idBoda, Integer idPlato) {
        this.idBoda = idBoda;
        this.idPlato = idPlato;
    }

	public Long getIdBoda() {
		return idBoda;
	}

	public void setIdBoda(Long idBoda) {
		this.idBoda = idBoda;
	}

	public Integer getIdPlato() {
		return idPlato;
	}

	public void setIdPlato(Integer idPlato) {
		this.idPlato = idPlato;
	}
    
}
