package pers.cb.linkedlist;

public class DoubleLinkedList {
	public static void main(String[] args) {
		HeroNode2 hero1 = new HeroNode2(1, "邦哥", "世界主宰");
		HeroNode2 hero2 = new HeroNode2(2, "狗哥", "火箭发射");
		HeroNode2 hero3 = new HeroNode2(3, "瞎哥", "完犊子了");
		HeroNode2 hero4 = new HeroNode2(4, "斌哥", "脱肛");
		DoubleLink doublelink = new DoubleLink();
		doublelink.add(hero1);
		doublelink.add(hero2);
		//doublelink.add(hero3);
		doublelink.add(hero4);
		doublelink.list();
		//doublelink.delete(2);
//		HeroNode2 hero22 = new HeroNode2(2, "风格", "证券");
//		doublelink.update(hero22);
		doublelink.add2(hero3);
		doublelink.list();
		
	}
}

//创建一个双向链表类
class DoubleLink{
	//定义头节点
	private HeroNode2 head2 = new HeroNode2(0,"","");

	public HeroNode2 getHead2() {
		return head2;
	}
	//删除节点
	//被删除的节点，将不会有其他引用指向，会被垃圾回收机制回收
		public void delete(int no){
			if(head2.next == null){
				System.out.println("没东西给你删");
				return;
			}
				HeroNode2 temp = head2.next;
				boolean flag = false;
				while(true){
					if(temp == null){
						System.out.println("到尾了");
						break;
					}
					if(temp.no == no){
						System.out.println("找到啦");
						flag = true;
						break;
					}
					temp = temp.next;
				}
				if(flag){
					if(temp.next != null){
						temp.pre.next = temp.next;
						temp.next.pre = temp.pre;
					}else{
						temp.pre.next = null;
					}
				}else{
					System.out.println("未找到该节点" + no);
				}
				
		}
	//修改一个节点的内容
	public void update(HeroNode2 newheroNode){
		if(head2.next == null){
			System.out.println("链表为空");
			return;
		}
		//找到需要修改的节点
		HeroNode2 temp = head2.next;
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
	//根据序号添加
	public void add2(HeroNode2 heroNode){
		HeroNode2 temp = head2.next;//如果链表为空，temp就是修改head节点
		boolean flag = false;//标志添加的编号是否存在，默认为false
		//遍历链表，找到最后
		while(true){
			if(temp == null){//说明temp已经在最后
				break;
			}
			if(temp.no > heroNode.no){//找到位置，直接插入
				break;
			}else if(temp.no == heroNode.no){
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
			heroNode.next = temp;
			heroNode.pre = temp.pre;
			temp.pre.next = heroNode;
			
		}
	}
	//默认添加到尾端的添加
	public void add(HeroNode2 heroNode){
		//当不考虑编号的顺序时
		//1.找到当前链表的最后节点
		//2.将最后这个节点的next指向新的节点
		//因为头节点不能动，因此我们需要一个辅助变量 temp
		HeroNode2 temp = head2;
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
		//形成一个双向链表
		temp.next = heroNode;
		heroNode.pre = temp;
	}
	//遍历双向链表的方法
	public void list(){
		//先判断链表是否为空
		if(head2.next == null){
			System.out.println("链表为空");
			return;
		}
		//因为头节点，不能动，因此我们需要一个辅助变量来遍历
		HeroNode2 temp = head2.next;
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
class HeroNode2{
	public int no;
	public String name;
	public String nickname;
	public HeroNode2 next;//指向下一个节点
	public HeroNode2 pre;//指向前一个结点
	//构造器
	public HeroNode2(int no, String name, String nickname){
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