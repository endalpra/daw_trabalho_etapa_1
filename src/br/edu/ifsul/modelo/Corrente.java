package br.edu.ifsul.modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Érico
 */
@Entity
@Table(name="corrente")
public class Corrente extends Conta implements Serializable{

    @NotNull(message="O limite de saque deve ser informado!")
    @Column(name="limite_de_saque", nullable=false, columnDefinition = "decimal(12,2)")
    private Double limite_de_saque;

    public Corrente() {
    }
    
    public Double getLimite_de_saque() {
        return limite_de_saque;
    }

    public void setLimite_de_saque(Double limite_de_saque) {
        this.limite_de_saque = limite_de_saque;
    }
    
    
}
