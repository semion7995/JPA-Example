package EntityExtendsEntity.OneTableAllClass;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.Transactional;

public class AsiaManTest {
    EntityManagerFactory entityManagerFactory;
    AsiaMan asiaMan;
    @Before
    public void setUp(){
        asiaMan = new AsiaMan();
        asiaMan.setName("Alik");
        asiaMan.setNational("I'm Asian Man ");
        entityManagerFactory = Persistence.createEntityManagerFactory("ru.easyjava.data.jpa.hibernate");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(asiaMan);
        entityManager.getTransaction().commit();
        entityManager.close();

    }


    public AsiaMan getAsiaManTest(){
        System.out.println("getAsianTest");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        AsiaMan from_asiaMan = (AsiaMan) entityManager.createQuery("from AsiaMan");
        entityManager.getTransaction().commit();


        //.forEach(asiaMan->{
        //  System.out.println("ID:" + ((AsiaMan) asiaMan).getId());
        //System.out.println("Name:" +((AsiaMan) asiaMan).getName());
        //System.out.println("National:" +((AsiaMan) asiaMan).getNational());
        // System.out.println();
        //});
        entityManager.close();
        return from_asiaMan;
    }
    @Test

    public void refreshAsiaManTest(){
        asiaMan = getAsiaManTest();
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        asiaMan = entityManager.find(AsiaMan.class, asiaMan);
        asiaMan.setName("Anton");
        asiaMan.setName("I'm New Asia Man ");
        entityManager.getTransaction().begin();
        entityManager.merge(asiaMan);
        entityManager.refresh(asiaMan);
        entityManager.getTransaction().commit();
        getAsiaManTestTwo();
        entityManager.close();
    }
    @Test
    public void getAsiaManTestTwo(){
        System.out.println("getAsianTest Two");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.createQuery("from AsiaMan").getResultList().forEach(asiaMan->{
            System.out.println("ID:" + ((AsiaMan) asiaMan).getId());
            System.out.println("Name:" +((AsiaMan) asiaMan).getName());
            System.out.println("National:" +((AsiaMan) asiaMan).getNational());
            System.out.println();
        });
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    public void afterResultTest(){
        System.out.println("afterResultTest");
    }


}