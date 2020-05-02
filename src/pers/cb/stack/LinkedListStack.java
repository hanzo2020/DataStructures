package pers.cb.stack;

import java.util.Scanner;

//单链表实现栈
public class LinkedListStack {
	public static void main(String[] args) {
		LinkListStack st1 = new LinkListStack();
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
				HeroNode i = new HeroNode(value);
				st1.push(i);
				break;
			case "exit":
				input.close();
				loop = false;
				break;
			case "out":
				try {
					HeroNode res = st1.out();
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


class LinkListStack{
	private HeroNode head = new HeroNode(0);
	private int top = 0;
	public HeroNode getHead() {
		return head;
	}
	//遍历栈
	public void list(){
		if(isEmpty()){
			System.out.println("栈空");
		}
		HeroNode temp = head.next; 
		while(temp != null){
			System.out.println(temp);
			temp = temp.next;
		}
	}
	//出栈
	public HeroNode out(){
		if(isEmpty()){
			throw new RuntimeException("栈空");
		}
		HeroNode temp = head; 
		HeroNode temp2 = temp.next;
		temp.next = temp.next.next;
		return temp2;
		
	}
	//入栈
	public void push(HeroNode h){
		HeroNode temp = head; 
		h.next = temp.next;
		temp.next = h;
		System.out.println(h + "入栈成功" );

	}
	
	
	
	public boolean isEmpty(){
		return head.next == null;
	}
	
	
	
}

class HeroNode{
	public int no;
	public HeroNode next;//指向下一个节点
	//构造器
	public HeroNode(int no){
		this.no = no;
	}
	@Override
	public String toString() {
		return "HeroNode [no=" + no + "]";
	}
	
	
}