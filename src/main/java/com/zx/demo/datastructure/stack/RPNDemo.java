package com.zx.demo.datastructure.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

/**
 * reverse Polish notation，逆波兰表达式
 */
public class RPNDemo {

    public static void main(String[] args) {
        String expression = "50.5 + 250 * 6-32* 2.0-120";
//        String expression = "1+((2+3)*4)-5";
        List<String> infixList = toInfixExpressionList(expression);
        System.out.printf("%s 的中缀表达式：%s\n", expression, infixList);
        List<String> suffixList = infix2SuffixExpression(infixList);
        System.out.printf("%s 的后缀表达式：%s\n", expression, suffixList);
        double res = calculate(suffixList);
        System.out.printf("%s = %s\n", expression, res);

//        String suffixExpression = "3 4 + 5 * 6 -";
//        List<String> rpnExpressionList = toRPNExpressionList(suffixExpression);
//        double result = calculate(rpnExpressionList);
//        System.out.println("计算结果为： " + result);
    }

    /**
     * 将中缀表达式转成后缀表达式
     *
     * @param infixList
     * @return
     */
    public static List<String> infix2SuffixExpression(List<String> infixList) {
        Stack<String> s1 = new Stack<>();
        List<String> s2 = new ArrayList<>();
        for (String item : infixList) {
            if (item.matches("^[0-9]+\\.{0,1}[0-9]{0,2}$")) {// 如果是一个数字
                s2.add(item);
            } else if ("(".equals(item)) {
                s1.push(item);
            } else if (")".equals(item)) {
                while (!"(".equals(s1.peek())) {
                    s2.add(s1.pop());
                }
                s1.pop();// 需要把左括号去掉
            } else {
                while (s1.size() != 0) {
                    Operator sOper = Operator.k2v(s1.peek().charAt(0));
                    if (sOper == null || Operator.k2v(item.charAt(0)).priority > sOper.priority) {
                        break;
                    }
                    s2.add(s1.pop());
                }
                s1.push(item);
            }
        }
        while (s1.size() != 0) {// 将s1中剩余的加入到s2
            s2.add(s1.pop());
        }
        return s2;
    }

    /**
     * 把中缀表达式转成对应的list
     *
     * @param expression
     * @return
     */
    public static List<String> toInfixExpressionList(String expression) {
        List<String> result = new ArrayList<>();
        int index = 0;
        String numStr = "";
        do {
            char charAt = expression.charAt(index);
            index++;
            if (charAt < 48 || charAt > 57) {// 不是一个数值，参考ascii码
                if (charAt != ' ') {
                    result.add("" + charAt);
                }
            } else {
                numStr += charAt;
                while (index < expression.length() && ((expression.charAt(index) >= 48 && expression.charAt(index) <= 57) || expression.charAt(index) == '.')) {
                    numStr += expression.charAt(index);
                    index++;
                }
                result.add(numStr);
                numStr = "";
            }
        } while (index < expression.length());
        return result;
    }

    /**
     * 将逆波兰表达式转成对应的list
     *
     * @param rpnExpression
     * @return
     */
    public static List<String> toRPNExpressionList(String rpnExpression) {
        String[] s = rpnExpression.split(" ");
        return Arrays.asList(s);
    }

    /**
     * 计算逆波兰表达式
     *
     * @param rpnList
     * @return
     */
    public static double calculate(List<String> rpnList) {
        Stack<String> stack = new Stack<>();
        for (String item : rpnList) {
            if (item.matches("^[0-9]+\\.{0,1}[0-9]{0,2}$")) {//正则表达式，匹配多位数
//                System.err.println(item);
                stack.push(item);
            } else {
                double num1 = Double.parseDouble(stack.pop());
                double num2 = Double.parseDouble(stack.pop());
                Operator oper = Operator.k2v(item.charAt(0));
                if (oper == null) {
//                    System.out.println(item);
                    throw new RuntimeException("运算符有误");
                }
                double res = oper.cal(num1, num2);// -和/有先后问题，需要后弹出的-和/先弹出的
                stack.push("" + res);
            }
        }
        return Double.parseDouble(stack.pop());
    }

}
