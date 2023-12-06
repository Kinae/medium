package eu.kinae.junit4;

import eu.kinae.Person;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PersonJUnit4Test {

    @Test
    void should_throw_if_id_is_null() {
        assertThatThrownBy(() ->
                new Person(null, "F", "LastName", "FirstName"))
            .isExactlyInstanceOf(IllegalArgumentException.class)
            .hasMessage("id should not be null");
    }

    @Test
    void should_throw_if_civility_is_null() {
        assertThatThrownBy(() ->
                new Person("id", null, "LastName", "FirstName"))
            .isExactlyInstanceOf(IllegalArgumentException.class)
            .hasMessage("civility should not be null");
    }

    @Test
    void should_throw_if_last_name_is_null() {
        assertThatThrownBy(() ->
                new Person("id", "F", null, "FirstName"))
            .isExactlyInstanceOf(IllegalArgumentException.class)
            .hasMessage("lastName should not be null");
    }

    @Test
    void should_throw_if_first_name_is_null() {
        assertThatThrownBy(() ->
                new Person("id", "F", "LastName", null))
            .isExactlyInstanceOf(IllegalArgumentException.class)
            .hasMessage("firstName should not be null");
    }
}
