package pers.cb.queue;

import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class ArrQueueDemo {
	public static void main(String[] args) {
		//测试
		//创建一个队列
		ArrayQueue arrayQueue = new ArrayQueue(3);
		char key = ' ';//接受用户输入
		Scanner input = new Scanner(System.in);
		boolean loop = true;
		while(loop){
			System.out.println("s:show");
			System.out.println("e:exit");
			System.out.println("a:add");
			System.out.println("g:get");
			System.out.println("h:head");
			key = input.next().charAt(0);
			switch(key){
			case 's':
				arrayQueue.showQueue();
				break;
			case 'a':
				System.out.println("输入一个要添加的数");
				int value = input.nextInt();
				arrayQueue.addQueue(value);
				break;
			case 'g':
				try {
					int res = arrayQueue.getQueue();
					System.out.println("取出的数据时" + res);
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println(e.getMessage());
				}
				break;
			case 'h':
				int head = arrayQueue.headQueue();
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
//使用数组模拟队列-编写一个ArrayQueue的类
class ArrayQueue{
	private int maxSize;//数组的最大容量
	private int front;//指向队列头
	private int rear;//队列尾部
	private int[] arr;//数组,用于存放数据
	//创建队列的构造器
	public ArrayQueue(int arrMaxsize){
		maxSize = arrMaxsize;
		arr = new int[maxSize];
		front = -1;//指向队列头部的前一个位置
		rear = -1;//指向队列尾(即是队列最后一个数据的位置)
	}
	public boolean isFull(){
		return rear == maxSize - 1;
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
			rear++;
			arr[rear] = n;
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
		front++;
		return arr[front];
	}
	//显示队列的所有数据
	public void showQueue(){
		//遍历
		if(isEmpty()){
			System.out.println("队列空");
			return;
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.printf("arr[%d] = %d\n",i,arr[i]);
		}
	}
	//显示队列的头部，不是取出数据
	public int headQueue(){
		if(isEmpty()){
			System.out.println("队列空");

		}
		return arr[front + 1];
	}
	
	
	
	
}