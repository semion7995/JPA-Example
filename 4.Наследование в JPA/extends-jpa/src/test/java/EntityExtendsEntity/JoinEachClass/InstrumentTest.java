package EntityExtendsEntity.JoinEachClass;

import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import static org.junit.Assert.*;

public class InstrumentTest {
    private EntityManagerFactory entityManagerFactory;
    private Instrument instrument;
    @Before
    public void setUp() throws Exception {
        instrument = new Instrument();
        instrument.setWorkName("Development");
        instrument.setNameInstrument("brain");
        entityManagerFactory = Persistence.createEntityManagerFactory("ru.easyjava.data.jpa.hibernate");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(instrument);
        entityManager.createNamedQuery("Instrument.test").getResultList().forEach(instr->{
            System.out.println(((Instrument) instr).getId());
            System.out.println(((Instrument) instr).getWorkName());
            System.out.println(((Instrument) instr).getNameInstrument());
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

        Instrument instrument = entityManager.merge(this.instrument);
        instrument.setNameInstrument("Bulgarian");
        instrument.setWorkName("nag");
        entityManager.createNamedQuery("Instrument.test").getResultList().forEach(instr->{
            System.out.println(((Instrument) instr).getId());
            System.out.println(((Instrument) instr).getWorkName());
            System.out.println(((Instrument) instr).getNameInstrument());
            System.out.println();
        });
        entityManager.getTransaction().commit();
        entityManager.close();
    }
}