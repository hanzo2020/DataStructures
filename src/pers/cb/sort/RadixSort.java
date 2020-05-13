package pers.cb.sort;

import java.util.Arrays;

public class RadixSort {

	public static void main(String[] args) {
		int[] arr = {53,3,542,748,14,214};
		radix(arr);

	}
	//基数排序
	public static void radix(int[] arr){
		//第一轮排序(针对各位数)
		//定义一个二维数组，表示10个桶
		//基数排序是空间换时间
		//需要得到数组中最大的数的位数
		int max = arr[0];//假设第一个数最大
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] > max){
				max = arr[i];
			}
		}
		int maxLength = (max + "").length();
		int[][] bucket = new int[10][arr.length];
		//为了记录每个桶中实际存放了多少个数据，我们定义一个一维数组来记录各个桶的有效个数
		int[] counts = new int[10];
		//使用循环
		
		for (int i = 0, n = 1; i < maxLength; i++,n *= 10) {
			for (int j = 0; j < arr.length; j++) {
				//取出每个元素的个位
				int digitOfElement = arr[j] / n % 10;
				//放入对应的桶
				bucket[digitOfElement][counts[digitOfElement]] = arr[j];
				counts[digitOfElement]++;
			}
			//把数据重新放回
			int index = 0;
			//遍历每一个桶，并将桶中的数据放入到元素
			for (int k = 0; k < bucket.length; k++) {
				//如果桶中有数据，我们才放入到原数组中
				if(counts[k] != 0){
					//循环该桶
					for (int j = 0; j < counts[k]; j++) {
						arr[index] = bucket[k][j];
						index++;
					}
				}
				//需要将每个counts【k】置零
				counts[k] = 0;
			}
			System.out.println(Arrays.toString(arr));
		}
		
		
		
		
		
//		for (int i = 0; i < arr.length; i++) {
//			//取出每个元素的个位
//			int digitOfElement = arr[i] % 10;
//			//放入对应的桶
//			bucket[digitOfElement][counts[digitOfElement]] = arr[i];
//			counts[digitOfElement]++;
//		}
//		//把数据重新放回
//		int index = 0;
//		//遍历每一个桶，并将桶中的数据放入到元素
//		for (int k = 0; k < bucket.length; k++) {
//			//如果桶中有数据，我们才放入到原数组中
//			if(counts[k] != 0){
//				//循环该桶
//				for (int i = 0; i < counts[k]; i++) {
//					arr[index] = bucket[k][i];
//					index++;
//				}
//			}
//			//需要将每个counts【k】置零
//			counts[k] = 0;
//		}
//		System.out.println(Arrays.toString(arr));
//		//+++++++++++++++++++++++++++++++++++++
//		//第二轮
//		for (int i = 0; i < arr.length; i++) {
//			//取出每个元素的个位
//			int digitOfElement = arr[i] / 10  % 10;
//			//放入对应的桶
//			bucket[digitOfElement][counts[digitOfElement]] = arr[i];
//			counts[digitOfElement]++;
//		}
//		//把数据重新放回
//		index = 0;
//		//遍历每一个桶，并将桶中的数据放入到元素
//		for (int k = 0; k < bucket.length; k++) {
//			//如果桶中有数据，我们才放入到原数组中
//			if(counts[k] != 0){
//				//循环该桶
//				for (int i = 0; i < counts[k]; i++) {
//					arr[index] = bucket[k][i];
//					index++;
//				}
//			}
//			counts[k] = 0;
//		}
//		System.out.println(Arrays.toString(arr));
//		// +++++++++++++++++++++++++++++++++++++
//		// 第三轮
//		for (int i = 0; i < arr.length; i++) {
//			// 取出每个元素的个位
//			int digitOfElement = arr[i] / 100 % 10;
//			// 放入对应的桶
//			bucket[digitOfElement][counts[digitOfElement]] = arr[i];
//			counts[digitOfElement]++;
//		}
//		// 把数据重新放回
//		index = 0;
//		// 遍历每一个桶，并将桶中的数据放入到元素
//		for (int k = 0; k < bucket.length; k++) {
//			// 如果桶中有数据，我们才放入到原数组中
//			if (counts[k] != 0) {
//				// 循环该桶
//				for (int i = 0; i < counts[k]; i++) {
//					arr[index] = bucket[k][i];
//					index++;
//				}
//			}
//			counts[k] = 0;
//		}
//		System.out.println(Arrays.toString(arr));
		
	}

}
