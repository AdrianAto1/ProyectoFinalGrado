package BodasAto.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "mesa")
public class Mesa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long idMesa;

    @Column(nullable = false)
    protected Integer numeroMesa;

    @ManyToOne
    @JoinColumn(name = "id_boda", nullable = false)
    @JsonBackReference  
    protected Boda boda;
    
    @ManyToMany(mappedBy = "mesas")
    @JsonBackReference    
    protected List<Invitado> invitados;
    
    // Constructors
    public Mesa() {    	
    }
    
	public Mesa(Long idMesa, Integer numeroMesa, Boda boda, List<Invitado> invitados) {
		super();
		this.idMesa = idMesa;
		this.numeroMesa = numeroMesa;
		this.boda = boda;
		this.invitados = invitados;
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

	public Boda getBoda() {
		return boda;
	}

	public void setBoda(Boda boda) {
		this.boda = boda;
	}

	public List<Invitado> getInvitados() {
		return invitados;
	}

	public void setInvitados(List<Invitado> invitados) {
		this.invitados = invitados;
	}
      
}
