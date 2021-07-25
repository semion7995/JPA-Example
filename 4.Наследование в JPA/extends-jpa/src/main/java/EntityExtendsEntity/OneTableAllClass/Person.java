package EntityExtendsEntity.OneTableAllClass;

import EntityExtendsNormalClass.Human;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;

/**
 * теряется возможность указывать not null ограничения для столбцов,
 * могут быть проблемы с производительностью при изменении/добавлении строк,
 * если на таблице придётся определять много индексов и некоторые базы данных
 * не очень эффективно работают с длинными строками в таблицах.
 */
@SuppressWarnings("PMD")
@Entity
@Inheritance//аннотация для базового класса
@DiscriminatorColumn
@ToString
public abstract class Person extends Human {

    @Getter
    @Setter
    private String name;

}
