package br.edu.ifsul.testes;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Cliente;
import br.edu.ifsul.modelo.Historico;
import java.util.Calendar;
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
public class TestePersistirHistorico {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirHistorico() {
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
            Historico h = new Historico();
            h.setCliente(em.find(Cliente.class, 1));
            h.setData(Calendar.getInstance());
            h.setNum_conta("123456789012345");
            h.setTipo_operacao("Saque");
            h.setValor(400.00);

            em.getTransaction().begin();
            em.persist(h);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
}
