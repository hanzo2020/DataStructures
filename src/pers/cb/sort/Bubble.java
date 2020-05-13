package pers.cb.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Bubble {

	public static void main(String[] args) {

		//为了容易理解，展示演变过程
		int[] arr = new int[80000];
		for(int i = 0;i < 80000 ; i++){
			arr[i] = (int)(Math.random() * 80000);
		}
		Date date1 = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1str = sim.format(date1);
		System.out.println(date1str);
		bubbleSort(arr);
		Date date2 = new Date();
		String date2str = sim.format(date2);
		System.out.println(date2str);
		
	}
	public static void bubbleSort(int[] arr){
		for (int i = 0; i < arr.length - 1; i++) {
			boolean flag = false;
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if(arr[j] > arr[j+1]){
					flag = true;
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
			if(flag == false){
				System.out.println("已经ok");
				break;
			}
			
		}
	}

}
