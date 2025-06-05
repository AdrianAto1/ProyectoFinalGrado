package BodasAto.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "invitado_alergia")
@IdClass(InvitadoAlergiaId.class)
public class InvitadoAlergia {
    @Id
    @ManyToOne
    @JoinColumn(name = "id_invitado", nullable = false)
    protected Invitado invitado;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_alergia", nullable = false)
    protected Alergia alergia;

    public InvitadoAlergia() {
    }
    
	public InvitadoAlergia(Invitado invitado, Alergia alergia) {
		super();
		this.invitado = invitado;
		this.alergia = alergia;
	}
	
	// Getters y Setters
	public Invitado getInvitado() {
		return invitado;
	}

	public void setInvitado(Invitado invitado) {
		this.invitado = invitado;
	}

	public Alergia getAlergia() {
		return alergia;
	}

	public void setAlergia(Alergia alergia) {
		this.alergia = alergia;
	}
      
}


