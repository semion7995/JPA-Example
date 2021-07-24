import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@SuppressWarnings("PMD")
@ToString
@MappedSuperclass
public class AbstractIdentifiableObject {
    @Id
    @Getter
    @Setter
    private Long id;
}
