package compositeKey.CustomerOne;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@SuppressWarnings("PMD")
@ToString
@Entity
@NamedQueries({
        @NamedQuery(name = "Customer.testGreeter", query = "from Customer ")
})
@Table(name = "customers")
@IdClass(CompositeKey.class)
public class Customer {

    @Id
    @Getter
    @Setter
    private String passportSeries;

    @Id
    @Getter
    @Setter
    private String passportNumber;

    @Getter
    @Setter
    private String name;
}
