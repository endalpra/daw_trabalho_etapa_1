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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "cliente")
public class Cliente implements Serializable {

    @Id
    @SequenceGenerator(name = "seq_cliente", sequenceName = "seq_cliente_id", allocationSize = 1)
    @GeneratedValue(generator = "seq_cliente", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotBlank(message = "O nome deve ser informado!")
    @Length(max = 50, message = "O nome não deve ultrapassar {max} caracteres!")
    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @NotBlank(message = "O email deve ser informado!")
    @Length(max = 30, message = "O email não deve ultrapassar {max} caracteres!")
    @Column(name = "email", nullable = false, length = 30)
    private String email;

    @NotBlank(message = "O endereço deve ser informado!")
    @Length(max = 40, message = "O endereço não deve ultrapassar {max} caracteres!")
    @Column(name = "endereco", nullable = false, length = 40)
    private String endereco;

    @NotBlank(message = "O cep deve ser informado!")
    @Length(max = 8, message = "O CEP deve ser válido! Use somente números!")
    @Column(name = "cep", nullable = false, length = 8)
    private String cep;

    @ManyToMany
    @JoinTable(name = "convenio_cliente",
            joinColumns
            = @JoinColumn(name = "cliente", referencedColumnName = "id",
                    nullable = false),
            inverseJoinColumns
            = @JoinColumn(name = "convenio", referencedColumnName = "id",
                    nullable = false))
    private List<Convenio> convenios = new ArrayList<>();
    
    //telefoneId.cliente se refere ao atributo da classe Telefone, estabelece a relação com a classe Cliente
    @OneToMany(mappedBy="telefoneId.cliente", cascade= CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Telefone> telefones = new ArrayList<>();

    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Historico> historicos = new ArrayList<>();
    
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Seguro> seguros = new ArrayList<>();
    
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL,
            orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Conta> contas = new ArrayList<>();
    
    public Cliente() {
    }
    
    public void adicionarTelefone(Telefone obj){
        obj.getTelefoneId().setCliente(this);
        this.telefones.add(obj);
    }
    
    public void removerTelefone(int index){
        this.telefones.remove(index);
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

    public List<Convenio> getConvenios() {
        return convenios;
    }

    public void setConvenios(List<Convenio> convenios) {
        this.convenios = convenios;
    }

    public List<Telefone> getTelefones() {
        return telefones;
    }

    public void setTelefones(List<Telefone> telefones) {
        this.telefones = telefones;
    }

    public List<Historico> getHistoricos() {
        return historicos;
    }

    public void setHistoricos(List<Historico> historicos) {
        this.historicos = historicos;
    }

    public List<Seguro> getSeguros() {
        return seguros;
    }

    public void setSeguros(List<Seguro> seguros) {
        this.seguros = seguros;
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void setContas(List<Conta> contas) {
        this.contas = contas;
    }
  

}
