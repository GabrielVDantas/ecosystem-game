
import org.example.exceptions.input.InputDimensionsException;
import org.example.exceptions.input.InputMissingException;
import org.example.exceptions.input.InputValueException;
import org.example.inputs.Input;
import org.example.inputs.InputService;
import org.example.inputs.info.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class InputServiceTest {

    private final InputService inputService = new InputService();

    @Test
    @DisplayName("Usuário passa todos os parâmetros válidos e o sistema deve aceitar.")
    void mustReceiveAndAcceptAllInputs() {

        String[] inputs = {"wd=15", "hg=20", "gn=20", "se=0123#", "rp=250", "ex=i"};

        assertDoesNotThrow(() -> inputService.validateInputs(inputs));
    }

    @Test
    @DisplayName("Usuário passa apenas os parâmetros obrigatórios e o sistema deve aceitar.")
    void mustAcceptJustMandatoryInputs() {

        String[] inputs = {"wd=15", "hg=20", "gn=20", "rp=250"};

        assertDoesNotThrow(() -> inputService.validateInputs(inputs));
    }

    @Test
    @DisplayName("Usuário não passa todos os parâmetros obrigatórios.")
    void mustThrowExceptionWithoutMandatoryInputs() {

        String[] inputs = {"wd=15", "se=0123#", "ex=i"};

        assertThrows(InputMissingException.class, () -> inputService.validateInputs(inputs));
    }

    @Test
    @DisplayName("O sistema deve verificar e aceitar a Seed que possui exatamente a mesma quantidade de linhas suportadas pela altura.")
    void mustAcceptSeedDimensions() {

        String[] inputs = {"wd=15", "hg=15", "gn=20", "se=0123##############", "rp=250", "ex=i"};

        assertDoesNotThrow(() -> inputService.validateInputs(inputs));
    }

    @Test
    @DisplayName("O sistema deve verificar e negar a Seed por causa da largura.")
    void mustThrowSeedDimensionsExceptionCausedByWidth() {

        String[] inputs = {"wd=15", "hg=15", "gn=20", "se=0123###############", "rp=250", "ex=i"};

        assertThrows(InputDimensionsException.class, () -> inputService.validateInputs(inputs));
    }

    @Test
    @DisplayName("O sistema deve verificar e negar a Seed por causa da altura.")
    void mustThrowSeedDimensionsExceptionCausedByHeight() {

        String[] inputs = {"wd=15", "hg=15", "gn=20", "se=01230101010101010100101010101010#############", "rp=250", "ex=i"};

        assertThrows(InputDimensionsException.class, () -> inputService.validateInputs(inputs));
    }
}
