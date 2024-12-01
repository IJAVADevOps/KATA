package kata.imad.katanumbertostring.domain;

import org.springframework.stereotype.Service;

@Service
public class NumberToStringService {

    public String transformNumberToString(int number) {
        if (number <= 0 || number >= 100) {
            throw new IllegalArgumentException("le nombre doit etre entre 0 et 100");
        }

        StringBuilder result = new StringBuilder();

        if (number % 3 == 0) {
            result.append("FOO");
        }
        if (number % 5 == 0) {
            result.append("BAR");
        }

        String numberStr = String.valueOf(number);
        for (char digit : numberStr.toCharArray()) {
            if (digit == '3') {
                result.append("FOO");
            }
            if (digit == '5') {
                result.append("BAR");
            }
            if (digit == '7') {
                result.append("QUIX");
            }
        }

        return !result.isEmpty() ? result.toString() : numberStr;
    }
}
// autre proposition
/*
-----------------------------------------------------------------------
    public String transformNumberToString(int number) { {

        String result = div(number);
        result += Arrays.stream(String.valueOf(number).split(""))
                .mapToInt(Integer::parseInt)
                .mapToObj(Main::cont)
                .collect(Collectors.joining());

        if (result.isEmpty()) {
            result = String.valueOf(number);
        }

        return result;
    }
-----------------------------------------------------------------------
 public String transformNumberToString(int number) {

    String result="";
    result+=div(number);
    result+=cont(number/10);
    result+=cont(number%10);
    if(result.isEmpty()) result = String.valueOf(number);


}
-----------------------------------------------------------------------
 public static String cont(int number) {

       StringBuilder result = new StringBuilder();
        String str = String.valueOf(number);
        if (str.contains("3")) result.append("FOO");
        if (str.contains("5")) result.append("BAR");
        if (str.contains("7")) result.append("QUIX");
        return result.toString();
    }
-----------------------------------------------------------------------
public static String cont(int number){
    String result = "";
    if(String.valueOf(number).contains("3")) result+="FOO";
    if(String.valueOf(number).contains("5")) result+="BAR";
    if(String.valueOf(number).contains("7")) result+="QUIX";
    return result;
}
-----------------------------------------------------------------------
public static String div(int number){
    String result="";
    if(number % 3 == 0)result+="FOO";
    if(number % 5 == 0) result+="BAR";
    return result;
}
-----------------------------------------------------------------------
 public static String div(int number) {

        StringBuilder result = new StringBuilder();

        if (number % 3 == 0) result.append("FOO");
        if (number % 5 == 0) result.append("BAR");

        return result.toString();
    }

**/
