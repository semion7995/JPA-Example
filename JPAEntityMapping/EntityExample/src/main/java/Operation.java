import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.ZonedDateTime;
@SuppressWarnings("PMD")
@Entity
@NamedQueries(
        {
                @NamedQuery(name = "Operation.testReadObject", query = "from Operation ")
        }
)
@Table(name = "journal",
indexes = {@Index(
        name = "j_account_idx",
        columnList = "account_id", unique = false)},
        uniqueConstraints = {@UniqueConstraint(
                columnNames = {"id", "account_id"})}
)
@SecondaryTable(name = "operation_details",
pkJoinColumns = @PrimaryKeyJoinColumn(
        name = "op_id",
        referencedColumnName = "id"
))
public class Operation {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false, updatable = true, insertable = true, unique = false)
    private Long rowId;
    //id транзакции

    @Getter
    @Setter
    @Column(name = "trxId", nullable = false, updatable = false)
    private Long id;
    //связанный идентификатор операции, операций может быть много в рамках одной транзакции

    @Getter
    @Setter
    @Column(name = "account_id",nullable = false, updatable = false)
    private Integer accountId;

    @Getter
    @Setter
    @Column(nullable = false, updatable = false, scale = 2, precision = 10)
    private BigDecimal amount;
    //10 знаков перед запятой и 2 знака после запятой
    //количество операций
//
//    @Getter
//    @Setter
//    @Column()
//    private String text;
    @Getter
    @Setter
    private ZonedDateTime timestamp;

    @Getter
    @Setter
    @Column(table = "operation_details", length = 64)
    private String description;
    //описание операции
    @Getter
    @Setter
    @Column(table = "operation_details")
    private Integer opCode;
    //код операции

    @Override
    public String toString() {
        return "Operation{"  +"\n"+
                "rowId=" + rowId +
                ", \n" +
                "id=" + id +
                ", \n" +
                "accountId=" + accountId +
                ", \n" +
                "amount=" + amount +
                ", \n" +
                "timestamp=" + timestamp +
                ", \n" +
                "description='" + description + '\'' +
                ", \n" +
                "opCode=" + opCode + "\n" +
                '}';
    }
}
