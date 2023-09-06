package application.utils;

public class AgeValidator {

    public static boolean isAgeValid(String age) {
        return age.isEmpty() || !age.matches(Constants.AGE_RGX);
    }

}
