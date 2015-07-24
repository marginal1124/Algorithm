import java.util.Arrays;

/*
 * 给定一个数组，一个target，返回数组中三个数的和 与target值最接近的  sum
 * 
 * 首先将数组排序
 * 先确定一个数，两外两个数通过双指针前后寻找
 * 寻找过程中比较与 target 的差
 * 
 * */
public class ThreeSumCloseest {

	public static void main(String[] args) {
		int[] arr = {1,1,-1,-1,3};
		int re = threeSumClosest(arr,-1);

		System.out.println(re);
	}
public static int threeSumClosest(int[] nums, int target) {
        
        int len = nums.length;
        //注意这里不能将close = Integer.MAX_VALUE; 因为后面有target-close 有可能会溢出，导致判断出错
        int close = Integer.MAX_VALUE-Math.abs(target);
        
        if(len==0)  return 0;
        if(len==1)  return nums[0];
        if(len==2)  return nums[0]+nums[1];
        if(len==3)  return nums[0]+nums[1]+nums[2];
        
        Arrays.sort(nums);
        
        for(int i=0;i<len-2;i++){
            int m=i+1;
            int n=len-1;
            
            
            while(m<n){
                int sum = nums[i]+nums[m]+nums[n];
                
                if(Math.abs(target-sum)<Math.abs(close-target)){
                	
                    close = sum;
                }
                
                int dif = target-sum;
                if(dif<0) n--;
                if(dif>0) m++;
                if(dif==0) return close;
          }
       
        }
         return close;
    }

}
