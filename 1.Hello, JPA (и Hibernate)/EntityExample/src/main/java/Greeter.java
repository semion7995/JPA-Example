import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NamedQueries({
        @NamedQuery(name = "Greeter.readEntityJPA", query = "from Greeter ")
})
public class Greeter {
    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String greeting;

    @Getter
    @Setter
    private String target;

}
