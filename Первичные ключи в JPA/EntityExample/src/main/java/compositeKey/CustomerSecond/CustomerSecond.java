package compositeKey.CustomerSecond;

import compositeKey.CustomerOne.CompositeKey;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;

@SuppressWarnings("PMD")
@ToString
@Entity
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "CustomerSecond.testGreeter", query = "from CustomerSecond ")
})
@Table(name = "customers")
public class CustomerSecond implements Serializable {


    @EmbeddedId
    @Getter
    @Setter
    private CompositeKeySecond passport;

    @Getter
    @Setter
    private String name;

}
