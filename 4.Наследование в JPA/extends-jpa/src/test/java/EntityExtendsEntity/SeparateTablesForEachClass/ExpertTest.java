package EntityExtendsEntity.SeparateTablesForEachClass;

import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.time.LocalDate;

import static org.junit.Assert.*;

public class ExpertTest {
    private EntityManagerFactory entityManagerFactory;
    private Expert expert;
    @Before
    public void setUp() throws Exception {
        expert = new Expert();
        expert.setAbility("study sample");
        expert.setExpertiseName("visual inspection");
        expert.setTimeIsOver(LocalDate.of(2020, 2, 2));

        entityManagerFactory = Persistence.createEntityManagerFactory("ru.easyjava.data.jpa.hibernate");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        entityManager.persist(expert);
        entityManager.createNamedQuery("Expert.test").getResultList().forEach(ex->{
            System.out.println(((Expert) ex).getId());
            System.out.println(((Expert) ex).getAbility());
            System.out.println(((Expert) ex).getExpertiseName());
            System.out.println(((Expert) ex).getTimeIsOver());
            System.out.println();
        });

        entityManager.getTransaction().commit();
    }
    @Test
    public void expertTest() throws Exception {
        entityManagerFactory = Persistence.createEntityManagerFactory("ru.easyjava.data.jpa.hibernate");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        Expert expert = entityManager.merge(this.expert);
        expert.setAbility("new Ability");
        expert.setExpertiseName("new Exp");
        expert.setTimeIsOver(LocalDate.now());
        entityManager.createNamedQuery("Expert.test").getResultList().forEach(ex->{
            System.out.println(((Expert) ex).getId());
            System.out.println(((Expert) ex).getAbility());
            System.out.println(((Expert) ex).getExpertiseName());
            System.out.println(((Expert) ex).getTimeIsOver());
            System.out.println();
        });

        entityManager.getTransaction().commit();
    }
}