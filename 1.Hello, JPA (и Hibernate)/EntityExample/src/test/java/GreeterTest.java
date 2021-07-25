import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;


public class GreeterTest {
private EntityManagerFactory entityManagerFactory;

    @Before
    public void persistJPAExample() {
        Greeter greetJpa = new Greeter();
        greetJpa.setGreeting("Hello");
        greetJpa.setTarget("JPA");

        Greeter greetHibernate = new Greeter();
        greetHibernate.setGreeting("Hello");
        greetHibernate.setTarget("Hibernate");

        entityManagerFactory = Persistence.createEntityManagerFactory("ru.easyjava.data.jpa.hibernate");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(greetJpa);
        entityManager.persist(greetHibernate);
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    @Test
    public void readEntityJPA() {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createNamedQuery("Greeter.readEntityJPA", Greeter.class).getResultList()
                .forEach(g-> System.out.println(String.format(g.getGreeting() + ":" + g.getTarget())));
        entityManager.getTransaction().commit();
        entityManager.close();
    }

}