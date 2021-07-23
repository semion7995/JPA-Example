package EntityExtendsEntity.OneTableAllClass;

import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.*;

public class AsiaManTestTwo {
    EntityManagerFactory entityManagerFactory;
    //AsiaMan asiaMan;
    //EntityManager entityManager;

    @Test
    public void setUp(){
        AsiaMan asiaMan = new AsiaMan();
        asiaMan.setName("Alik");
        asiaMan.setNational("I'm Asian Man ");
        entityManagerFactory = Persistence.createEntityManagerFactory("ru.easyjava.data.jpa.hibernate");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(asiaMan);
        System.out.println(asiaMan);
        entityManager.flush();
        entityManager.remove(asiaMan);
        entityManager.persist(asiaMan);
        entityManager.createQuery("from AsiaMan ").getResultList().forEach(System.out::println);




        asiaMan.setName("Semen");
        asiaMan.setNational("Asia");
        entityManager.getTransaction().commit();
        entityManager.close();



        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        asiaMan = entityManager.merge(asiaMan);
        entityManager.refresh(asiaMan);
        entityManager.createQuery("from AsiaMan ").getResultList().forEach(System.out::println);

        entityManager.getTransaction().commit();
        entityManager.clear();
        /**
         *  /**
         *      * entityManagerFactory = Persistence.createEntityManagerFactory("ru.easyjava.data.jpa.hibernate");
         *      *
         *      *         //New op
         *      *         Operation op = new Operation();
         *      *
         *      *         op.setId(1L);
         *      *         op.setAccountId(100500);
         *      *         op.setAmount(BigDecimal.TEN);
         *      *         op.setTimestamp(ZonedDateTime.now());
         *      *         op.setDescription("Test operation");
         *      *         op.setOpCode(9000);
         *      *
         *      *         EntityManager em = entityManagerFactory.createEntityManager();
         *      *         em.getTransaction().begin();
         *      *         em.persist(op); // op is MANAGED now
         *      *         em.flush();
         *      *
         *      *         em.remove(op); // op is REMOVED now
         *      *         em.persist(op); // op is MANAGED now
         *      *         op.setDescription("New operation name.");
         *      *         em.getTransaction().commit();
         *      *         em.close(); // op is DETACHED now
         *      *
         *      *         //Merge back
         *      *         em = entityManagerFactory.createEntityManager();
         *      *         em.getTransaction().begin();
         *      *         op = em.merge(op); // op is MANAGED now
         *      *         em.refresh(op); // OP is still MANAGED and reloaded from the DB
         *      *         em.getTransaction().commit();
         *      *         em.clear(); // op is DETACHED now
         *      */

    }
}