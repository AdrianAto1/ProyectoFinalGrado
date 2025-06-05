package BodasAto.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tipo_plato")
public class TipoPlato {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer idTipoPlato;

    @Column(nullable = false, length = 50)
    protected String nombre;

    public TipoPlato() {   	
    }
	public TipoPlato(Integer idTipoPlato, String nombre) {
		super();
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
