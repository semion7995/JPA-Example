import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import java.util.Collection;

@Entity
@NamedQuery(name = "findCompaniesWithWorkerPassport", query =
"SELECT c from Company c , IN(c.workers) w WHERE w.passport.series = :series")

@ToString
public class Company extends AbstractIdentifiableObject{

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    @ManyToMany(mappedBy = "companies")
    private Collection<Citizen> workers;


}
