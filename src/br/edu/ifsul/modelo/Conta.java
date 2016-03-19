package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
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
@Inheritance(strategy = InheritanceType.JOINED)//Usado para permitir que forneça herança
@Table(name = "conta")
public abstract class Conta implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_conta", sequenceName = "seq_conta_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_conta", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotBlank(message = "O número deve ser informado!")
    @Length(min = 15, max = 25, message = "O número não pode ter menos dígitos que {min} e nem mais que {max}!")
    @Column(name = "nome", length = 25, nullable = false)
    private String numero;

    @NotNull(message = "O saldo deve ser informado!")
    @Column(name = "saldo", nullable = false, columnDefinition = "decimal(12,2)")
    private Double saldo;

    @NotNull(message = "A data deve ser informada!")
    @Temporal(TemporalType.DATE)
    @Column(name = "data_abertura", nullable = false)
    private Calendar data_abertura;

    @NotNull(message = "Situação da conta deve ser informada!")
    @Column(name = "ativa", nullable = false)
    private Boolean ativa;

    @ManyToOne
    @NotNull(message = "O cliente deve ser informado!")
    @JoinColumn(name = "cliente", referencedColumnName = "id", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @NotNull(message = "A agência deve ser informada!")
    @JoinColumn(name = "agencia", referencedColumnName = "id", nullable = false)
    private Agencia agencia;

    public Conta() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Calendar getData_abertura() {
        return data_abertura;
    }

    public void setData_abertura(Calendar data_abertura) {
        this.data_abertura = data_abertura;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    public void setAtiva(Boolean ativa) {
        this.ativa = ativa;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 13 * hash + Objects.hashCode(this.id);
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
        final Conta other = (Conta) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Conta{" + "numero=" + numero + '}';
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

}
