package plainKey.generate.suragat.autoKey;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 *
 */
public class SequenceStrategyEx {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    @Column(name = "id", nullable = false, updatable = false)
    private Long rowId;

//    @GeneratedValue(strategy = GenerationType.IDENTITY) - автоинкрементация
//    @GeneratedValue(strategy = GenerationType.SEQUENCE) - последовательность
    //использует механизм встроенный в PostgesSQL Oracle
    @Id
    @SequenceGenerators({
            @SequenceGenerator(name = "jpaSequence", sequenceName = "JPA_SEQUENCE", allocationSize = 1, initialValue = 1)
    })
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "jpaSequence")
    @Getter
    @Setter
    @Column(name = "id", nullable = false, updatable = false)
    private Long id;


}
