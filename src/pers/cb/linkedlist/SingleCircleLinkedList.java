package pers.cb.linkedlist;
/*
 * 约瑟夫问题与单向环形链表
 */
public class SingleCircleLinkedList {
	public static void main(String[] args) {

		Circlelist list = new Circlelist();
		list.add(41);
		list.p();
		list.out(1, 3, 41);
		list.p();
	}
	
}
/*
 * 定义单向环形链表
 */
class Circlelist{
	private Kids head = new Kids(0);//第一个节点

	public Kids getHead() {
		return head;
	}
	//约瑟夫出圈
	public void out(int k ,int m,int nums){
		if(head.next == null || k < 1 || k > nums){
			System.out.println("根本没人");
			return;
		}
		Kids temp = head;
		while(temp.next != head){
			temp = temp.next;
		}
		for (int i = 0; i < k - 1; i++) {
			temp = temp.next;
	 		head = head.next;
		}
		while(head.next != head){
			for (int i = 0; i < m - 1 ; i++) {
				temp = temp.next;
		 		head = head.next;
			}
			System.out.println(head + "被移除");
			temp.next = temp.next.next;
			head = head.next;
		}
		if(head.next == head){
			System.out.println("最后一个" + head + "也被移除");
			head = null;
		}
		System.out.println("已经全部移除");
	}
	//添加
	public void add(int nums){
		//nums数据校验
		if(nums < 1){
			System.out.println("nums不能小于1");
			return;
		}
		Kids curKid = null;//辅助指针，帮助构建环形链表
		//使用循环来创建环形链表
		for(int i = 1; i <= nums; i++){
			//根据编号，创建小孩节点
			Kids kid = new Kids(i);
			//如果是第一个小孩
			if(i == 1){
				head = kid;
				head.next = head;
				curKid = head;//让cur指向第一个小孩
			}else{
				curKid.next = kid;
				kid.next = head;
				curKid = curKid.next;
			}
		}
	}
	//打印
	public void p(){
		Kids temp = head;
		if(temp == null){
			System.out.println("空");
			return;
		}
		do{
			System.out.println(temp);
			temp = temp.next;
		}while(temp != head);
	}
}
/*
 *定义节点 
 */
class Kids{
	private int no;
	public Kids next;
	public Kids(int no) {
		this.no = no;
	}
	@Override
	public String toString() {
		return "Kids [no=" + no + "]";
	}
	
	
}