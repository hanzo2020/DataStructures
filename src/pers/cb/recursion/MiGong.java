package pers.cb.recursion;

public class MiGong {

	public static void main(String[] args) {
		//创建一个二维数组
		int[][] map = new int[8][7];
		//使用1表示墙
		for (int i = 0; i < 7; i++) {
			map[0][i] = 1;
			map[7][i] = 1;
		}
		for (int i = 0; i < 8; i++) {
			map[i][0] = 1;
			map[i][6] = 1;
		}
		//设置挡板
		map[3][1] = 1;
		map[3][2] = 1;
		map[4][2] = 1;
		map[5][2] = 1;
		System.out.println("地图如下");
		for (int[] is : map) {
			for (int i : is) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		setWay(map, 1, 1);
		System.out.println("跑路后");
		for (int[] is : map) {
			for (int i : is) {
				System.out.print(i + " ");
			}
			System.out.println();
		}
		
	}
	/*
	 * map:地图
	 * 说明:i,j表示从地图的哪个位置开始出发 
	 * 如果小球能到map[6][5],则说明成功找到。
	 * 约定：当地图的[i][j]为0时，表示这个点还没走过,1表示墙，2是走过的通路 ，3表示走过，走不通
	 * 走迷宫时，需要确定一个策略左-右-上-下
	 */
	public static boolean setWay(int[][] map, int i,int j){
		if(map[6][5] == 2){
			//通路
			return true;
		}else{
			if(map[i][j] == 0){
				//该点未走过
				//按照策略走
				map[i][j] = 2;//假定该点是通路
				if(setWay(map, i+1 , j)){
					return true;
				}else if(setWay(map, i , j - 1)){
					return true;
				}else if(setWay(map, i - 1 , j)){
					return true;
				}else if(setWay(map, i , j + 1)){
					return true;
				}else{
					map[i][j] = 3;
					return false;
				}
			}else {
				//不等于0
				return false;
			}
		}
	}

}
