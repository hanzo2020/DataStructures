package pers.cb.sort;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

public class Shell {

	public static void main(String[] args) {
		int[] arr = new int[300000];
		for (int i = 0; i < 300000; i++) {
			arr[i] = (int) (Math.random() * 300000);
		}
		Date date1 = new Date();
		SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String date1str = sim.format(date1);
		System.out.println(date1str);
		shellSort(arr);
		Date date2 = new Date();
		String date2str = sim.format(date2);
		System.out.println(date2str);
	}

	public static void shellSort(int[] arr) {
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			for (int i = gap; i < arr.length; i++) {
				int j = i;
				int temp = arr[j];
				if (arr[j] < arr[j - gap]) {
					while (j - gap >= 0 && temp < arr[j - gap]) {
						arr[j] = arr[j - gap];
						j = j - gap;
					}
					arr[j] = temp;
				}
//				System.out.println(temp + "移动到了第" + j);
//				System.out.println(Arrays.toString(arr));
			}
//			System.out.println("_______________");
		}
		//希尔排序的第一轮排序
		//因为第一轮排序是将十个数据分成五组
//		for(int i = 5; i < arr.length; i++){
//			//遍历各组中所有的元素(共五组，每组两个元素)
//			for (int j = i - 5; j >= 0; j -= 5) {
//				//如果当前元素大于加上步长后的那个元素，说明需要交换
//				if(arr[j] > arr[j + 5]){
//					int temp = arr[j];
//					arr[j] = arr[j + 5];
//					arr[j + 5] = temp;
//				}
//			}
//		}
//		System.out.println(Arrays.toString(arr));
	}
}
