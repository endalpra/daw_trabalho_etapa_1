package br.edu.ifsul.modelo;

import java.io.Serializable;
import java.util.Calendar;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Érico
 */

@Entity
@Table(name="poupanca")
public class Poupanca extends Conta implements Serializable {
    @NotNull(message="A taxa de atualização deve ser informada!")
    @Column(name="taxa_atualizacao", nullable = false, columnDefinition = "decimal(12,2)")
    private Double taxa_atualizacao;
    
    @NotNull(message="A data de atualização deve ser informada!")
    @Temporal(TemporalType.DATE)
    @Column(name="data_atualizacao", nullable=false)
    private Calendar data_atualizacao;

    public Poupanca() {
    }
    
    public Double getTaxa_atualizacao() {
        return taxa_atualizacao;
    }

    public void setTaxa_atualizacao(Double taxa_atualizacao) {
        this.taxa_atualizacao = taxa_atualizacao;
    }

    public Calendar getData_atualizacao() {
        return data_atualizacao;
    }

    public void setData_atualizacao(Calendar data_atualizacao) {
        this.data_atualizacao = data_atualizacao;
    }
    
    
    
}
