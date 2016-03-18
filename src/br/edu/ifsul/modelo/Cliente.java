package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Érico
 */
@Entity
@Table(name="cliente")
public class Cliente implements Serializable{
    @Id
    @SequenceGenerator(name="seq_cliente", sequenceName="seq_cliente_id", allocationSize = 1)
    @GeneratedValue(generator="seq_cliente", strategy = GenerationType.SEQUENCE)
    private Integer id;
    
    @NotBlank(message="O nome deve ser informado!")
    @Length(max=50, message="O nome não deve ultrapassar {max} caracteres!")
    @Column(name="nome", nullable=false, length = 50)
    private String nome;
    
    @NotBlank(message="O email deve ser informado!")
    @Length(max=30, message="O email não deve ultrapassar {max} caracteres!")
    @Column(name="email", nullable=false, length = 30)
    private String email;
    
    @NotBlank(message="O endereço deve ser informado!")
    @Length(max=40, message="O endereço não deve ultrapassar {max} caracteres!")
    @Column(name="endereco", nullable=false, length = 40)
    private String endereco;
    
    @NotBlank(message="O cep deve ser informado!")
    @Length(max=8, message="O CEP deve ser válido! Use somente números!")
    @Column(name="cep", nullable=false, length = 8)
    private String cep;

    public Cliente() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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
        final Cliente other = (Cliente) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Cliente{" + "nome=" + nome + '}';
    }
    
    
}
