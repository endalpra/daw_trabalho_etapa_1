package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Érico
 */
@Entity
@Table(name="telefone")
public class Telefone implements Serializable{
    @EmbeddedId
    private TelefoneId telefoneId;
    
    @NotBlank(message="O codigo do país deve ser informado!")
    @Length(max=5, message = "O codigo de país deve ser menor ou igual a {max}!")
    @Column(name="codigo_pais", nullable = false, length = 5)
    private String codigo_pais;
    
    @NotBlank(message="O código de área deve ser informado!")
    @Length(max=2, message = "O código de área não deve ter mais que {max} caracteres!")
    @Column(name="codigo_area", nullable = false, length = 2)
    private String codigo_area;
    
//    @NotBlank(message = "O número deve ser informado!")
//    @Length(min=8, max=12, message = "O número não deve ter mais que {max} e nem menos que {min} caracteres!")
//    @Column(name="numero", nullable = false, length = 12)
//    private String numero;
    
    @NotBlank(message = "O tipo deve ser informado!")
    @Length(max=50, message = "O tipo não pode ter mais que {max} caracteres!")
    @Column(name="tipo", nullable = false, length = 50)
    private String tipo;

    public Telefone() {
    }

    public String getCodigo_pais() {
        return codigo_pais;
    }

    public void setCodigo_pais(String codigo_pais) {
        this.codigo_pais = codigo_pais;
    }

    public String getCodigo_area() {
        return codigo_area;
    }

    public void setCodigo_area(String codigo_area) {
        this.codigo_area = codigo_area;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public TelefoneId getTelefoneId() {
        return telefoneId;
    }

    public void setTelefoneId(TelefoneId telefoneId) {
        this.telefoneId = telefoneId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.telefoneId);
        return hash;
    }

   
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Telefone other = (Telefone) obj;
        if (!Objects.equals(this.telefoneId, other.telefoneId)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Telefone{" + "telefoneId=" + telefoneId + ", tipo=" + tipo + '}';
    }
    
    
    
}
