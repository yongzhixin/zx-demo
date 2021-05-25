package com.zx.demo.datastructure.stack;

/**
 * 使用栈实现几个计算器
 */
public class Calculator {

    public static void main(String[] args) {
        ArrayStack<Integer> numStack = new ArrayStack<>(10);
        ArrayStack<Character> operStack = new ArrayStack<>(10);
//        String expression = "50+250*6-32*2-120";// 有些表达式计算时有问题的，后面使用逆波兰表达式看能否解决
        String expression = "7*2*2-5+1-5+3-3";//
        int index = 0;
        String numStr = "";
        int num1, num2;
        while (true) {// 解析表达式
            char charAt = expression.substring(index, index + 1).charAt(0);
            index++;
            Operator oper = Operator.k2v(charAt);
            if (oper == null) {// 不是操作符，是数字
                numStr += charAt;
                while (true) {
                    if (index >= expression.length()) {
                        break;
                    }
                    charAt = expression.substring(index, index + 1).charAt(0);
                    Operator nextOper = Operator.k2v(charAt);
                    if (nextOper != null) {// 如果下一个是操作符退出循环
                        break;
                    }
                    numStr += charAt;// 否则继续拼接数字
                    index++;
                }
                numStack.push(Integer.parseInt(numStr));
                numStr = "";
            } else {// 是操作符
                if (operStack.isEmpty()) {
                    operStack.push(charAt);
                } else {
                    Operator topOper = Operator.k2v(operStack.peek());
                    if (oper.priority <= topOper.priority) {// 当前操作的优先级低，表示需要计算栈顶操作符优先级高的操作
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        int result = (int) Operator.k2v(operStack.pop()).cal(num1, num2);
                        numStack.push(result);
                        operStack.push(charAt);
                        System.err.printf("num1: %d, num2: %d, oper: %s\n", num1, num2, topOper);
                        numStack.list();
                        operStack.list();
                        System.out.println("\n");
                    } else {
                        operStack.push(charAt);
                    }
                }
            }
            if (index >= expression.length()) {
                break;
            }
        }
        System.err.println("===============");
        while (!operStack.isEmpty()) {
            num1 = numStack.pop();
            num2 = numStack.pop();
            Operator topOper = Operator.k2v(operStack.pop());
            int result = (int) topOper.cal(num1, num2);
            numStack.push(result);
            System.err.printf("num1: %d, num2: %d, oper: %s\n", num1, num2, topOper);
            numStack.list();
            operStack.list();
            System.out.println("\n");
        }

        System.out.printf("表达式 %s = %d", expression, numStack.pop());
    }

}

enum Operator {
    PLUS('+', 0) {
        @Override
        public double cal(double num1, double num2) {
            return num1 + num2;
        }
    },
    REDUCE('-', 0) {
        @Override
        public double cal(double num1, double num2) {
            return num2 - num1;
        }
    },
    RIDE('*', 1) {
        @Override
        public double cal(double num1, double num2) {
            return num1 * num2;
        }
    },
    DIVIDE('/', 1) {
        @Override
        public double cal(double num1, double num2) {
            return num2 / num1;
        }
    };

    private char oper;
    public int priority;


    Operator(char oper, int priority) {
        this.oper = oper;
        this.priority = priority;
    }

    public abstract double cal(double num1, double num2);

    public static Operator k2v(char op) {
        for (Operator operator : Operator.values()) {
            if (operator.oper == op) {
                return operator;
            }
        }
        return null;
    }

}
