package Calculator;

public class Calculator1 {
    public static int basicCalculator(String expression) {
        if (expression == null || expression.length() == 0)
            return 0;
        char[] expressionChar = expression.toCharArray();
        int ans = 0;
        int sign = 1;
        for (int i = 0; i < expressionChar.length; i++) {
            if (expressionChar[i] == '+')
                sign = 1;
            else if (expressionChar[i] == '-')
                sign = -1;
            else if (expressionChar[i] >= '0' && expressionChar[i] <= '9') {
                int cur = expressionChar[i] - '0';
                while (i + 1 < expressionChar.length
                        && (expressionChar[i + 1] >= '0' && expressionChar[i + 1] <= '9')) {
                    cur *= 10;
                    cur += expressionChar[++i] - '0';
                }
                ans += temp * sign;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "2+3-999";
        System.out.println(basicCalculator(s));
    }
}
