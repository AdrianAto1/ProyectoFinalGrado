package BodasAto.dto;

import java.util.List;

public class InvitadoDTO {

    private Long idInvitado;
    private String nombre;
    private String apellido;
    private String telefono;
    private Boolean confirmado;
    private Long idBoda;  

    private List<Integer> idAlergias;  
    private List<Long> idMesas;       

    public InvitadoDTO() {}

    public InvitadoDTO(Long idInvitado, String nombre, String apellido, String telefono, Boolean confirmado, Long idBoda,
                       List<Integer> idAlergias, List<Long> idMesas) {
        this.idInvitado = idInvitado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.confirmado = confirmado;
        this.idBoda = idBoda;
        this.idAlergias = idAlergias;
        this.idMesas = idMesas;
    }

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

    public Long getIdBoda() {
        return idBoda;
    }

    public void setIdBoda(Long idBoda) {
        this.idBoda = idBoda;
    }

    public List<Integer> getIdAlergias() {
        return idAlergias;
    }

    public void setIdAlergias(List<Integer> idAlergias) {
        this.idAlergias = idAlergias;
    }

    public List<Long> getIdMesas() {
        return idMesas;
    }

    public void setIdMesas(List<Long> idMesas) {
        this.idMesas = idMesas;
    }
}
