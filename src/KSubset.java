import java.util.ArrayList;

/*
 * 求0-n 中含有k 个数的子集、
 * 比如n=3,k=2
 * 则输出{2,3}{1,3}{1,2}
 * 
 * */
public class KSubset {

	public static void main(String[] args) {
		
		int n=3,k=2;
		//subset就是求n中有  k个1，n-k个0的 组合，最后通过printSub 函数输出
		boolean [] subset = new boolean[n];
		//FindKsubset(subset,n,k);
	
		findK(n,k);
		
	}

	//1，使用回溯框架
	public static void findK(int n,int k){
		ArrayList<ArrayList<Integer>>  list = new ArrayList<ArrayList<Integer>>();
		int[] solution = new int[k];
		
		if(k==0)  return;		
	
		boolean[] used = new boolean[n];
		backTrack(0,n,k,solution,0,used);		
	}
	
	public static void backTrack(int i,int n,int k,int[] solution,
			int t,boolean[] used){
		//System.out.println(solution);
		if(t==k){
			for(int j=0;j<k;j++){
				System.out.print(solution[j]+" ");
			}
			System.out.println();
			return;
		}
		
	/*	for(int i=1;i<=n;i++){
			//设置是否已用，否则会出现[1,1]这种组合
			if(!used[i-1]){
				used[i-1]=true;
				solution[t]=i;
				backTrack(n, k, solution, t+1,used);
				//最后需要再设置回来，还原现场
				used[i-1]=false;
			}
	
		}*/
		
		if(i>n)  return ;
		
		//if(!used[i]){
			//used[i]=false;
			solution[t]=i+1;
			backTrack(i+1, n, k, solution, t+1, used);
			
			backTrack(i+1, n, k, solution, t, used);
			//used[i]=true;
		//}
		
	}
	
	//2，之前看到的答案，这种的优势是 不会出现[1,2][2,1]这种
	public static void FindKsubset(boolean [] subset,int n,int k){
		//subset是判断哪K个位置输出的数组，其实就是000100
		if(n==k){
			for(int i=0;i<n;i++){
				subset[i] = true;				
			}
			PrintSub(subset);
			//return;
		}
			
		if(k==0){
			for(int i=0;i<n;i++){
				subset[i] = false;				
			}
			PrintSub(subset);
			//return;
		}
		
		if(k>0 && k<n){
			//有两种。
			subset[n-1]=true;
			//一种是最后一个数设为true，则递归应为 FindKsubset(subset,n-1,k-1);
			FindKsubset(subset,n-1,k-1);
			
			subset[n-1]=false;
			//第二种递归，最后一个数设为false，递归应为 FindKsubset(subset,n-1,k);
			FindKsubset(subset,n-1,k);
		}

	}
	
	public static void PrintSub(boolean [] subset){
		int n = subset.length;
		
		for(int i=0;i<n;i++){
			if(subset[i])
				System.out.print(i+1+"  ");
		}
		System.out.println();
	}
	
	
}
