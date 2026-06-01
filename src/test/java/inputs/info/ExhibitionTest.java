package inputs.info;

import org.example.exceptions.input.InputValueException;
import org.example.inputs.info.Exhibition;
import org.example.inputs.info.Width;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class ExhibitionTest {

    private final Exhibition exhibition  = new Exhibition();

    @ParameterizedTest
    @ValueSource(strings = {"l", "i", "n"})
    @DisplayName("Deve aceitar valores de exhibition válidos")
    void mustAcceptValidExhibitionValues(String value) {

        assertDoesNotThrow(() -> exhibition.validateInputValue(value));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "ll", "ii", "nn",
            "-l", "-i", "-n", "+l", "+i", "+n", "l-", "i-", "n-", "l+", "i+", "n+", "l=", "i=", "n=", "=l", "=i", "=n"
    })
    @DisplayName("Deve lançar exceção para valores de exhibition inválidos")
    void mustThrowExceptionForInvalidExhibitionValues(String value) {

        assertThrows(InputValueException.class, () -> exhibition.validateInputValue(value));
    }
}
