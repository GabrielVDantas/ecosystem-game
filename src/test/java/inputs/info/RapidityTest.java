package inputs.info;

import org.example.exceptions.input.InputValueException;
import org.example.inputs.info.Rapidity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class RapidityTest {

    private final Rapidity rapidity = new Rapidity();

    @ParameterizedTest
    @ValueSource(strings = {"100", "250", "500", "750", "1000"})
    @DisplayName("Deve aceitar valores de rapidez válidos")
    void mustAcceptValidRapidityValues(String value) {

        assertDoesNotThrow(() -> rapidity.validateInputValue(value));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "99", "101", "249", "251", "749", "751", "999", "1001",
            "-100", "-250", "-500", "-750", "-1000", "+100", "+250", "+500", "+750", "+1000", "=100", "=250", "=500", "=750", "=1000",
            "100-", "250-", "500-", "750-", "1000-", "100+", "250+", "500+", "750+", "1000+", "100=", "250=", "500=", "750=", "1000=",
    })
    @DisplayName("Deve lançar exceção para valores de rapidez inválidos")
    void mustThrowExceptionForInvalidRapidityValues(String value) {

        assertThrows(InputValueException.class, () -> rapidity.validateInputValue(value));
    }
}
