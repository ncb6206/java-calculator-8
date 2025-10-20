package calculator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
    }
}

private static int calculate(String input){
    if(input == null || input.isEmpty()){
        return 0;
    }

    String[] tokens = input.split(",|:");
    int sum = 0;
    for(String token : tokens){
        sum += Integer.parseInt(token);
    }
    return sum;
}