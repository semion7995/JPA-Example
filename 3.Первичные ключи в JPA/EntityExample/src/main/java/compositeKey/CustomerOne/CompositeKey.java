package compositeKey.CustomerOne;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * Тут рассматривается пример добавления составного ключа на примере серия + номер паспорта
 *
 */
@EqualsAndHashCode
@ToString
public class CompositeKey implements Serializable {
    static final long serialVersionUID = 1L;

    @Getter
    @Setter
    private String passportSeries;

    @Getter
    @Setter
    private String passportNumber;
/**
 * ключ -  идентификатор сущности
 * Класс должен быть public
 * У класса должен быть публичный конструктор по умолчанию.
 * Класс должен (корректно) реализовывать собственные equals() и hashCode()
 * Класс должен реализовывать Serializable
 * Класс составного первичного ключа должен либо отображаться на несколько полей
 * класса сущности, либо использоваться как встраиваемый класс.
 * В случае, когда класс составного первичного ключа отображается на поля класса
 * сущности, имена и типы полей в классе составного первичного ключа должны совпадат с
 * именами и типами полей на которые производится отображение в классе сущности.
 */
}
