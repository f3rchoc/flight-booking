package ec.edu.ups.ms.builder;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PassengerBuilderTest {

    private PassengerBuilder passengerBuilder;

    @BeforeEach
    void setUp() {
        this.passengerBuilder = new PassengerBuilderImpl();
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "Lorem.", "Viverra cubilia sociosqu aliquam venenatis hac penatibus"})
    void givenNameWithInvalidValues_whenPassengerBuilderSetName_thenThrowsIllegalArgumentException(String name) {
        Assertions.assertThatThrownBy(() -> this.passengerBuilder.setFirstName(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void givenRightName_whenPassengerBuilderSetName_thenPassengerBuilderSetName() {
        var name = "Isaac";
        this.passengerBuilder.setFirstName(name);
        var passenger = this.passengerBuilder.build();
        Assertions.assertThat(passenger.getFirstName()).isEqualTo(name);
    }

}
