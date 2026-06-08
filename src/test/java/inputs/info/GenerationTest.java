package inputs.info;

import org.example.exceptions.input.InputValueException;
import org.example.inputs.info.Generation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class GenerationTest {

    private final Generation generation = new Generation();

    @ParameterizedTest
    @ValueSource(strings = {"1", "1000", "2", "999", "500"})
    @DisplayName("Deve aceitar valores de generation válidos")
    void mustAcceptValidGenerationValues(String value) {

        assertDoesNotThrow(() -> generation.validateValue(value));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "0", "1001", "-0", "-1001", "-500", "+0", "+1001", "+500", "0-", "1001-", "500-",
            "0+", "1001+", "500+", "0=", "1001=", "500=", "=0", "=1001", "=500"
    })
    @DisplayName("Deve lançar exceção para valores de generation inválidos")
    void mustThrowExceptionForInvalidGenerationValues(String value) {

        assertThrows(InputValueException.class, () -> generation.validateValue(value));
    }
}
