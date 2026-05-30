package factory;

public class InputTestDataFactory {

    public static String[] getCorrectBothMandatoryAndOptionalInputs() {
        String[] mandatory = InputTestDataFactory.getCorrectMandatoryInputs();

        String[] optional = InputTestDataFactory.getCorrectOptionalInputs();

        String[] all = new String[mandatory.length + optional.length];

        int allIndex = 0;
        for (String s : mandatory) {
            all[allIndex] = s.toLowerCase();
            allIndex++;
        }

        for (String s : optional) {
            all[allIndex] = s.toLowerCase();
            allIndex++;
        }

        return all;
    }

    public static String[] getCorrectMandatoryInputs() {
        return new String[]{"wd=10", "hg=10", "gn=10"};
    }

    public static String[] getCorrectOptionalInputs() {
        return new String[]{"se=1101010"};
    }
}
