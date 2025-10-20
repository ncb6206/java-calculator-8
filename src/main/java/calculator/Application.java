package calculator;

import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}

private static int calculate(String input) {
    if (input == null || input.isBlank()) {
        return 0;
    }

    String numbersPart = input;
    String delimiterRegex = ",|:";

    if (input.startsWith("//")) {
        int newlineIdx = input.indexOf('\n');
        String customDelimiter = input.substring(2, newlineIdx);
        numbersPart = input.substring(newlineIdx + 1);
        delimiterRegex = Pattern.quote(customDelimiter) + "|,|:";
    }

    String[] tokens = numbersPart.split(delimiterRegex);
    int sum = 0;
    for (String token : tokens) {
        sum += Integer.parseInt(token);
    }
    return sum;
}