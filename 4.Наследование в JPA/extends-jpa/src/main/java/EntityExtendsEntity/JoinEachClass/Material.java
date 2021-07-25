package EntityExtendsEntity.JoinEachClass;

import jdk.jfr.SettingDefinition;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@SuppressWarnings("PMD")
@Entity
@NamedQueries({
        @NamedQuery(name = "Material.test",
                query = "from Material")
})
@ToString
public class Material extends TypeOfWork {

    @Getter
    @Setter
    private String nameMaterial;

}
