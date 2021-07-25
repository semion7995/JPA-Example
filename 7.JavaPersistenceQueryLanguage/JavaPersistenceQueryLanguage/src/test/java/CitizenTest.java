import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

public class CitizenTest {
    private EntityManagerFactory entityManagerFactory;
    private Citizen citizen;

    /**
     * private String givenName;
     * private String simpleName;
     * private LocalDate dateOfBirth;
     * private Passport passport;
     * private Address address;
     * private Collection<Company> companies;
     */
    @Before
    public void setUp() throws Exception {
        Citizen citizen = creadField();
        entityManagerFactory = Persistence.createEntityManagerFactory("ru.easyjava.data.jpa.hibernate");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(citizen);
//        entityManager.createNamedQuery("Citizen.test").getResultList().forEach(cit->{
//            System.out.println(((Citizen) cit).getGivenName());
//            System.out.println(((Citizen) cit).getSimpleName());
//            System.out.println(((Citizen) cit).getDateOfBirth());
//            System.out.println(((Citizen) cit).getPassport());
//            System.out.println(((Citizen) cit).getAddress());
//            System.out.println(((Citizen) cit).getCompanies());
//        });
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @Test
    public void citizenTest() throws Exception {

        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
        Citizen citizen = entityManager.merge(this.citizen);
        creadFieldTwo(citizen);
//        entityManager.createNamedQuery("Citizen.test").getResultList().forEach(cit->{
//            System.out.println(((Citizen) cit).getGivenName());
//            System.out.println(((Citizen) cit).getSimpleName());
//            System.out.println(((Citizen) cit).getDateOfBirth());
//            System.out.println(((Citizen) cit).getPassport());
//            System.out.println(((Citizen) cit).getAddress());
//            System.out.println(((Citizen) cit).getCompanies());
//        });
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    @After
    public void selectTest() {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();
//        entityManager.createQuery("select passport from Citizen", Passport.class).getResultList()
//                .forEach(System.out::println);
//
//        entityManager.createQuery("select passport from Citizen", Passport.class).getResultList()
//                .forEach(System.out::println);

//        entityManager.createQuery("from Passport p where p.citizen.simpleName = 'Zhukov'").getResultList()
//                .forEach(System.out::println);
////найди не все сущности класса Passport в поле citizen  которых хранятся сущности,
//// поле simpleName  которых равно 'Zhukov'

        //Можно использовать и обычные SQL выражения, такие как is null, between, like и так далее
//        entityManager.createQuery("from Passport p where p.citizen.simpleName like :name")
//                .setParameter("name", "Zh%")
//                .getResultList()
//                .forEach(System.out::println);

// Помимо именованных параметров поддерживаются и позиционные:
//        entityManager.createQuery("select c from Citizen c, IN(c.companies) com " +
//                "WHERE com.name = ?1", Citizen.class)
//                .setParameter(1, "Google")
//                .getResultList()
//                .forEach(System.out::println);
//        entityManager.flush();
//        entityManager.getTransaction().commit();
//        entityManager.close();
/**
* * В запросе выше показывается, как обращаться с связанным сущностями,
 * используя оператор IN, представляющий хранящуюся в сущности
 * коллекцию как элемент, к которому можно обратиться.
*/

/**
 * Именованные запросы
 *
 */
entityManager.createNamedQuery("findCompaniesWithWorkerPassport")
        .setParameter("series", "1740")
        .getResultList()
        .forEach(System.out::println);

    }

    private Citizen creadField() {
        citizen = new Citizen();
        citizen.setGivenName("Semen");
        citizen.setSimpleName("Zhukov");
        citizen.setDateOfBirth(LocalDate.of(1997, 3, 1));

        var company = new Company();
        company.setName("IBM");
        var workers = new ArrayList<Citizen>();
        workers.add(citizen);
        company.setWorkers(workers);
        var companies = new ArrayList<Company>();
        companies.add(company);
        citizen.setCompanies(companies);

        var passport = new Passport();
        passport.setSeries("4017");
        passport.setNumber("746733");
        passport.setIssueDate(LocalDate.of(2017, 11, 17));
        passport.setValidity(Period.of(2031, 8, 5));
        passport.setCitizen(citizen);
        citizen.setPassport(passport);
        var address = new Address();
        address.setCity("New-York");
        address.setStreet("Bradvey");
        address.setBuilding("85");
        citizen.setAddress(address);
        var citizens = new ArrayList<Citizen>();
        citizens.add(citizen);
        address.setCitizens(citizens);
        return citizen;
    }

    private Citizen creadFieldTwo(Citizen citizen) {
        citizen.setGivenName("Anton");
        citizen.setSimpleName("ZhukovYu");
        citizen.setDateOfBirth(LocalDate.of(1995, 10, 10));

        var company = new Company();
        company.setName("Google");
        var workers = new ArrayList<Citizen>();
        workers.add(citizen);
        company.setWorkers(workers);
        var companies = new ArrayList<Company>();
        companies.add(company);
        citizen.setCompanies(companies);

        var passport = new Passport();
        passport.setSeries("1740");
        passport.setNumber("337647");
        passport.setIssueDate(LocalDate.of(2015, 10, 11));
        passport.setValidity(Period.of(2041, 9, 7));
        passport.setCitizen(citizen);
        citizen.setPassport(passport);
        var address = new Address();
        address.setCity("San-Andreas");
        address.setStreet("Lenina");
        address.setBuilding("77");
        citizen.setAddress(address);
        var citizens = new ArrayList<Citizen>();
        citizens.add(citizen);
        address.setCitizens(citizens);
        return citizen;
    }

}