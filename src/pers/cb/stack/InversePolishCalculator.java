package pers.cb.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.management.RuntimeErrorException;

public class InversePolishCalculator {

	public static void main(String[] args) {
		//先定义一个逆波兰表达式
		//(3+4)x5-6->3 4 + 5 x 6 -
		//为了方便，表达式中数字符号用空格隔开
		String suffixExpression = "30 4 + 5 x 6 -";
		//1.先将表达式放到ArrayList中
		//2.将arraylist 传递给一个方法，遍历list配合栈完成计算
		List l = new ArrayList<String>();
		l = getListString(suffixExpression);
		System.out.println(calculate(l));
	}
	//完成计算
	public static int calculate(List<String> l){
		//创建栈只需要一个
		Stack<String> stack = new Stack<String>();
		for (String string : l) {
			//使用正则表达式来去处数
			if(string.matches("\\d+")){
				//匹配的是多位数
				stack.push(string);
			}else{
				//pop出两个数进行运算,再入栈
				int num2 = Integer.parseInt(stack.pop());
				int num1 = Integer.parseInt(stack.pop());
				int res = 0;
				if(string.equals("+")){
					res = num1 + num2;
				}else if(string.equals("-")){
					res = num1 - num2;//后出减先出
				}else if(string.equals("x")){
					res = num1 * num2;
				}else if(string.equals("/")){
					res = num1 / num2;
				}else{
					throw new RuntimeException("sb");
				}
				stack.push(res + "");//整数转字符串
			}
		}
		return Integer.parseInt(stack.pop());
	}
	//传入ArrayList
	public static List<String> getListString(String suffixExpression){
		String[] split = suffixExpression.split(" ");
		List<String> list = new ArrayList<String>();
		for (String ele : split) {
			list.add(ele);
		}
		return list; 
	}
}
