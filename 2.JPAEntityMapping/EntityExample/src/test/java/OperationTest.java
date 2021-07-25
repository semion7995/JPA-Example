import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.time.ZonedDateTime;

import static org.junit.Assert.*;

public class OperationTest {
    private EntityManagerFactory entityManagerFactory;
    @Before
    public void setUp() throws Exception{
        Operation op = new Operation();

        op.setId(1L);
        op.setAccountId(100500);
        op.setAmount(BigDecimal.TEN);
        op.setTimestamp(ZonedDateTime.now());
        op.setDescription("Test operation");
        op.setOpCode(9000);

        entityManagerFactory = Persistence.createEntityManagerFactory("ru.easyjava.data.jpa.hibernate");
        EntityManager em = entityManagerFactory.createEntityManager();
        em.getTransaction().begin();
        em.persist(op);
        em.getTransaction().commit();
        em.close();
    }
    @Test
    public void testReadObject(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createNamedQuery("Operation.testReadObject", Operation.class).getResultList()
                .forEach(System.out::println);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}