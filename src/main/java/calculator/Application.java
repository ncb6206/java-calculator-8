package calculator;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class Application {
    public static void main(String[] args) {
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String input = Console.readLine();

        if (input != null) {
            input = input.replace("\\n", "\n");
        }

        try {
            int result = calculate(input);
            System.out.println("결과 : " + result);
        } catch (IllegalArgumentException e) {
            throw e;
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
            if (token.isEmpty()) {
                throw new IllegalArgumentException("빈 토큰은 허용되지 않습니다.");
            }
            if (!token.chars().allMatch(Character::isDigit)) {
                throw new IllegalArgumentException("숫자가 아닌 값이 포함되어 있습니다.");
            }
            int value = Integer.parseInt(token);
            if (value < 0) {
                throw new IllegalArgumentException("음수는 허용되지 않습니다.");
            }
            sum += value;
        }
        return sum;
    }
}

