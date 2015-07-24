import java.util.ArrayList;
/*
 * 
 * 连个数组相交的数值
 *  a={1,4,6,6,12,34}; b ={3,6,6,13,23,34,45};
 *  则输出{6,6,34}
 * */

public class findIntersection {

	public static void main(String[] args) {
		
		int[] a={1,4,6,6,12,34};
		int[] b ={3,6,6,13,23,34,45};
		 
		ArrayList<Integer> res = FindIntersection(a, b);
		
		for(int i=0;i<res.size();i++){
			
			System.out.println(res.get(i));
		}
	
		
		

	}

	public static ArrayList<Integer> FindIntersection(int [] a,int [] b){
		
		ArrayList<Integer> res = new ArrayList<Integer>();
		int aL = a.length;
		int bL = b.length;		
		int i=0,j=0;
		//System.out.print(bL);
		while(i<aL && j<bL){
			if(a[i]==b[j]){
				res.add(a[i]);
				i++;
				j++;
			}
				
			else if(a[i]>b[j])
				j++;
			else 
				i++;
		}
		
		return res;
	}
}
