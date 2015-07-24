/*
 * 最长回文子序列
 * s="abcbad" 输出"abcba"
 * s="abccbad" 输出"abccba"
 * 注意区分这两种情况
 * */
public class LongestPal {
	
	public static void main(String[] args){
		
		String s ="ddd";
		//System.out.print(longestPalindrome(s));
		Another aa =new Another();
		System.out.print(aa.longestPalindrome(s));
		
	}
	
	/*自己写的方法。没有想到奇数个的情况  对于"aabaa" 这种情况输出不正确*/
	
	 public static  String longestPalindrome(String s) {
	        int len = s.length();
	        char []ch = s.toCharArray();
	        int pre =0;
	        int mid = 0;
	        int l=0;
	        
	       // System.out.print((s));
	         if(len==0) return null;
	         if(len==1) return s;
	        
	        for(int i=1;i<len;i++){
	            if(ch[i-1]==ch[i]){
	            	//System.out.println("i:"+i);
	                int temp =i- findLen(ch,i);
	                if(temp>l){
	                    l = temp; pre = i-temp; mid = i;
	                    System.out.println(pre+"  "+mid +" ;" +temp);	                   
	                }
	               	//  i++;   这里出错，for 循环里已经有默认的i++了 不必再i++一次          
	            }
	        }
	        
	       // System.out.println(pre+"  "+mid+ " ");
	        //这里出错了，后面应该是起始位置加上长度
	        return s.substring(pre,pre+2*(mid-pre));
	    }
	    
	    public static int findLen(char []ch ,int t){
	        int len = ch.length;
	        int i = t;
	        int j = t;
	       // System.out.println("len:"+len);
	        while(i>0&&j<len){
	            //出错 数组范围  -1  这种涉及数组加1减1的问题一定要考虑数组越界问题
	            if(ch[i-1]==ch[j]){
	            	 //System.out.println("i:"+i);
	                i--;j++;
	            }
	            else break;
	        }
	       
	        return i;
	        
	    }
}

/*正确方法 */
class Another{
	public   String longestPalindrome(String s) {
        int len = s.length();
      
        int pre;
        int mid;
        String result="";
        
         if(len==0) return null;
         if(len==1) return s;
        
        for(int i=1;i<2*len-1;i++){
                pre = i/2;
                mid = i/2;
                //i 的位置为空格
                if(i%2==1)  mid++;
                String temp = findLen(s,pre,mid);
                if(result.length()<temp.length()){
                    result = temp;
                }
        }
        
        return result;
    }
    
    public  String findLen(String s ,int pre,int end){
        int len = s.length();
       
        while(pre>0&&end<len){
            //char 可以用==
            if(s.charAt(pre)==s.charAt(end)){
            	
                pre--;end++;
            }
            else {
                break;
            }
        }
       
        return s.substring(pre,end);
        
    }
	
	
	
}
