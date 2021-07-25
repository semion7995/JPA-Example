package EntityExtendsEntity.OneTableAllClass;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * теряется возможность указывать not null ограничения для столбцов,
 * могут быть проблемы с производительностью при изменении/добавлении строк,
 * если на таблице придётся определять много индексов и некоторые базы данных
 * не очень эффективно работают с длинными строками в таблицах.
 */
@SuppressWarnings("PMD")
@Entity

@DiscriminatorValue("ASIAMAN")
@ToString
public class AsiaMan extends Person{
    @Getter
    @Setter
    private String national;
}
