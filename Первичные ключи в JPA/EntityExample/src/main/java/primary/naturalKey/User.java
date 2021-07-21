package primary.naturalKey;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Естественный ключ вытекает непосредственно из модели данных
 * приложения и, обычно, весьма хорошо в неё вписывается.
 * Теория так же говорит нам, что для любой таблицы/сущности
 * можно сформировать естественный ключ.
 */
@SuppressWarnings("PMD")
@ToString
@Entity
@Table(name = "users")
public class User {
    @Id
    @Getter
    @Setter
    private String username;

    @Getter
    @Setter
    @Column(nullable = false)
    private String password;

    @Getter
    @Setter
    @Column(unique = true, nullable = false)
    private String email;
}
/**
 * зачастую используются суррогатные ключи, которые не связаны явно с
 * моделью данных приложения, а либо порождаются из неё, либо создаются
 * каким-либо другим способом. Типичное решение — добавление к сущности
 * дополнительного целочисленного поля, содержимое которого генерируется
 * автоматически
 */
