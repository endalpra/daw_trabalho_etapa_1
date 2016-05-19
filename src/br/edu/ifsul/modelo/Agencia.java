package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Érico
 */
@Entity
@Table(name = "agencia")
public class Agencia implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_agencia", sequenceName = "seq_agencia_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_agencia", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotBlank(message = "O nome deve ser informado!")
    @Length(max = 50, message = "O nome não deve ultrapassar {max} caracteres!")
    @Column(name = "nome_gerente", nullable = false, length = 50)
    private String nome_gerente;

    @NotBlank(message = "O número deve ser informado!")
    @Length(max = 30, message = "O numero não deve ultrapassar {max} caracteres!")
    @Column(name = "numero", nullable = false, length = 30)
    private String numero;

    @NotBlank(message = "O CEP deve ser informado!")
    @Length(max = 8, message = "O CEP não deve ultrapassar {max} caracteres!")
    @Column(name = "cep", nullable = false, length = 8)
    private String cep;

    @NotBlank(message = "O endereço deve ser informado!")
    @Length(max = 50, message = "O endereço não deve ultrapassar {max} caracteres!")
    @Column(name = "endereco", nullable = false, length = 50)
    private String endereco;

    @OneToMany(mappedBy = "agencia", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Conta> contas = new ArrayList<>();
    
    public Agencia() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome_gerente() {
        return nome_gerente;
    }

    public void setNome_gerente(String nome_gerente) {
        this.nome_gerente = nome_gerente;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 17 * hash + Objects.hashCode(this.id);
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
        final Agencia other = (Agencia) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Agencia{" + "nome_gerente=" + nome_gerente + ", numero=" + numero + '}';
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }

}
