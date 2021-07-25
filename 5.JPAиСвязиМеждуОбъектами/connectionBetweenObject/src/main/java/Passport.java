import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import java.time.LocalDate;
import java.time.Period;

@Entity
@ToString
public class Passport extends AbstractIdentifiableObject{
    @Getter
    @Setter
    private String series;

    @Getter
    @Setter
    private String number;

    @Getter
    @Setter
    private LocalDate issueDate;

    @Getter
    @Setter
    private Period validity;

    @Getter
    @Setter
    @OneToOne(optional = false, mappedBy = "passport")
    private Citizen citizen;
    //optional - является ли значение в этом поле обязательным?
    //mappedBy - указывает какое поле в объекте владельце
    //(то есть Citzen.class) соответствует владеемому объекту (то есть Passport.class)

//необходимо определять ТоString без вызова суперкласса
    //аналогично и в суперклассе во избежание stackOverFlowException

}
