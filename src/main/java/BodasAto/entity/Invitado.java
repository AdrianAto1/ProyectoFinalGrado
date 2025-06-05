package BodasAto.entity;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "invitado")
public class Invitado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long idInvitado;

    @Column(nullable = false, length = 100)
    protected String nombre;

    @Column(nullable = false, length = 100)
    protected String apellido;

    @Column(nullable = false, length = 25)
    protected String telefono;

    @Column(nullable = false)
    protected Boolean confirmado;

    @ManyToOne
    @JoinColumn(name = "id_boda")
    @JsonBackReference  
    private Boda boda;
    
    @ManyToMany
    @JoinTable(
        name = "invitado_alergia",
        joinColumns = @JoinColumn(name = "id_invitado"),
        inverseJoinColumns = @JoinColumn(name = "id_alergia")
    )
    @JsonManagedReference  
    protected List<Alergia> alergias;
    
    @ManyToMany
    @JoinTable(
        name = "asignacion_mesa",
        joinColumns = @JoinColumn(name = "id_invitado"),
        inverseJoinColumns = @JoinColumn(name = "id_mesa")
    )
    @JsonManagedReference  
    protected List<Mesa> mesas;
    
    
    // Constructors
    public Invitado() {    	
    }
    
	public Invitado(Long idInvitado, String nombre, String apellido, String telefono, Boolean confirmado, Boda boda,
			List<Alergia> alergias, List<Mesa> mesas) {
		super();
		this.idInvitado = idInvitado;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.confirmado = confirmado;
		this.boda = boda;
		this.alergias = alergias;
		this.mesas = mesas;
	}
	
	// Getters y Setters
	public Long getIdInvitado() {
		return idInvitado;
	}

	public void setIdInvitado(Long idInvitado) {
		this.idInvitado = idInvitado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Boolean getConfirmado() {
		return confirmado;
	}

	public void setConfirmado(Boolean confirmado) {
		this.confirmado = confirmado;
	}

	public Boda getBoda() {
		return boda;
	}

	public void setBoda(Boda boda) {
		this.boda = boda;
	}

	public List<Alergia> getAlergias() {
		return alergias;
	}

	public void setAlergias(List<Alergia> alergias) {
		this.alergias = alergias;
	}

	public List<Mesa> getMesas() {
		return mesas;
	}

	public void setMesas(List<Mesa> mesas) {
		this.mesas = mesas;
	}
	   
}