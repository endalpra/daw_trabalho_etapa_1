package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "convenio")
public class Convenio implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_convenio", sequenceName = "seq_convenio_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_convenio", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotBlank(message = "O nome deve ser informado")
    @Length(max = 50, message = "O nome não pode ter mais de {max} caracteres")
    @Column(name = "nome", length = 50, nullable = false)
    private String nome;

    @NotNull(message = "A taxa/mês deve ser informado")
    @Column(name = "taxa_mes", nullable = false, columnDefinition = "decimal(12,2)")
    private Double taxa_mes;

    @NotNull(message = "O valor máximo de cobertura deve ser informado")
    @Column(name = "valor_cobertura", nullable = false, columnDefinition = "decimal(12,2)")
    private Double valor_cobertura;

    @NotNull(message = "A data deve ser informada!")
    @Temporal(TemporalType.DATE)
    @Column(name = "data_abertura", nullable = false)
    private Calendar data_inicio;

    @ManyToMany
    @JoinTable(name = "convenio_cliente",
            joinColumns
            = @JoinColumn(name = "convenio", referencedColumnName = "id",
                    nullable = false),
            inverseJoinColumns
            = @JoinColumn(name = "cliente", referencedColumnName = "id",
                    nullable = false))
    private List<Cliente> clientes = new ArrayList<>();

    public Convenio() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getTaxa_mes() {
        return taxa_mes;
    }

    public void setTaxa_mes(Double taxa_mes) {
        this.taxa_mes = taxa_mes;
    }

    public Double getValor_cobertura() {
        return valor_cobertura;
    }

    public void setValor_cobertura(Double valor_cobertura) {
        this.valor_cobertura = valor_cobertura;
    }

    public Calendar getData_inicio() {
        return data_inicio;
    }

    public void setData_inicio(Calendar data_inicio) {
        this.data_inicio = data_inicio;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public String toString() {
        return "Convenio{" + "nome=" + nome + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Convenio other = (Convenio) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

 
}
