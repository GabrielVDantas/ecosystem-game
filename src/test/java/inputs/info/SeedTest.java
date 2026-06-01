package inputs.info;

import org.example.exceptions.input.InputValueException;
import org.example.inputs.info.Seed;
import org.example.inputs.info.Width;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
public class SeedTest {

    private final Seed seed = new Seed();

    @ParameterizedTest
    @ValueSource(strings = {
            "112233#4455", "12345#12345#", "0000000000000#", "112233#4", "12345##", "######", "0011223##", "1122##"
    })
    @DisplayName("Deve aceitar valores de Seed válidos")
    void mustAcceptValidSeedValues(String value) {

        assertDoesNotThrow(() -> seed.validateInputValue(value));
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "112233#44556", "612345#12345#", "00000006000000#", "1162233#4", "123465##", "##6####", "00112623##", "16122##",
            "-112233#44556", "-612345#12345#", "-00000006000000#", "-1162233#4", "-123465##", "-##6####", "-00112623##", "-16122##",
            "+112233#44556", "+612345#12345#", "+00000006000000#", "+1162233#4", "+123465##", "+##6####", "+00112623##", "+16122##",
            "=112233#44556", "=612345#12345#", "=00000006000000#", "=1162233#4", "=123465##", "=##6####", "=00112623##", "=16122##",
            "112233#44556-", "612345#12345#-", "00000006000000#-", "1162233#4-", "123465##-", "##6####-", "00112623##-", "16122##-",
            "112233#44556+", "612345#12345#+", "00000006000000#+", "1162233#4+", "123465##+", "##6####+", "00112623##+", "16122##+",
            "112233#44556=", "612345#12345#=", "00000006000000#=", "1162233#4=", "123465##=", "##6####=", "00112623##=", "16122##=",
    })
    @DisplayName("Deve lançar exceção para valores de Seed inválidos")
    void mustThrowExceptionForInvalidSeedValues(String value) {

        assertThrows(InputValueException.class, () -> seed.validateInputValue(value));
    }
}
