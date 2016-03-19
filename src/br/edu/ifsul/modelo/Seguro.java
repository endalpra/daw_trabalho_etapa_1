package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Érico
 */
@Entity
@Table(name = "seguro")
public class Seguro implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_seguro", sequenceName = "seq_seguro_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_seguro", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotBlank(message = "O tipo deve ser informado")
    @Length(max = 30, message = "O tipo não pode ter mais que {max} caracteres!")
    @Column(name = "tipo", length = 30, nullable = false)
    private String tipo;

    @NotNull(message = "A data deve ser informada!")
    @Temporal(TemporalType.DATE)
    @Column(name = "data_inicio", nullable = false)
    private Calendar data_inicio;

    @NotNull(message = "A quantidade de parcelas deve ser informada!")
    private Integer qtd_parcelas;

    @NotNull(message = "O valor da cobertura deve ser informado!")
    @Column(name = "valor_cobertura", nullable = false, columnDefinition = "decimal(12,2)")
    private Double valor_cobertura;

    @ManyToOne
    @NotNull(message = "O cliente deve ser informado!")
    @JoinColumn(name = "cliente", referencedColumnName = "id", nullable = false)
    private Cliente cliente;

    public Seguro() {
    }

    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Calendar getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Calendar data_inicio) {
        this.data_inicio = data_inicio;
    }

    public Integer getQtd_parcelas() {
        return qtd_parcelas;
    }

    public void setQtd_parcelas(Integer qtd_parcelas) {
        this.qtd_parcelas = qtd_parcelas;
    }

    public Double getValor_cobertura() {
        return valor_cobertura;
    }

    public void setValor_cobertura(Double valor_cobertura) {
        this.valor_cobertura = valor_cobertura;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
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
        final Seguro other = (Seguro) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Seguro{" + "tipo=" + tipo + ", valor_cobertura=" + valor_cobertura + '}';
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

}
