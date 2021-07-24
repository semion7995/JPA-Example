import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Collection;

@Entity
@ToString
public class Address extends AbstractIdentifiableObject {
    @Getter
    @Setter
    private String city;

    @Getter
    @Setter
    private String street;

    @Getter
    @Setter
    private String building;

    @Getter
    @Setter
    @OneToMany(mappedBy = "address", fetch = FetchType.EAGER)
    private Collection<Citizen> citizens;
    //mappedBy указывает на поле с владеемым объектом в классе владельце
    //fetch - говорит, что при загрузке владеемого объекта необходимо сразу
    //загрузить коллекцию владельцев

}