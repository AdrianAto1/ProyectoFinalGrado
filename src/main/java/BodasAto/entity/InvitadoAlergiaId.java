package BodasAto.entity;

import java.io.Serializable;
import java.util.Objects;

@SuppressWarnings("serial")
public class InvitadoAlergiaId implements Serializable {
	protected Long invitado;
	protected Integer alergia;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvitadoAlergiaId that = (InvitadoAlergiaId) o;
        return Objects.equals(invitado, that.invitado) &&
               Objects.equals(alergia, that.alergia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invitado, alergia);
    }

    public Long getInvitado() {
        return invitado;
    }

    public void setInvitado(Long invitado) {
        this.invitado = invitado;
    }

    public Integer getAlergia() {
        return alergia;
    }

    public void setAlergia(Integer alergia) {
        this.alergia = alergia;
    }
    
}
