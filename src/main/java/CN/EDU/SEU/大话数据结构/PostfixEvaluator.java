package CN.EDU.SEU.大话数据结构;

import java.util.Scanner;
import java.util.Stack;

/**
 * 通过后缀表达式计算值
 * Created by LCN on 2016/4/11.
 */
public class PostfixEvaluator {
    //定义操作符常量
    private final static char ADD = '+';
    private final static char SUBTRACT = '-';
    private final static char MULTIPLY = '*';
    private final static char DIVIDE = '/';

    private Stack<Integer> stack;

    public PostfixEvaluator() {
        stack = new Stack<Integer>();
    }


    /**
     * 判断是否为操作符
     *
     * @param token 字符
     * @return
     */
    private boolean isOperator(String token) {
        // TODO Auto-generated method stub
        return (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/"));
    }


    /**
     * 计算每一部分的表达式
     *
     * @param operator 操作符
     * @param op1      中间变量，操作符左边
     * @param op2      中间变量，操作符左边
     * @return 中间结果
     */
    private int evaluateSingleOperator(char operator, int op1, int op2) {
        int result = 0;
        //分情况计算
        switch (operator) {
            case ADD:
                result = op1 + op2;
                break;
            case SUBTRACT:
                result = op1 - op2;
                break;
            case MULTIPLY:
                result = op1 * op2;
                break;
            case DIVIDE:
                result = op1 / op2;
                break;
        }
        return result;
    }


    /**
     * 将表达式存入栈
     *
     * @param expresion 表达式
     * @return 表达式的值
     */
    public int evaluate(String expresion) {
        int op1, op2, result = 0;//临时变量，保存操作符和中间结果
        String token;//字符
        Scanner parser = new Scanner(expresion);
        //循环获取每一个字符
        while (parser.hasNext()) {
            token = parser.next();
            //如果是表达式，就弹出
            if (isOperator(token)) {
                op2 = (stack.pop()).intValue();
                op1 = (stack.pop()).intValue();
                //计算中间结果
                result = evaluateSingleOperator(token.charAt(0), op1, op2);
                //将中间结果压入栈
                stack.push(new Integer(result));
            } else {
                //不是操作符就直接压入栈
                stack.push(new Integer(Integer.parseInt(token)));
            }
        }
        return result;
    }



    public static void main(String[] args) {
        String expresion,again; //表达式
        int result; //结果

        Scanner in = new Scanner(System.in); //获取输入

        do{
            System.out.println("请输入一个后缀表达式，每一个字符用空格分开，\n每一个字符必须是一个整数或者一个运算符");
            PostfixEvaluator evaluator = new PostfixEvaluator();
            expresion = in.nextLine();//获取输入
            result = evaluator.evaluate(expresion);//计算
            System.out.println("\n这个表达式的值是："+result);

            System.out.println("还要继续输入表达式么？[y/n]");
            again = in.nextLine();//重复获取表达式
            System.out.println();

        }
        while(again.equalsIgnoreCase("y"));
    }

}
