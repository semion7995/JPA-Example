package EntityExtendsEntity.OneTableAllClass;

import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.*;

public class AsiaManTestThree {
    private EntityManagerFactory entityManagerFactory;
    private AsiaMan asiaMan;

    @Before
    public void setUp() {
        asiaMan = new AsiaMan();
        asiaMan.setName("Semen");
        asiaMan.setNational("Russia");

        entityManagerFactory = Persistence.createEntityManagerFactory("ru.easyjava.data.jpa.hibernate");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(asiaMan);
        entityManager.flush();
        asiaMan.setName("Anton");
        asiaMan.setNational("Korea");
        entityManager.createQuery("from AsiaMan").getResultList().forEach(System.out::println);
        entityManager.getTransaction().commit();
        entityManager.close();

    }

    @Test
    public void removeObject(){
        var entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        AsiaMan merge = entityManager.merge(asiaMan);// op is MANAGED now
        entityManager.refresh(merge); // OP is still MANAGED and reloaded from the DB
        merge.setNational("Kuba");
        merge.setName("Piton");
        entityManager.createQuery("from AsiaMan").getResultList().forEach(System.out::println);
        entityManager.getTransaction().commit();
        entityManager.clear(); // op is DETACHED now
        entityManager.close();
    }


}