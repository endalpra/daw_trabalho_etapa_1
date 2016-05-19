package br.edu.ifsul.testes;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Cliente;
import br.edu.ifsul.modelo.Convenio;
import br.edu.ifsul.modelo.Telefone;
import java.util.ArrayList;
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
            c.setCep("99018461");
            c.setEmail("adao@gmail.com");
            c.setEndereco("AV. Brasil 676");
            c.setNome("Luana Alim");

//            Telefone t = new Telefone();
//            t.setCodigo_area("54");
//            t.setCodigo_pais("55");
//            t.getTelefoneId().setNumero(99859466);
//            t.setTipo("cel");
//            c.adicionarTelefone(t);

            ArrayList<Convenio> lista = new ArrayList<>();
            Convenio co = em.find(Convenio.class, 1);
            lista.add(co);
            Convenio con = em.find(Convenio.class, 4);
            lista.add(con);
            c.setConvenios(lista);
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
