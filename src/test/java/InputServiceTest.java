import factory.InputTestDataFactory;
import org.example.exceptions.InputIncompleteException;
import org.example.exceptions.InputMissingException;
import org.example.inputs.InputService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(MockitoExtension.class)
class InputServiceTest {

    private final InputService inputService = new InputService();

    @Test
    void mustAcceptInputs() {

        String[] inputs = InputTestDataFactory.getCorrectBothMandatoryAndOptionalInputs();

        this.inputService.validateInputs(inputs);
    }

    @Test
    void mustThrowExceptionWhenInputsAreTooShort() {

        String[] inputs = {"wd=10", "hg="};

        assertThrows(InputIncompleteException.class, () ->
            this.inputService.validateInputs(inputs)
        );
    }

    @Test
    void mustThrowExceptionWhenInputsAreWithoutEquals() {

        String[] inputs = {"wd=10", "hg10"};

        assertThrows(InputIncompleteException.class, () ->
                this.inputService.validateInputs(inputs)
        );
    }

    @Test
    void mustThrowExceptionWhenInputsAreTooShortAndWithoutEquals() {

        String[] inputs = {"w1", "hg10"};

        assertThrows(InputIncompleteException.class, () ->
            this.inputService.validateInputs(inputs)
        );
    }

    @Test
    void mustThrowExceptionWhenInputsEqualsAreTheLastOnes() {

        String[] inputs = {"wd10=", "hg=10"};

        assertThrows(InputIncompleteException.class, () ->
                this.inputService.validateInputs(inputs)
        );
    }

    @Test
    void mustThrowExceptionWhenInputsEqualsAreTheFirstOnes() {

        String[] inputs = {"=wd10", "hg=10"};

        assertThrows(InputIncompleteException.class, () ->
                this.inputService.validateInputs(inputs)
        );
    }

    @Test
    void mustAcceptWhenJustAllMandatoryInputsArePresent() {

        String[] inputs = InputTestDataFactory.getCorrectMandatoryInputs();

        this.inputService.validateInputs(inputs);
    }

    @Test
    void mustThrowExceptionWhenMandatoryInputAreNotPresent() {

        String[] inputs = InputTestDataFactory.getCorrectOptionalInputs();

        assertThrows(InputMissingException.class, () ->
                this.inputService.validateInputs(inputs)
        );
    }
}
