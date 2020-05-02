package pers.cb.stack;

import java.util.Scanner;

public class arrStack {
	public static void main(String[] args) {
		Stack1 st1 = new Stack1(10);
		String key = "";
		boolean loop = true;//控制是否退出菜单
		Scanner input = new Scanner(System.in);
		
		while(loop){
			System.out.println("show:显示栈");
			System.out.println("exit:退出栈");
			System.out.println("push:入栈");
			System.out.println("out :出栈");
			System.out.println("输入选择");
			key = input.next();
			switch (key) {
			case "show":
				st1.list();
				
				break;
			case "push":
				System.out.println("请输入一个数");
				int value = input.nextInt();
				st1.push(value);
				break;
			case "exit":
				input.close();
				loop = false;
				break;
			case "out":
				try {
					int res = st1.out();
					System.out.println(res+"已取出");
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			default:
				break;
			}

		}
		System.out.println("bye");
		

		
		
	}
}

//栈类
class Stack1{
	private int maxSize;//栈的最大容量
	private int[] arr;//数组模拟栈
	private int top = -1;//栈顶
	public Stack1(int maxSize) {
		this.maxSize = maxSize;
		arr = new int[maxSize];
	}
	//遍历栈,遍历时，需要从栈顶开始显示
	public void list(){
		if(isEmpty()){
			System.out.println("栈空");
			return;
		}
		for (int i = top; i >= 0; i--) {
			System.out.println(arr[i]);
		}
	}
	//出栈
	public int out(){
		if(isEmpty()){
			//抛出异常
			throw new RuntimeException("栈空");
		}
		int i = arr[top];
		top--;
		return i;
	}
	//入栈
	public void push(int n){
		if(isFull()){
			System.out.println("栈满");
			return;
		}
		top++;
		arr[top] = n;
		System.out.println("'"+n+"'"+"入栈成功");
	}
	//栈满
	public boolean isFull(){
		return top == maxSize - 1;
	}
	//栈空、
	public boolean isEmpty(){
		return top == -1;
	}
	
}