package pers.cb.recursion;

public class RecDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test(99);
	}
	public static void test(int n){
		if(n > 2){
			test(n - 1);
		}
		System.out.println(n);
	}
}
