package EntityExtendsEntity.OneTableAllClass;

import EntityExtendsNormalClass.Human;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.Inheritance;

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
