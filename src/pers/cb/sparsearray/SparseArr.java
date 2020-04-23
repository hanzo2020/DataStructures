package pers.cb.sparsearray;

public class SparseArr {
public static void main(String[] args) {
	//创建一个原始的二维数组 11*11
	//0：表示没有棋子，1表示黑棋，2表示白棋
	int chessArr1[][] = new int [11][11];
	chessArr1[1][2] = 1;
	chessArr1[2][3] = 2;
	chessArr1[2][4] = 2;
	System.out.println("原始二维数组");
	for(int[] row : chessArr1){
		for(int data: row){
			System.out.printf("%d\t",data);
		}
		System.out.println();
	}
	//将二维数组转换为稀疏数组
	//1.先遍历二维数组，得到非0数据的个数
	int sum = 0;
	for (int i = 0; i < chessArr1.length; i++) {
		for (int j = 0; j < chessArr1.length; j++) {
			if(chessArr1[i][j] != 0){
				sum++;
			}
		}
	}
	System.out.println(sum);
	//2.创建对应的稀疏数组
	int sparseArr[][] = new int[sum+1][3];
	//给稀疏数组赋值
	sparseArr[0][0] = 11;
	sparseArr[0][1] = 11;
	sparseArr[0][2] = sum;
	//遍历二维数组，将非0的值存放到稀疏数组
	int row1 = 1;//用于记录是第几个非零数据
	for (int i = 0; i < chessArr1.length; i++) {
		for (int j = 0; j < chessArr1.length; j++) {
			if(chessArr1[i][j] != 0){
				sparseArr[row1][0] = i;
				sparseArr[row1][1] = j;
				sparseArr[row1][2] = chessArr1[i][j];
				row1 ++;
			}
		}
	}
	//输出稀疏数组
	System.out.println();
	System.out.println("得到的稀疏数组为:");
	for (int i = 0; i < sparseArr.length; i++) {
		System.out.printf("%d\t%d\t%d",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
		System.out.println();
	}
	//将稀疏数组恢复成二维数组
	int chessArr2[][] = new int [sparseArr[0][1]][sparseArr[0][1]];
	for (int i = 0; i < sparseArr[0][2]; i++) {
		chessArr2[sparseArr[i+1][0]][sparseArr[i+1][1]] = sparseArr[i+1][2];
	}
	System.out.println("恢复后的二维数组:");
	for(int[] row : chessArr2){
		for(int data: row){
			System.out.printf("%d\t",data);
		}
		System.out.println();
	}
	
	
}
}
