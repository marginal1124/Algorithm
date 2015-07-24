import java.util.ArrayList;
import java.util.Arrays;

/*
 * sum 给出一个数组，找出三个数字和为0的三个数，找到所有的且不能有重复
 * 
 * 难点：去重
 * 首先确定一个数为target，剩余的两个数通过双指针的方法
 * 确定第一个数的时候如果前后两个数相同，应该去重（因为已经排过序）
 * 剩余两个数寻找的时候，找到了一个，m++,n--,
 * 继续下一步时，先判断是否前后数值相同
 * 
 * */
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
