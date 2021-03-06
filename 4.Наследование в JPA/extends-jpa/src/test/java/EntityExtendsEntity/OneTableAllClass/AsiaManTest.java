package EntityExtendsEntity.OneTableAllClass;

import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class AsiaManTest {
    EntityManagerFactory entityManagerFactory;
    AsiaMan asiaMan;
    EntityManager entityManager;

    @Before
    public void setUp(){
        asiaMan = new AsiaMan();
        asiaMan.setName("Alik");
        asiaMan.setNational("I'm Asian Man ");
        entityManagerFactory = Persistence.createEntityManagerFactory("ru.easyjava.data.jpa.hibernate");
        entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(asiaMan);
        entityManager.flush();
        entityManager.createQuery("from AsiaMan").getResultList().forEach(man->{
            System.out.println(asiaMan.getId());
            System.out.println(asiaMan.getNational());
            System.out.println(asiaMan.getName());
            System.out.println();
        });
        entityManager.getTransaction().commit();
        entityManager.close();
    }


    @Test
    public void refreshAsiaManTest(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        AsiaMan merge = entityManager.merge(asiaMan);
        entityManager.refresh(merge);
        merge.setName("Anton");
        merge.setNational("I'm New Russian ");
        entityManager.createQuery("from AsiaMan").getResultList().forEach(man->{
            System.out.println(merge.getId());
            System.out.println(merge.getNational());
            System.out.println(merge.getName());
            System.out.println();
        });

        entityManager.flush();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    /**
     * entityManagerFactory = Persistence.createEntityManagerFactory("ru.easyjava.data.jpa.hibernate");
     *
     *         //New op
     *         Operation op = new Operation();
     *
     *         op.setId(1L);
     *         op.setAccountId(100500);
     *         op.setAmount(BigDecimal.TEN);
     *         op.setTimestamp(ZonedDateTime.now());
     *         op.setDescription("Test operation");
     *         op.setOpCode(9000);
     *
     *         EntityManager em = entityManagerFactory.createEntityManager();
     *         em.getTransaction().begin();
     *         em.persist(op); // op is MANAGED now
     *         em.flush();
     *
     *         em.remove(op); // op is REMOVED now
     *         em.persist(op); // op is MANAGED now
     *         op.setDescription("New operation name.");
     *         em.getTransaction().commit();
     *         em.close(); // op is DETACHED now
     *
     *         //Merge back
     *         em = entityManagerFactory.createEntityManager();
     *         em.getTransaction().begin();
     *         op = em.merge(op); // op is MANAGED now
     *         em.refresh(op); // OP is still MANAGED and reloaded from the DB
     *         em.getTransaction().commit();
     *         em.clear(); // op is DETACHED now
     */

}