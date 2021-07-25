package EntityExtendsNormalClass;

import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.math.BigDecimal;

import static org.junit.Assert.*;

public class AdultTest {
    EntityManagerFactory entityManagerFactory;
    @Before
    public void setUp() {
    Adult adult = new Adult();
    adult.setAccountId(1);
    adult.setAmount(BigDecimal.TEN);
        entityManagerFactory = Persistence.createEntityManagerFactory("ru.easyjava.data.jpa.hibernate");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(adult);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    public void adultReadTest(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.createQuery("from Adult ").getResultList().forEach(adult->{
            System.out.println(((Adult) adult).getId());
            System.out.println(((Adult) adult).getAccountId());
            System.out.println(((Adult) adult).getAmount());
        });

    }

}