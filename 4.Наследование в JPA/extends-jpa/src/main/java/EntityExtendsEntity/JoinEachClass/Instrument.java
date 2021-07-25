package EntityExtendsEntity.JoinEachClass;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@SuppressWarnings("PMD")
@Entity
@NamedQueries({
        @NamedQuery(name = "Instrument.test",
                query = "from Instrument")
})
@ToString
public class Instrument extends TypeOfWork{
    @Getter
    @Setter
    private String nameInstrument;

}
