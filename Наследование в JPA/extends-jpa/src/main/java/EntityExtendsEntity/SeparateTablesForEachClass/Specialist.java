package EntityExtendsEntity.SeparateTablesForEachClass;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@SuppressWarnings("PMD")
@Entity
@NamedQueries({
        @NamedQuery(name = "Specialist.test", query = "from Specialist")
})
@ToString
public class Specialist extends Foreman{

    @Getter
    @Setter
    private String qualification;

    @Getter
    @Setter
    private String knowledgeRegion;
}
