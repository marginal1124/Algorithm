import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class ThreeSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={12,-11,34,5,3,-8,-8,-1};
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		list=threeSum(nums);
		
		int size = list.size();
		for(int i=0;i<size;i++){			
			System.out.print(list.get(i)+" ");
		}

	}

    public static ArrayList<ArrayList<Integer>> threeSum(int[] nums) {
        int  len = nums.length;
        //注意这里ArrayList
        ArrayList<ArrayList<Integer>>  result = new ArrayList<ArrayList<Integer>>();
        
        Arrays.sort(nums);
              
        for(int i=0;i<len;i++){
        	//去重
            if(i!=0&&nums[i]!=nums[i-1]){
            	continue;
            }            
                int m = i+1;
                int n = len-1;
                while(m<n){
                	int sum = nums[m]+nums[n]+nums[i];
                	//System.out.println(sum+"nums[i]"+nums[i]);
                	if(sum == 0){
                		ArrayList<Integer>  temp = new ArrayList<Integer>();
                		temp.add(nums[i]);
                		temp.add(nums[m]);
                		temp.add(nums[n]);
                		m++;
                		while(m<n&&nums[m-1]==nums[m]){
                			m++;
                		}
                		n--;
                		while(m<n&&nums[n+1]==nums[n]){
                			n--;
                		}
                	
                		result.add(temp);
                		
                	}else if(sum < 0){
                		m++;
                	}else {
                		n--;
                	}
                }
               
              
        }
        // result.addAll(temp);
         return result;
        
    }
    
/*    public static ArrayList<ArrayList<Integer>> twoSum(int nums[],int target,int i){
        int len = nums.length;
        int m = i+1;
        int n = len-1;
        ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
        
        while(m<n){
        	ArrayList<Integer> l = new ArrayList<Integer>();
            if(nums[m]+nums[n]==(-target)){
            	
                l.add(nums[m]);
                l.add(nums[n]);
                //l.add(target);
                m++; 
                n--;
                while(m<n&&nums[m-1]==nums[m]){
                    m++;
                }
                 while(m<n&&nums[n+1]==nums[n]){
                    n--;
                }
            }else if(nums[m]+nums[n]<target){
                m++;
            }else n--;
            
            list.add(l);
        }
       
       return list;
    }*/
}
