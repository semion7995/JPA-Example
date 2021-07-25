import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@NamedQueries({
        @NamedQuery(name = "Citizen.test", query = "from Citizen")
})
public class Citizen extends AbstractIdentifiableObject {

    @Getter
    @Setter
    private String givenName;

    @Getter
    @Setter
    private String simpleName;

    @Getter
    @Setter
    private LocalDate dateOfBirth;

    @Getter
    @Setter
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "PASSPORT_ID")//столбец в котором хранится ссылка на владеемый объект
    private Passport passport;
    //cascade - говорит что делать с владеемыми объектами при
    //операциях над владельцем

    @Getter
    @Setter
    @ManyToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "ADDRESS_ID")
    private Address address;

    @Getter
    @Setter
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "PERSON_COMPANIES",
            joinColumns = @JoinColumn(name = "PERSON_ID"),
            inverseJoinColumns = @JoinColumn(name = "COMPANY_ID")
    )
    private Collection<Company> companies;


}
