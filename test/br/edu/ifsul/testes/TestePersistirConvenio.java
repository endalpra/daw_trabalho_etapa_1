package br.edu.ifsul.testes;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Cliente;
import br.edu.ifsul.modelo.Convenio;
import java.util.Calendar;
import java.util.List;
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
public class TestePersistirConvenio {    
    EntityManagerFactory emf;
    EntityManager em;
    
    public TestePersistirConvenio() {
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
            Convenio c = new Convenio();
           c.setData_inicio(Calendar.getInstance());
           c.setNome("Saúde");
           c.setTaxa_mes(19.98);
           c.setValor_cobertura(10000.00);
           
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
