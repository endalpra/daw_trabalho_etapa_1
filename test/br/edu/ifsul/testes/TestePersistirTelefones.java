package br.edu.ifsul.testes;

import br.edu.ifsul.jpa.EntityManagerUtil;
import br.edu.ifsul.modelo.Cliente;
import br.edu.ifsul.modelo.Telefone;
import br.edu.ifsul.modelo.TelefoneId;
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
public class TestePersistirTelefones {
   EntityManagerFactory emf;
    EntityManager em; 
    public TestePersistirTelefones() {
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
    public void teste(){
        boolean exception = false;
        try{
         Telefone t = new Telefone();
         TelefoneId id = new TelefoneId();
         t.setCodigo_area("54");
         t.setCodigo_pais("55");
         t.setTipo("Celular");
         //Número e Cliente compõe a chave primária composta de telefone
         id.setCliente(em.find(Cliente.class, 2));
         id.setNumero(91876431);
         t.setTelefoneId(id);
        
       
           em.getTransaction().begin();
           em.persist(t);
           em.getTransaction().commit();
        }catch(Exception e){
            exception = true;
            e.printStackTrace();
        }
        Assert.assertEquals(false, exception);
    }
}
