package plainKey.fichesSequenceExample;

import javax.persistence.*;

public class SequenceExample {
    @Entity
    @Table(name = "users")
    public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USERS_SEQ")
        @SequenceGenerator(name = "USERS_SEQ", sequenceName = "SEQUENCE_USERS")
        private Long id;
    }
    /**persistence.xml META-INF/resources
     * <persistence-unit name="testPU">
     *   <properties>
     *     <property name="hibernate.id.new_generator_mappings" value="true" />
     *   </properties>
     * </persistence-unit>
     */
}
