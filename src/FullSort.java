import java.util.ArrayList;

/*
 * 全排列
 * 
 * 给出a,b,c
 * 输出{abc}{acb}{bca}{bac}{cab}{cba}
 * */
public class FullSort {

	public static void main(String[] args) {	
		
		int n=3;		
	    fullsort(n);	
	    
	}
	public static  void fullsort(int n){

		boolean[] used = new boolean[n];
		int[] solution = new int[n];
		FullSorts(solution,used,n,0);
		
	}

	public static void FullSorts(int[] solution,boolean[] used,int n,int t){
		
		if(t==n){
			for(int i=0;i<n;i++){
				System.out.print(solution[i]+" ");
			}
			System.out.println();
			return;
		}
		
		for(int i=0;i<n;i++){
			if(!used[i]){
				used[i]=true;
				solution[t] =i+1;
			
				FullSorts(solution, used, n, t+1);
				used[i]=false;
			
			}
		}
	}
	
}
