import org.example.exceptions.input.InputNotFoundException;
import org.example.inputs.Input;
import org.example.inputs.InputRegistry;
import org.example.inputs.info.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class InputRegistryTest {

    private final List<Input<?>> domain = List.of(
            new Exhibition(), new Generation(), new Height(), new Rapidity(), new Seed(), new Width()
    );

    private final InputRegistry inputRegistry = new InputRegistry(domain);

    @Test
    @DisplayName("A registry deve retornar o Input equivalente ao pattern passado.")
    void inputRegistryMustGetAndValidateInput() {

        String wantedPattern = new Width().getPattern();

        Input<?> received = this.inputRegistry.getAndValidateInput(wantedPattern);

        assertEquals(wantedPattern, received.getPattern());
    }

    @Test
    @DisplayName("A registry deve lançar uma exceção quando receber um pattern inválido.")
    void inputRegistryMustThrowExceptionWhenPatternIsInvalid() {

        String invalidPattern = "xx";

        assertThrows(InputNotFoundException.class, () ->
            this.inputRegistry.getAndValidateInput(invalidPattern)
        );
    }
}
