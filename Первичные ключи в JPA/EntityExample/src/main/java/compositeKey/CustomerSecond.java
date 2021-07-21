package compositeKey;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.IdClass;
import javax.persistence.Table;

@SuppressWarnings("PMD")
@ToString
@Entity
@Table(name = "customers")
@IdClass(CompositeKey.class)
public class CustomerSecond {

    @EmbeddedId
    @Getter
    @Setter
    private CompositeKey compositeKey;

    @Getter
    @Setter
    private String name;

}
