/*
 * 最长的无重复的子序列
 *  For example, 
 * the longest substring without repeating letters for
 * "abcabcbb" is "abc", which the length is 3. 
 * For "bbbbb" the longest substring is "b", 
 * with the length of 1.
 * */
public class LongestSub {

	public static void main(String[] args){
		String s ="aab";
		System.out.println(longestSub(s));
		//System.out.println(s);		
	}
	
	public static int longestSub(String s){
		boolean[] flag = new boolean[256];
		int maxLen = 0;
		int len = s.length();
		int pre = 0;		
		
		if(len==0){ return 0;
		}else{
			for(int i = 0;i<len;i++){
				if(!flag[s.charAt(i)]){
					flag[s.charAt(i)]=true;
					
				}else {
					maxLen = Math.max(maxLen, i-pre);
					//System.out.print(maxLen);
					for(int j=pre;j<i;j++){
						if(s.charAt(i)==s.charAt(j)){
							//这里循环i的值不用再从头开始，只要设置pre的位置，
							//修改最后遇到的那个值的flag就可以了
							//i=j+1;
							pre = j+1;
							//flag[s.charAt(i)] =  false;
							break;
						}
					}		
				}
			}
			//如果最后一个字符也在子序列中，则不会执行上面else
			maxLen = Math.max(maxLen, len-pre);		
			return maxLen;			
		}
	}
}
