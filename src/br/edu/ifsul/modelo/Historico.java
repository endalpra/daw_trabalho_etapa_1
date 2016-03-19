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
@Table(name = "historico")
public class Historico implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_historico", sequenceName = "seq_historico_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_historico", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotBlank(message = "O tipo da operação deve ser informado!")
    @Length(max = 30, message = "O tipo não pode ultrapassar {max} caracteres!")
    @Column(name = "tipo_operacao", length = 30, nullable = false)
    private String tipo_operacao;

    @NotNull(message = "A data deve ser informada")
    @Temporal(TemporalType.DATE)
    @Column(name = "data", nullable = false)
    private Calendar data;

    @NotBlank(message = "O número deve ser informado!")
    @Length(min = 15, max = 25, message = "O número não pode ter menos dígitos que {min} e nem mais que {max}!")
    @Column(name = "nome", length = 25, nullable = false)
    private String num_conta;

    private Double valor;

    @ManyToOne
    @NotNull(message = "O cliente deve ser informado")
    @JoinColumn(name = "cliente", referencedColumnName = "id", nullable = false)
    private Cliente cliente;

    public Historico() {
    }

    public String getTipo_operacao() {
        return tipo_operacao;
    }

    public void setTipo_operacao(String tipo_operacao) {
        this.tipo_operacao = tipo_operacao;
    }

    public Calendar getData() {
        return data;
    }

    public void setData(Calendar data) {
        this.data = data;
    }

    public String getNum_conta() {
        return num_conta;
    }

    public void setNum_conta(String num_conta) {
        this.num_conta = num_conta;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
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
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final Historico other = (Historico) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Historico{" + "tipo_operacao=" + tipo_operacao + '}';
    }
    
    
}
