package EntityExtendsNormalClass;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;

@SuppressWarnings("PMD")
@ToString
@Entity
@Table(name = "journal")
public class Adult extends Human{
    @Getter
    @Setter
    @Column(nullable = false, updatable = false)
    private Integer accountId;

    @Getter
    @Setter
    @Column(nullable = false, updatable = false, scale = 2, precision = 10)
    private BigDecimal amount;

}
