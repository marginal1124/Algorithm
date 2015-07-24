
public class Prim {

	public static void main(String[] args) {
		
		 float m = Float.MAX_VALUE;  
	        float[][] weight = {{0, 0, 0, 0, 0, 0, 0},  
	                            {0, m, 6, 1, 5, m, m},  
	                            {0, 6, m, 5, m, 3, m},  
	                            {0, 1, 5, m, 5, 6, 4},  
	                            {0, 5, m, 5, m, m, 2},  
	                            {0, m, 3, 6, m, m, 6},  
	                            {0, m, m, 4, 2, 6, m}};//上图的矩阵  
	        prim(weight.length - 1, weight);  
	}

	public static void prim(int num,float[][] weight){
		//到新集合的最小权
		float[] lowcost = new float[num+1];
		//为什么写成数组的形式
		int[] vertex = new int[num+1];		
		boolean[] s = new boolean[num+1];
		
		s[1]=true;
		//起始点的所有连接点的权
		for(int i = 2;i<=num;i++){
			lowcost[i] = weight[1][i];
			vertex[i]=1;
			//s[i]=false;
		}
		
		//共有num个顶点，需要循环num-1 次----起始点除外
		
		for(int i=1;i<num;i++){
			float min = Float.MAX_VALUE;
			int temp = 1;
			
			for(int k=1;k<=num;k++){
				//顶点未被使用过
				if((lowcost[k]<min)&&(!s[k])){
					min = lowcost[k];
					temp=k;
				}				
			}
			//temp顶点的权值最小，加入最小生成树中
			System.out.println("加入点" + temp + ". " + temp + "---" + vertex[temp]);
			s[temp] = true;
			
			// 当第temp个顶点被加入到最小生成树的结果数组中之后，更新其它顶点的权值。
			for(int j=1;j<=num;j++){
				//这里的判断条件？？
				if(!s[j]&&(weight[temp][j] < lowcost[j])){
					lowcost[j]=weight[temp][j];
					
					vertex[j]=temp;
				}
				
			}
			
		}
		
	}
}
