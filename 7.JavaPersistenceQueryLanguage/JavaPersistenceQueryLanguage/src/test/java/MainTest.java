import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.*;

public class MainTest {

    EntityManagerFactory entityManagerFactory;

    @Test
    public void setUp() throws Exception {
    entityManagerFactory = Persistence.createEntityManagerFactory("ru.easyjava.data.jpa.hibernate");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    entityManager.getTransaction().begin();
    entityManager.createQuery("from Citizen").getResultList()
    .forEach(System.out::println);
    entityManager.getTransaction().commit();
    }
}