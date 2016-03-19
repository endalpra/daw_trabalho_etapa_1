package br.edu.ifsul.testes;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Cliente;
import br.edu.ifsul.modelo.Seguro;
import java.util.Calendar;
import java.util.Locale;
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
public class TestePersistirSeguro {
    EntityManagerFactory emf;
    EntityManager em;
    public TestePersistirSeguro() {
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
            Seguro s = new Seguro();
          s.setCliente(em.find(Cliente.class, 1));
          s.setData_inicio(Calendar.getInstance());
          s.setQtd_parcelas(4);
          s.setTipo("Automotivo");
          s.setValor_cobertura(30000.00);
          
            em.getTransaction().begin();
            em.persist(s);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
}
