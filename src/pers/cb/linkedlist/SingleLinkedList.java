package pers.cb.linkedlist;

import java.util.Stack;

public class SingleLinkedList {
	public static void main(String[] args) {
		//测试
		//先创建节点
		HeroNode hero1 = new HeroNode(1, "邦哥", "世界主宰");
		HeroNode hero2 = new HeroNode(2, "狗哥", "火箭发射");
		HeroNode hero3 = new HeroNode(3, "瞎哥", "完犊子了");
		HeroNode hero4 = new HeroNode(4, "斌哥", "脱肛");
		
		//创建链表
		SingleLinkList single = new SingleLinkList();
		//加入
		single.add2(hero1);
		single.add2(hero4);
		single.add2(hero2);
		single.add2(hero3);
		//single.add2(hero4);
		single.list();
		reverprint(single.getHead());
//		reversal(single.getHead());
//		single.list();
//		HeroNode heroNode = new HeroNode(2, "涛哥", "涨停");
//		single.update(heroNode);
//		single.list();
//		System.out.println();
//		single.delete(4);
//		single.delete(1);
//		//显示
//		single.list();
//		System.out.println(getLength(single.getHead()));
//		System.out.println(getThat(single.getHead(),4));
		
	}
	//用栈实现逆序打印
	public static void reverprint(HeroNode head){
		Stack <HeroNode> stack = new Stack<HeroNode>();
		if(head.next == null){
			System.out.println("链表空");
			return;
		}
		HeroNode temp = head;
		while(temp.next != null){
			stack.add(temp.next);
			temp = temp.next;
			System.out.println("入栈成功");
		}
		while(stack.size() > 0){
			System.out.println(stack.pop());
		}
	}
	//实现链表的反转
	//1.创建一个新链表，遍历原链表，依次从头部插入新链表，再将原链表头部指向新链表
	public static void reversal(HeroNode head){
		int i = 0;
		if(head.next == null || head.next.next == null){
			System.out.println("链表空");
			return;
		}
		SingleLinkList single2 = new SingleLinkList();
		HeroNode temp1 = head.next;
		HeroNode temp2;
		while(true){
			if(temp1 == null){
				break;
			}
			temp2 = temp1;
			temp1 = temp1.next;
			single2.addhead(temp2);
		}
		head.next = single2.getHead().next;
		System.out.println("转换完成");
		
		
	}
	//查找单链表中的倒数第k个节点
	//1.编写一个方法，接收head节点，同时接收一个index(表示倒数第index个节点)
	//2.先把链表从头到尾遍历，求出链表长度，再遍历长度-index
	public static HeroNode getThat(HeroNode head,int index){
		if(head.next == null){
			System.out.println("链表空");
		}
		int size = getLength(head);
		HeroNode temp = head.next;
		if(index > 0 && index <= size){
			for(int i = 0;i < (size-index) ; i++){
				temp = temp.next;
			}
			return temp;
		}else{
			return null;
		}
	}
	//方法，获取到单链表的节点个数（如果是带头结点的链表，需要不统计头节点）
	public static int getLength(HeroNode head){
		if(head.next == null){
			return 0;
		}
		int length = 0;
		HeroNode cur = head.next;
		while(cur != null){
			length++;
			cur = cur.next;
		}
		return length;
	}
}
//定义SingleLinkList来管理我们的英雄
class SingleLinkList{
	//初始化一个头节点,头节点不能动
	private HeroNode head = new HeroNode(0,"","");
	
	public HeroNode getHead() {
		return head;
	}
	//头插法
	public void addhead(HeroNode heroNode){
		heroNode.next = head.next;
		head.next = heroNode;
		
	}
	//添加节点到单项列表
	public void add(HeroNode heroNode){
		//当不考虑编号的顺序时
		//1.找到当前链表的最后节点
		//2.将最后这个节点的next指向新的节点
		//因为头节点不能动，因此我们需要一个辅助变量 temp
		HeroNode temp = head;
		//遍历链表，找到最后
		while(true){
			//找到链表的最后
			if(temp.next == null){
				break;
			}
			//如果没有找到最后
			temp = temp.next;
		}
		//当退出while，temp就指向链表的最后
		temp.next = heroNode;
	}
	//顺序添加法
	//因为是单链表，因此我们找的temp是位于添加位置的前一个结点
	public void add2(HeroNode heroNode){
		HeroNode temp = head;//如果链表为空，temp就是修改head节点
		boolean flag = false;//标志添加的编号是否存在，默认为false
		//遍历链表，找到最后
		while(true){
			if(temp.next == null){//说明temp已经在最后
				break;
			}
			if(temp.next.no > heroNode.no){//找到位置，直接插入
				break;
			}else if(temp.next.no == heroNode.no){
				//编号已经存在
				flag = true;
				break;
			}
			temp = temp.next;//后移，继续找
		}
		if(flag){
			System.out.println("不能添加，编号已存在" + heroNode.no);
		}else{
			//加入数据
			heroNode.next = temp.next;
			temp.next = heroNode;
			
		}
	}
	//修改节点的信息，根据编号来修改，no不能改
	//1.根据no来修改
	public void update(HeroNode newheroNode){
		if(head.next == null){
			System.out.println("链表为空");
			return;
		}
		//找到需要修改的节点
		HeroNode temp = head.next;
		boolean flag = false;//表示是否找到节点
		while(true){
			if(temp == null){
				break;//说明已经遍历完
			}
			if(temp.no == newheroNode.no){
				//找到了
				flag = true;
				break;
			}
			
			temp = temp.next;
		}
		//根据flag判断是否找到
		if(flag){
			temp.name = newheroNode.name;
			temp.nickname = newheroNode.nickname;
		}else{
			System.out.println("未找到该节点" + newheroNode.no);
		}
	}
	//删除节点
	//被删除的节点，将不会有其他引用指向，会被垃圾回收机制回收
	public void delete(int no){
		if(head.next == null){
			System.out.println("没东西给你删");
		}
			HeroNode temp = head;
			boolean flag = false;
			while(true){
				if(temp.next == null){
					System.out.println("null");
					break;
				}
				if(temp.next.no == no){
					System.out.println("找到啦");
					flag = true;
					break;
				}
				temp = temp.next;
			}
			if(flag){
				temp.next = temp.next.next;
			}else{
				System.out.println("未找到该节点" + no);
			}
			
	}
	
	//显示链表【遍历】
	public void list(){
		//先判断链表是否为空
		if(head.next == null){
			System.out.println("链表为空");
			return;
		}
		//因为头节点，不能动，因此我们需要一个辅助变量来遍历
		HeroNode temp = head.next;
		while(true){
			if(temp == null){
				break;
			}
			//输出节点信息
			System.out.println(temp);
			//将temp后移
			temp = temp.next;
		}
	}
}
//定义HeroNode，每个对象就是一个节点
class HeroNode{
	public int no;
	public String name;
	public String nickname;
	public HeroNode next;//指向下一个节点
	//构造器
	public HeroNode(int no, String name, String nickname){
		this.no = no;
		this.name = name;
		this.nickname = nickname;
	}
	//为了显示方便，我们重写toString方法
	@Override
	public String toString() {
		return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname;
		//return "HeroNode [no=" + no + ", name=" + name + ", nickname=" + nickname + ", next=" + next + "]";
	}
	
}