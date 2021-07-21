package compositeKey;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@SuppressWarnings("PMD")
@ToString
@Entity
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
