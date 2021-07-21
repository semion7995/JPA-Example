package generator.table.strategy;

import javax.persistence.Id;
import javax.persistence.TableGenerator;

public class TableStrategyExample {
/**
 * для начала инициализируем таблицу вручную!!!
 CREATE TABLE JOURNAL
 (
 ID BIGINT PRIMARY KEY
 );
 CREATE TABLE SEQ_STORE
 (
 SEQ_NAME VARCHAR(255) PRIMARY KEY,
 SEQ_VALUE BIGINT NOT NULL
 );
 INSERT INTO SEQ_STORE VALUES ('JOURNAL.ID.PK', 0);
 */
@Id
@TableGenerator(
        name = "seqStore", table = "SEQ_STORE", pkColumnName = "SEQ_NAME",
        pkColumnValue = "JOURNAL.ID.PK", valueColumnName = "SEQ_VALUE", initialValue = 1,
        allocationSize = 1)
/**
 * name — имя этого конкретного генератора
 * table — имя таблицы, в которой он хранит текущие значения ключей
 * pkColumnName — имя столбца, в котором хранятся имена значений ключей
 * pkColumnValue — имя ключа, используемого в этом генераторе
 * valueColumnName — имя столбца, в котором хранятся значения ключей
 */
private Long rowId;


}
