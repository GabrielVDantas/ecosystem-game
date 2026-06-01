package inputs.info;

import org.example.exceptions.input.InputValueException;
import org.example.inputs.info.Height;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class HeightTest {

    private final Height height = new Height();

    @ParameterizedTest
    @ValueSource(strings = {"15", "20", "25", "50", "100"})
    @DisplayName("Deve aceitar valores de altura válidos")
    void mustAcceptValidHeightValues(String value) {

        assertDoesNotThrow(() -> height.validateInputValue(value));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "14", "16", "21", "22", "24", "26", "49", "51", "99", "101",
            "-15", "-20", "-25", "-50", "-100", "+15", "+20", "+25", "+50", "+100", "15-", "20-", "25-", "50-", "100-",
            "15+", "20+", "25+", "50+", "100+", "15=", "20=", "25=", "50=", "100=", "=15", "=20", "=25", "=50", "=100"
    })
    @DisplayName("Deve lançar exceção para valores de altura inválidos")
    void mustThrowExceptionForInvalidHeightValues(String value) {

        assertThrows(InputValueException.class, () -> height.validateInputValue(value));
    }
}
