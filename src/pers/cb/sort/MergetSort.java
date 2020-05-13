package pers.cb.sort;

import java.util.Arrays;

public class MergetSort {

	public static void main(String[] args) {

		int[] arr = {8,4,5,7,1,3,6,2,42,523};
		int[] temp = new int[arr.length];//归并排序需要一个额外的空间
		merr(arr, 0, arr.length - 1, temp);
		System.out.println(Arrays.toString(arr));
	}
	//分解过程
	public static void merr(int[] arr,int left,int right,int[] temp){
		if(left < right){
			int mid = (left + right) / 2;//中间索引
			//向左递归进行分解
			merr(arr,left,mid,temp);
			//向右递归进行分解
			merr(arr,mid + 1,right,temp);
			//到合并
			mer(arr, left, mid, right, temp);
		}
	}
	//合并方法
	/*
	 * arr:原始数组
	 * left:左边序列初始索引
	 * mid:中间索引
	 * right:最右索引
	 * temp:中转数组
	 */
	public static void mer(int[] arr,int left,int mid,int right, int[] temp){
		System.out.println("["+left+"]" + "["+right+"]" + "😊");
		int i = left;//初始化i，左边有序序列的初始索引
		int j = mid+1;//右边有序序列的初始索引
		int t = 0;//加入数组的索引
		//先把左右两边的数据按规则放入temp数组，直到左右两边有一边处理完毕
		while(i <= mid && j <= right){
			if(arr[i] < arr[j]){
				temp[t] = arr[i];
				t++;
				i++;
			}else{
				temp[t] = arr[j];
				t++;
				j++;
			}
		}
		//把有剩余数据的一边的数据依次全部填充到temp
		if(i == mid + 1){
			for(;j <= right;j++){
				temp[t] = arr[j];
				t++;
			}
		}else{
			for(;i < mid + 1;i++){
				temp[t] = arr[i];
				t++;
			}
		}
		//将temp重新拷贝回arr
		t = 0;
		for(int k = left;k <= right;k++){//第一次合并，left = 0,right = 1,第二次left是2，right是3
			arr[k] = temp[t];
			t++;
		}
	}
	
}
