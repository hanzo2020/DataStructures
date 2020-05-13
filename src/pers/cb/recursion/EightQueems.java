package pers.cb.recursion;
/*
 * 一维数组解决八皇后问题
 */
public class EightQueems {
	
	//定义一个max，表示共有多少个皇后
	int max = 8;
	static int nums = 0;
	int[] arr = new int[8];
	public static void main(String[] args) {
		EightQueems e = new EightQueems();
		e.eight(0);
		System.out.println( nums + "种方法");

	}
	//八皇后总代码
	private void eight(int n){
		if(n == max){
			//其实八个皇后已经放好了
			print();
			return;
		}
		//依次放入皇后，并判断是否冲突
		for(int i = 0; i < max ; i++){
			//先把当前皇后n放在该行的第1列0
			arr[n] = i;
			//判断当第n个皇后时是否冲突
			if(judge(n)){
				//不冲突,接着放
				eight(n + 1);
			}
			
		}
		
	}
	//写一个方法，检测是否冲突
	/*
	 * n表示第n个皇后
	 */
	private boolean judge(int n){
		for(int i = 0;i < n;i++){
			//判断是否同一列或同一斜线
			if(arr[i] == arr[n] || Math.abs(n-i) == Math.abs(arr[n] - arr[i])){
				return false;
			}
		}
		return true;
		
	}
	//写一个方法，可以将结果打印出来
	private void print(){
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
		nums++;
	}

}
