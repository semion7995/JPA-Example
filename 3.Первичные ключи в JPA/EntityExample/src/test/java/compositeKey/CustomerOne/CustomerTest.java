package compositeKey.CustomerOne;

import compositeKey.CustomerSecond.CompositeKeySecond;
import compositeKey.CustomerSecond.CustomerSecond;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.*;

public class CustomerTest {
    private EntityManagerFactory entityManagerFactory;
    @Before
    public void settUp(){
        var customer  = new Customer ();
        var compositeKey  = new CompositeKey ();
        customer.setName("Semen Zhukov");
        customer.setPassportSeries("4017");
        customer.setPassportNumber("746733");

        entityManagerFactory = Persistence.createEntityManagerFactory("ru.easyjava.data.jpa.hibernate");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(customer );
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    public void testGreeter(){
        entityManagerFactory = Persistence.createEntityManagerFactory("ru.easyjava.data.jpa.hibernate");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createNamedQuery("CustomerSecond.testGreeter", CustomerSecond.class).getResultList().forEach(System.out::println);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}