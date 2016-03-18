package br.edu.ifsul.testes;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Agencia;
import br.edu.ifsul.modelo.Cliente;
import br.edu.ifsul.modelo.Poupanca;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Érico
 */
public class TestePersistirPoupanca {
    EntityManagerFactory emf;
    EntityManager em;
    public TestePersistirPoupanca() {
    }
    
    @Before
    public void setUp() {
         em = EntityManagerUtil.getEntityManager();
    }
    
    @After
    public void tearDown() {
         em.close();
    }
    
     @Test
    public void teste() {
        boolean exception = false;
        try {
            Poupanca poupanca = new Poupanca();
            poupanca.setAtiva(true);
            poupanca.setData_abertura(Calendar.getInstance());
            poupanca.setData_atualizacao(Calendar.getInstance());
            poupanca.setNumero("123456789012345");
            poupanca.setSaldo(2000.55);
            poupanca.setTaxa_atualizacao(0.8);
            poupanca.setCliente(em.find(Cliente.class, 2));
            poupanca.setAgencia(em.find(Agencia.class, 1));
            em.getTransaction().begin();
            em.persist(poupanca);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
    
}
