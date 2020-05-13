package pers.cb.search;

import java.util.ArrayList;

public class Interpolation {

	public static void main(String[] args) {
		int[] arr ={1,8,89,1000,1000,1000,1000,1234};
		ArrayList<Integer> arra = inter(arr,1234,0,arr.length - 1);
		if(arra.isEmpty()){
			System.out.println("wu");
		}else{
			System.out.println(arra.toString());
		}
	}
	public static ArrayList<Integer> inter(int[] arr, int num, int left, int right) {
		System.out.println("h");
		int mid = left + (right - left) * ((num - arr[left]) / (arr[right] - arr[left]));
		if (left <= right || num >= arr[0] || num <= arr[arr.length - 1]) {
			if (arr[mid] == num) {
				//向左边扫描，将所有满足查找值的元素下标加入到集合ArrayList
				//向右边扫描，将所有满足查找值的元素下标加入到集合ArrayList
				//返回arraylist
				ArrayList<Integer> array = new ArrayList<Integer>();
				int temp = mid - 1;
				while(true){
					if(temp < 0 || arr[temp] != num){
						break;
					}
					//否则加入集合
					array.add(temp);
					temp--;
				}
				array.add(mid);
				temp = mid + 1;
				while(true){
					if(temp > arr.length - 1 || arr[temp] != num){
						break;
					}
					//否则加入集合
					array.add(temp);
					temp++;
				}
				return array;
			} else if (arr[mid] < num) {
				return inter(arr, num, mid + 1, right);
			} else {
				return inter(arr, num, left, mid - 1);
			}
		}
		return new ArrayList<Integer>();

	}
}
