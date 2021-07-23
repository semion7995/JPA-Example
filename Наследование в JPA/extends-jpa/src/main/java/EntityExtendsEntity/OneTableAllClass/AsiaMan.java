package EntityExtendsEntity.OneTableAllClass;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.NamedQueries;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;


@SuppressWarnings("PMD")
@Entity

@DiscriminatorValue("ASIAMAN")
@ToString
public class AsiaMan extends Person{
    @Getter
    @Setter
    @Cascade(value = CascadeType.ALL)
    private String national;

}
