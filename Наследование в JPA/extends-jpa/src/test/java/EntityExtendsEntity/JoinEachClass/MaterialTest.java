package EntityExtendsEntity.JoinEachClass;

import org.junit.Before;
import org.junit.Test;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MaterialTest {
    private EntityManagerFactory entityManagerFactory;
    private Material material;
    @Before
    public void setUp() throws Exception {
        material = new Material();
        material.setWorkName("building");
        material.setNameMaterial("brick");
        entityManagerFactory = Persistence.createEntityManagerFactory("ru.easyjava.data.jpa.hibernate");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(material);
        entityManager.createNamedQuery("Material.test").getResultList().forEach(matr->{
            System.out.println(((Material) matr).getId());
            System.out.println(((Material) matr).getWorkName());
            System.out.println(((Material) matr).getNameMaterial());
            System.out.println();
        });

        entityManager.getTransaction().commit();
        entityManager.close();
    }
    @Test
    public void testMerge() throws Exception {

        entityManagerFactory = Persistence.createEntityManagerFactory("ru.easyjava.data.jpa.hibernate");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Material material = entityManager.merge(this.material);
        material.setNameMaterial("clay");
        material.setWorkName("sculpt");
        entityManager.createNamedQuery("Material.test").getResultList().forEach(matr->{
            System.out.println(((Material) matr).getId());
            System.out.println(((Material) matr).getWorkName());
            System.out.println(((Material) matr).getNameMaterial());
            System.out.println();
        });
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}