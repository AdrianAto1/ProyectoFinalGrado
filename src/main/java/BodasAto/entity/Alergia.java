package BodasAto.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "alergia")
public class Alergia {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer idAlergia;

    @Column(nullable = false, length = 100)
    protected String nombre;
    
    @ManyToMany(mappedBy = "alergias")
    @JsonBackReference  
    protected List<Invitado> invitados;
    
    // Constructors
    public Alergia() {    	
    }
    
	public Alergia(Integer idAlergia, String nombre, List<Invitado> invitados) {
		super();
		this.idAlergia = idAlergia;
		this.nombre = nombre;
		this.invitados = invitados;
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

	public List<Invitado> getInvitados() {
		return invitados;
	}

	public void setInvitados(List<Invitado> invitados) {
		this.invitados = invitados;
	}
    
}
