package br.edu.ifsul.testes;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Érico
 */
public class TestePersistirCliente {
  EntityManagerFactory emf;
    EntityManager em;     
    public TestePersistirCliente() {
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
            Cliente c = new Cliente();
            c.setCep("99010140");
            c.setEmail("ana@hotmail.com");
            c.setEndereco("AV. Brasil 257");
            c.setNome("Ana das Neves");                 
            
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
