package pers.cb.sort;

import java.util.Arrays;

public class Quick {

	public static void main(String[] args) {
		int[] arr = {-9,78,0,23,-567,70,66};
		quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));
	}
	public static int[] quickSort(int[] arr , int left ,int right){
		 int l = left;
		 int r = right;
		 int mid = arr[(l + r) / 2];
		 while(l < r){//目的，让比mid小的到左边，大的取右边
			 while(arr[l] < mid){
				 l++;
			 }
			 while(arr[r] > mid){
				 r--;
			 }
			 //如果l大于等于r，说明mid的左右两边的值已经可以了
			 if(l >= r){
				 break;
			 }else{
				 int temp = arr[l];
				 arr[l] = arr[r];
				 arr[r] = temp;
				 if(arr[l] == mid){
					 r--;
				 }else if(arr[r] == mid){
					 l++;
				 }
			 }
		 }
//		 if(l == r){//这个不懂
//			 l++;
//			 r--;
//		 }
		 if(l - 1 > left){
			 quickSort(arr, left, l - 1);
		 }
		 if(r + 1 < right){
			 quickSort(arr, r + 1, right);
		 }
		 return (arr);
		 
	}
}

	