package EntityExtendsEntity.OneTableAllClass;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;


@SuppressWarnings("PMD")
@Entity
@DiscriminatorValue("ASIAMAN")
@ToString
public class AsiaMan extends Person{
    @Getter
    @Setter
    private Long nationalCategoryId;
}
