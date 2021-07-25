package EntityExtendsNormalClass;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@SuppressWarnings("PMD")
@MappedSuperclass
@ToString
public abstract class Human{

        @Id
        @GeneratedValue //сурогатный первичный ключ
        @Getter
        @Setter
        private Long id;

}
