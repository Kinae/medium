package eu.kinae.junit5;

import eu.kinae.Person;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PersonJUnit5Test {

    static Stream<Arguments> should_throw_if_any_field_is_null() {
        return Stream.of(
                Arguments.of("id should not be null", new PersonArguments(null, "F", "LastName", "FirstName")),
                Arguments.of("civility should not be null", new PersonArguments("id", null, "LastName", "FirstName")),
                Arguments.of("lastName should not be null", new PersonArguments("id", "F", null, "FirstName")),
                Arguments.of("firstName should not be null", new PersonArguments("id", "F", "LastName", null))
        );
    }

    @ParameterizedTest(name = "checking: {0}")
    @MethodSource
    void should_throw_if_any_field_is_null(String expectedMessage, PersonArguments argument) {
        assertThatThrownBy(() -> new Person(argument.id, argument.civility, argument.lastName, argument.firstName))
                .isExactlyInstanceOf(IllegalArgumentException.class)
                .hasMessage(expectedMessage);
    }

    record PersonArguments(String id, String civility, String lastName, String firstName) { }
}
