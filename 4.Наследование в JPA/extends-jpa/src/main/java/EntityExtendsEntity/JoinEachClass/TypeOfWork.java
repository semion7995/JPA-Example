package EntityExtendsEntity.JoinEachClass;

import EntityExtendsNormalClass.Human;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

/**
 * Другая стратегия — создавать для каждого производного класса свою
 * собственную таблицу, в которой будут храниться его собственные поля.
 * А поля базового класса — в собственной таблице базового класса.
 * В этом случае в аннотации @Inheritance базового класса указывается
 * другая стратегия strategy = InheritanceType.JOINED, а в производных
 * классах указывать ничего не надо.
 * @NamedQueries({
 *         @NamedQuery(name = "MarriageCertificate.findMarriageCertificate", query = "SELECT mc FROM MarriageCertificate mc " +
 *                 "LEFT JOIN FETCH mc.husband husband " +
 *                 "LEFT JOIN FETCH mc.wife bs " +
 *                 "WHERE mc.husband = :husband, mc.wife = :wife ")
 * })
 */

@SuppressWarnings("PMD")
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "type_of_work")
@ToString
public class TypeOfWork extends Human {

    @Getter
    @Setter
    private String workName;
}
