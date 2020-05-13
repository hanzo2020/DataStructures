package pers.cb.sort;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Choice {

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
		chSort(arr);
		Date date2 = new Date();
		String date2str = sim.format(date2);
		System.out.println(date2str);
		// System.out.println(Arrays.toString(arr));
	}

	public static void chSort(int[] arr) {

		for (int i = 0; i < arr.length - 1; i++) {
			int temp = i;
			for (int j = i; j < arr.length ; j++) {
				if (arr[temp] > arr[j]) {
					temp = j;
				}
			}
			int k;
			k = arr[i];
			arr[i] = arr[temp];
			arr[temp] = k;
		}
	}
}
