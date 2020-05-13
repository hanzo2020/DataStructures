package pers.cb.stack;
//将中缀表达式转成后缀表达式
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import javax.management.RuntimeErrorException;

public class InversePolishCalculator {

	public static void main(String[] args) {
		//先定义一个逆波兰表达式
		//(3+4)x5-6->3 4 + 5 x 6 -
		//为了方便，表达式中数字符号用空格隔开
//		String suffixExpression = "30 4 + 5 x 6 -";
//		//1.先将表达式放到ArrayList中
//		//2.将arraylist 传递给一个方法，遍历list配合栈完成计算
//		List l = new ArrayList<String>();
//		l = getListString(suffixExpression);
//		System.out.println(calculate(l));
		String expre = "1+((2+3)x4)-5";
		List<String> l = new ArrayList<String>();
		l = toInfix(expre);
		System.out.println(l);
		System.out.println(change(l).toString());
		System.out.println(calculate(change(l)));
		
	}
	//将1+((2+3)x4)-5 -> 1 2 3 + 4 x + 5 -
	public static List<String> change(List<String> l){
		Stack<String> stack1 = new Stack<String>();
		Stack<String> stack2 = new Stack<String>();
		List<String> list = new ArrayList<String>();
		for (String string : l) {
			if(string.matches("\\d+")){
				stack2.push(string);
			}else{
					if(string.equals(")")){
						while(!stack1.peek().equals("(")){
							stack2.push(stack1.pop());
						}
						stack1.pop();
						
					}else if(stack1.isEmpty() || stack1.peek().equals("(") || string.equals("(")){
						stack1.push(string);
						
					}else if(priority1(string) > priority1(stack1.peek())){
						stack1.push(string);
						
					}else{
						while(priority1(string) <= priority1(stack1.peek())){
							stack2.push(stack1.pop());
							if(stack1.isEmpty()){
								break;
							}
						}
						stack1.push(string);
						
					}
				
					
				
				
			}
		}
		while(!stack1.isEmpty()){
			stack2.push(stack1.pop());
		}
		while(!stack2.isEmpty()){
			stack1.push(stack2.pop());
		}
		while(!stack1.isEmpty()){
			list.add(stack1.pop());
		}
		return list;
		
	}
	//优先级
	public static int priority1(String oper){
		if(oper == "x" || oper == "/"){
			return 1;
		}else if(oper == "+" || oper == "-"){
			return 0;
		}else{
			return -1;
		}
	}
	//因为直接对字符串进行操作不方便，因此先将字符串存入list
	public static List<String> toInfix(String s){
		List<String> l = new ArrayList<String>();
		int i = 0;//用于遍历
		StringBuilder str = new StringBuilder();//对多位数进行拼接
		char c;//存放遍历的数
		do{
			if((c=s.charAt(i)) < 48 || (c=s.charAt(i)) > 57){
				if(str.length() != 0){
					l.add(str.toString());
					str.delete(0, str.length());
				}
				l.add(c+"");
				i++;
			}else{
				str.append(c);
				i++;
			}
		}while(i < s.length());
		if(str.length() != 0){
			l.add(str.toString());
		}
		return l;
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
		String[] split = suffixExpression.split(" ");//如果输入的数没有用空格隔开就不对了
		List<String> list = new ArrayList<String>();
		for (String ele : split) {
			list.add(ele);
		}
		return list; 
	}
}
