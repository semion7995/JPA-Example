import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@SuppressWarnings("PMD")
@ToString
@MappedSuperclass
public class AbstractIdentifiableObject {
    @Id
    @GeneratedValue
    @Getter
    @Setter
    private Long id;
}
