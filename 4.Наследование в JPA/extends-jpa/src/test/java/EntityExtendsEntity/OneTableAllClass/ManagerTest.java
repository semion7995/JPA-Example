package EntityExtendsEntity.OneTableAllClass;

import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import static org.junit.Assert.*;

public class ManagerTest {
    private Manager manager;
    private EntityManagerFactory entityManagerFactory;
    @Before
    public void setUp() throws Exception {
        manager = new Manager();
        manager.setName("Manager create");
        manager.setManagerGroup(2l);

        entityManagerFactory = Persistence.createEntityManagerFactory("ru.easyjava.data.jpa.hibernate");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(manager);
        entityManager.createQuery("from Manager ").getResultList().forEach(manager->{
            System.out.println(((Manager) manager).getName());
            System.out.println(((Manager) manager).getManagerGroup());
            System.out.println(((Manager) manager).getId());
        });
        entityManager.getTransaction().commit();
        entityManager.close();
    }
    @Test
    public void testMerge(){
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Manager manager = entityManager.merge(this.manager);
        manager.setManagerGroup(3L);
        manager.setName("test Manager merge");
        entityManager.createQuery("from Manager ").getResultList().forEach(man->{
            System.out.println(((Manager) man).getName());
            System.out.println(((Manager) man).getManagerGroup());
            System.out.println(((Manager) man).getId());
        });
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}