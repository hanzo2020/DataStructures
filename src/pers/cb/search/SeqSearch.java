package pers.cb.search;

public class SeqSearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {1,9,11,-1,34,89};
		int index = seqS(arr, 11);
		if(index == -1){
			System.out.println("没有");
		}else{
			System.out.println(arr[index]);
		}
	}
	public static int seqS(int[] arr,int value){
		for (int i = 0; i < arr.length; i++) {
			if(arr[i] == value){
				return i;
			}
		}
		return -1;
	}

}
