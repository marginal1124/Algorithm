import java.util.ArrayList;


public class CombinationSum3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<ArrayList<Integer>> ret = new ArrayList<ArrayList<Integer>>();
		int k=4;
		int n=10;
		ret = combinationSum3(k, n);
		for(int i=0;i<ret.size();i++){
			System.out.print(ret.get(i));
		}

	}
public static ArrayList<ArrayList<Integer>> combinationSum3(int k, int n) {
        
        ArrayList<ArrayList<Integer>> ret =  new ArrayList<ArrayList<Integer>>();
        
        ArrayList<Integer> fit = new ArrayList<Integer>();
        
        if(k==0||(k!=0&&n==0))  return ret;
        
        findSolution(1,ret,fit,k,n);
        return ret;
    }
    
    public static void  findSolution(int i,ArrayList<ArrayList<Integer>> ret,ArrayList<Integer> fit,int k,int n){
        if(k==0){
            if(n==0){
                ret.add(new ArrayList<Integer>(fit));
                return;
            }
        }
        
        if(n<0||i>9)  return;
        
        if(n>0){
            fit.add(i);
            findSolution(i+1,ret,fit,k-1,n-i);
            fit.remove(fit.size()-1);
            findSolution(i+1,ret,fit,k,n);
        }
    }

}
