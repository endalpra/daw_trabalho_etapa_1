package br.edu.ifsul.testes;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Agencia;
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
public class TestePersistirAgencia {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirAgencia() {
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
            Agencia a = new Agencia();
            a.setCep("22011234");
            a.setEndereco("Rua dos Andrades 1243");
            a.setNome_gerente("Pedro Rosa");
            a.setNumero("334354");
            em.getTransaction().begin();
            em.persist(a);
            em.getTransaction().commit();
        } catch (Exception e) {
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
}
