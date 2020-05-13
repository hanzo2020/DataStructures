package pers.cb.search;

import java.util.ArrayList;
import java.util.List;

public class TwoPoints {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr ={1,8,89,1000,1000,1000,1000,1234};
		ArrayList<Integer> arra = twoPoint2(arr,10,0,arr.length - 1);
		if(arra.isEmpty()){
			System.out.println("wu");
		}else{
			System.out.println(arra.toString());
		}

	}
	//有多个相同数字，都要找到
	public static ArrayList<Integer> twoPoint2(int[] arr, int num, int left, int right) {
		int mid = (left + right) / 2;
		if (left <= right) {
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
				return twoPoint2(arr, num, mid + 1, right);
			} else {
				return twoPoint2(arr, num, left, mid - 1);
			}
		}
		return new ArrayList<Integer>();

	}
	
	public static int twoPoint(int[] arr, int num, int left, int right) {
		int mid = (left + right) / 2;
		if (left <= right) {
			if (arr[mid] == num) {
				return mid;
			} else if (arr[mid] < num) {
				return twoPoint(arr, num, mid + 1, right);
			} else {
				return twoPoint(arr, num, left, mid - 1);
			}
		}
		return -1;

	}

}
