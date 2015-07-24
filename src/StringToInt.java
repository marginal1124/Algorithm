/*
 * 一个数字类型字符串转换成数字
 * “123”  ———>  123
 * 
 * 正负号
 * 12s---12(判断是否是0-9之间的数)
 * 忽略空格 "12  5"---125
 * 判断溢出（不可以计算完再比较最值，因为此时已经溢出）：
 *     | 两种情况  十位就大于最大值的十位则无需继续计算个位；
 *     |---     十位等于最大值十位，比较两个的个位
 * 忽略其他非数字符号
 * */

public class StringToInt {
 
	public static void main(String [] args) throws Exception{
				
		String s ="=1234";
	
		int n=transeInt(s);
		System.out.println(n);
	}
	
	public static int transeInt(String s) throws Exception{
		
		int digit = 0;
		int result = 0;
		int flag =0;
		int i=0;
		
		final int MAX_DIV = Integer.MAX_VALUE/10;
		final int MAX_M   = Integer.MAX_VALUE%10;
		
		final  int MIN_DIV = Integer.MIN_VALUE/10;
		final  int MIN_M   = Integer.MIN_VALUE%10;
				
		if(s.length()==0||s==null)
			throw new Exception("错误输入");;
		
		/*
		 * 错误：char 类型是单引号 不是双引号！！！
		 * 错误：需要先判断输入是否有正负
		 * */
		if(s.charAt(0)=='-'||s.charAt(0)=='+'){
			if(s.charAt(0)=='-')
				flag = 1;
			else 
				flag = 2;
			if(s.length()==1)
				System.out.println("错误字符串");
		}
		//排除了空字符串，只有符号的字符串
		
		if(flag!=0){
			i++;		
		}
			
		
		while(i<s.length()){
			
			digit = s.charAt(i++)-'0';
			
			//判断是否是整数
			if(digit>=0&&digit<=9){
				//判断是否溢出
				if(flag!=2){
					if(result>MAX_DIV||((result==MAX_DIV)&&(digit>MAX_M)))
						throw new Exception("溢出");
				}else if(flag==1){
					if(result<MIN_DIV||(result==MIN_DIV && digit>MIN_M)){
						throw new Exception("溢出");
					}
				}	
				
				result = result*10+digit;
			}else if(digit==(' '-'0'))
				continue;
			else
				//break换成continue之后就是跳过字符串中非数字
				continue;
		
			/*
			 * 如果continue 则执行不到i++
			 * i++;*/
		}
		
		if(flag==1)
			return -result;
		else 
			return result;
	}
	
}
