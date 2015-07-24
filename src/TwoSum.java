import java.util.Arrays;

/*
 *找出数组中相加为一个给定值的两个数，并返回连个数的下标 index1，index2。
 *并且index1 的值小于 index2
 *
 * */
public class TwoSum {

	public static void main(String[] args) {

		int [] numbers = {1,8,3,3,2};
		int target = 9;

		//int [] result = twoSum(numbers,target);
		//System.out.println("第一个下标："+result[0]+"第二个下标"+result[1]);
	
		int [] result = twoSum1(numbers,target);
		System.out.println("第一个下标："+result[0]+"第二个下标"+result[1]);

	}
	//暴力搜索：时间复杂度O(n^2)
	public static int[] twoSum(int [] numbers,int target){
		int [] result = new int[2];
		for(int i=0;i<numbers.length;i++){
			
				for(int j=i+1;j<numbers.length;j++){
					
						if(numbers[i]+numbers[j]==target){
						   result[0]=i;
						   result[1]=j;
						   System.out.println(numbers[i]);
						   System.out.println(numbers[j]);
						}
				
				}
			
		}
		return result;
	}

	public static int[]  twoSum1(int [] num ,int target){
		int [] ret = new int[2]; 
		int [] ori = Arrays.copyOf(num, num.length);
		Arrays.sort(num);
		//System.out.println(Arrays.toString(ori)+" and "+Arrays.toString(num));
		
		int start=0;
		//注意这里是长度-1 O__O"…
		int end=num.length-1;
		boolean find = false;
		
		//注意start end 是下标
		while(!find && start < end){
		 if(num[start]+num[end] == target){
			 find=true;
		 }else if(num[start]+num[end] > target){
			 end--;continue;
		 }else if(num[start]+num[end] < target){
			 start++;continue;
		 }
		 }
		if(!find){
			System.out.println("没有找到");
		}else {
			int index1=-1;
			int index2=-1;
			//根据数值，找到其在原数组中的位置
			for(int i=0;i<ori.length;i++){
				if(ori[i]==num[start] || ori[i]==num[end]){
					//先给index1 赋值，则ret是按下标大小存储的，并且保证了index1 和index2 不会指向同一个数值
					if(index1==-1) {index1=i+1;}
					else index2=i+1;
				}
			}
			ret=new int[]{index1,index2};
		}
		return ret;
	}
}
