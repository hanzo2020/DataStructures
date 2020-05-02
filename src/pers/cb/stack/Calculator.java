package pers.cb.stack;
/*
 * 计算器
 */
public class Calculator {

	public static void main(String[] args) {
		String expression = "15+20*6-10";
		Stack2 num = new Stack2(20);
		Stack2 op = new Stack2(20);
		int index = 0;//用于扫描
		int res = 0;
		char ch = ' ';
		while(true){
			ch = expression.substring(index, index + 1).charAt(0);
			if(op.isOper(ch)){
				if(!op.isEmpty()){
					if(op.priority(ch) <= op.priority(op.peek())){
						res = op.cal(num.out(), num.out(), op.out());
						num.push(res);
						op.push(ch);
					}else{
						//大于
						op.push(ch);
					}
				}else{
					//为空
					op.push(ch);
				}
			}else{
				//处理多位数，处理数时，需要向表达式的index再往后看一位，如果是数就继续
				//定义一个字符串变量用于拼接
				StringBuilder keepnum = new StringBuilder();
				keepnum.append(ch);
				if(index == expression.length() - 1){
					num.push(ch - 48);
				}else{
					while(!op.isOper(expression.substring(index+1,index+2).charAt(0))){
						keepnum.append(expression.substring(index+1,index+2).charAt(0));
						index++;
						if(index == expression.length() - 1){
							break;
						}
					}
					String keep = keepnum.toString();
					num.push(Integer.parseInt(keep));
					//num.push(ch - 48);
				}
		}
			index++;
			if(index >= expression.length()){
				break;
			}
	}
		while(true){
			if(op.isEmpty()){
				break;
			}else{
				res = op.cal(num.out(), num.out(), op.out());
				num.push(res);
			}
		}
		
		System.out.println("答案是" + res);

	

	}//main
}
//栈,直接使用创建好的，需要扩展功能，判断优先级，判断是数字还是符号
class Stack2{
	private int maxSize;//栈的最大容量
	private int[] arr;//数组模拟栈
	private int top = -1;//栈顶
	public Stack2(int maxSize) {
		this.maxSize = maxSize;
		arr = new int[maxSize];
	}
	/*
	 * 计算
	 */
	public int cal(int num1, int num2, int oper){
		int res = 0;//存放结果\
		switch(oper){
		case '+':
			res = num1 + num2;
			break;
		case '-':
			res = num2 - num1;
			break;
		case '*':
			res = num1 * num2;
			break;
		case '/':
			res = num2 / num1;
			break;
		}
		return res;
	}
	/*
	 * 判断是不是一个运算符
	 */
	public boolean isOper(char val){
		return val == '+' || val == '-' || val == '*' || val == '/';
	}
	//返回运算符的优先级，优先级是程序员来确定，优先级使用数字表示，数字越大，优先级越高
	//只有加减乘除
	public int priority(int oper){
		if(oper == '*' || oper == '/'){
			return 1;
		}else if(oper == '+' || oper == '-'){
			return 0;
		}else{
			return -1;
		}
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
	//只看不取
	public int peek(){
		if(isEmpty()){
			//抛出异常
			throw new RuntimeException("栈空");
		}
		int i = arr[top];
		return i;
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