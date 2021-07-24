import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManagerFactory;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;

public class CitizenTest {
    private EntityManagerFactory entityManagerFactory;
    private Citizen citizen;
    @Test
    public void setUp() throws Exception {
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

        var address = new Address();
        address.setCity("New-York");
        address.setStreet("Bradvey");
        address.setBuilding("85");
        var citizens = new ArrayList<Citizen>();
        citizens.add(citizen);
        address.setCitizens(citizens);
        System.out.println(citizen);


    }

}