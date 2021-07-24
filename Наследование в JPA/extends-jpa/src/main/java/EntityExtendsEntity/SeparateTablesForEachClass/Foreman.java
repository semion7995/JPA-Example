package EntityExtendsEntity.SeparateTablesForEachClass;

import EntityExtendsNormalClass.Human;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
 * Самое лучше по производительности решение, но теряется
 * возможность обрабатывать данные базовых классов без обхода всех
 * таблиц.
 */
@SuppressWarnings("PMD")
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@ToString
public class Foreman extends Human {

    @Getter
    @Setter
    private String ability;

}
