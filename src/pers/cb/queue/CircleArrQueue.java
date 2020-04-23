package pers.cb.queue;

import java.util.Scanner;

public class CircleArrQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//测试
				//创建一个队列
				CircleQueue circleQueue = new CircleQueue(3);
				char key = ' ';//接受用户输入
				Scanner input = new Scanner(System.in);
				boolean loop = true;
				System.out.println("测试妙啊");
				while(loop){
					System.out.println("s:show");
					System.out.println("e:exit");
					System.out.println("a:add");
					System.out.println("g:get");
					System.out.println("h:head");
					key = input.next().charAt(0);
					switch(key){
					case 's':
						circleQueue.showQueue();
						break;
					case 'a':
						System.out.println("输入一个要添加的数");
						int value = input.nextInt();
						circleQueue.addQueue(value);
						break;
					case 'g':
						try {
							int res = circleQueue.getQueue();
							System.out.println("取出的数据时" + res);
						} catch (Exception e) {
							// TODO: handle exception
							System.out.println(e.getMessage());
						}
						break;
					case 'h':
						int head = circleQueue.headQueue();
						System.out.println("头部是"+head);
						break;
					case 'e':
						input.close();
						loop = false;
						break;
					}
				}
				System.out.println("程序退出");
			}
	}
class CircleQueue{
		private int maxSize;//数组的最大容量
		private int front;//指向队列头
		private int rear;//队列尾部
		private int[] arr;//数组,用于存放数据
		//创建队列的构造器
		public CircleQueue(int arrMaxsize){
			maxSize = arrMaxsize;
			arr = new int[maxSize];
			front = 0;//指向队列第一个元素
			rear = 0;//指向最后一个元素的后一个位置
		}
		//判断是否满
		public boolean isFull(){
			return (rear+1) % maxSize == front;
		}
		//判断是否为空
		public boolean isEmpty(){
			return rear == front;
		}
		//添加数据到队列
		public void addQueue(int n){
			//判断队列是否满
			if(isFull()){
				System.out.println("队列满,不能加入数据");
				return;
			}else{
				arr[rear] = n;
				rear = (rear+1) % maxSize;//将rear后移,这里必须考虑取模
			}
		}
		//出队列
		public int getQueue(){
			//判断是否空
			if(isEmpty()){
				System.out.println("队列空");
				//抛出异常
				throw new RuntimeException("队列空，不能取数据");
			}
			//这里需要分析出front是指向队列的第一个元素
			//1.先把front的对应的值保存到一个临时变量
			//2.将front后移
			//3.将临时保存的变量返回
			int value = arr[front];
			front = (front + 1) % maxSize;
			return value;
		}
		//求出当前队列有效数据的个数
		public int size(){
			return (rear + maxSize - front) % maxSize;
		}
		//显示队列的所有数据
		public void showQueue(){
			//遍历
			if(isEmpty()){
				System.out.println("队列空");
				return;
			}
			for (int i = front; i < front + size(); i++) {
				System.out.printf("arr[%d] = %d\n",i % maxSize,arr[i % maxSize]);
			}
		}
		//显示队列的头部，不是取出数据
		public int headQueue(){
			if(isEmpty()){
				System.out.println("队列空");

			}
			return arr[front];
		}
	
	}
	

	
	
	

