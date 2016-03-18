package br.edu.ifsul.testes;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Agencia;
import br.edu.ifsul.modelo.Cliente;
import br.edu.ifsul.modelo.Corrente;
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
public class TestePersistirCorrente {
   EntityManagerFactory emf;
    EntityManager em;    
    public TestePersistirCorrente() {
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
            Corrente c = new Corrente();            
            c.setAtiva(true);
            c.setData_abertura(Calendar.getInstance());         
            c.setNumero("123456789012345");
            c.setSaldo(25000.00);
            c.setLimite_de_saque(12000.00);
            c.setCliente(em.find(Cliente.class, 1));
            c.setAgencia(em.find(Agencia.class, 1));
            em.getTransaction().begin();
            em.persist(c);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
}
