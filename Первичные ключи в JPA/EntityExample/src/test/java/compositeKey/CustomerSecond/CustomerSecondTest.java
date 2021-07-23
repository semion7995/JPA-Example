package compositeKey.CustomerSecond;

import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class CustomerSecondTest {
    private EntityManagerFactory entityManagerFactory;
    @Before
    public void settUp(){
        var customerSecond = new CustomerSecond();
        var compositeKeySecond = new CompositeKeySecond();
        customerSecond.setPassport(compositeKeySecond);
        customerSecond.getPassport().setPassportNumber("746733");
        customerSecond.getPassport().setPassportSeries("3310");
        customerSecond.setName("Semen");

        entityManagerFactory = Persistence.createEntityManagerFactory("ru.easyjava.data.jpa.hibernate");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(customerSecond);
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