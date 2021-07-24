package EntityExtendsEntity.SeparateTablesForEachClass;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.time.LocalDate;

@SuppressWarnings("PMD")
@Entity
@NamedQueries({
        @NamedQuery(name = "Expert.test", query = "from Expert")
})
@ToString
public class Expert extends Foreman{
    @Getter
    @Setter
    private String expertiseName;

    @Getter
    @Setter
    private LocalDate timeIsOver;
}
