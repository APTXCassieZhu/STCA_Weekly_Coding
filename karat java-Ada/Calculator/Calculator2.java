package Calculator;

import java.util.Stack;

public class Calculator2 {
    public static int basicCalculator2(String expression) {
        if (expression == null || expression.length() == 0)
            return 0;
        char[] expressionChar = expression.toCharArray();
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        int sign = 1;
        for (int i = 0; i < expressionChar.length; i++) {
            if (expressionChar[i] == '+')
                sign = 1;
            else if (expressionChar[i] == '-')
                sign = -1;
            else if (expressionChar[i] >= '0' && expressionChar[i] <= '9') {
                int temp = expressionChar[i] - '0';
                while (i + 1 < expressionChar.length
                        && (expressionChar[i + 1] >= '0' && expressionChar[i + 1] <= '9')) {
                    temp *= 10;
                    temp += expressionChar[++i] - '0';
                }
                num += temp * sign;
            } else if (expressionChar[i] == '(') {
                stack.push(num);
                stack.push(sign);
                num = 0;
                sign = 1;
            } else if (expressionChar[i] == ')') {
                num = num * stack.pop() + stack.pop();
            }
        }
        return num;
    }

    public static void main(String[] args) {
        String s = "2+(1-(2+7-(5-2)))";
        System.out.println(basicCalculator2(s));
    }
}
