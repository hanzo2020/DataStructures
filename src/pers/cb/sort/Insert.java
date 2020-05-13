package pers.cb.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Insert {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = new int[80000];
		for (int i = 0; i < 80000; i++) {
			arr[i] = (int) (Math.random() * 80000);
		}
		Date date1 = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1str = sim.format(date1);
		System.out.println(date1str);
		// System.out.println(Arrays.toString(arr));
		ins(arr);
		// System.out.println(Arrays.toString(arr));
		Date date2 = new Date();
		String date2str = sim.format(date2);
		System.out.println(date2str);
	}
	
	public static void ins(int[] arr){
		for (int i = 1; i < arr.length - 1; i++) {
			int value = arr[i];
			int index = i - 1;
			while(index >= 0 && value < arr[index]){
				arr[index + 1] = arr[index];
				index--;
				
			}
			arr[index + 1] = value;
		}
	}
}
