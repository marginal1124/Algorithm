/*
 * X进制转化为Y进制函数,其中X和Y为2到64之间的任意数
 * 
 * 0-64 的表示方式：0-9 、 a-z 、 A-Z 、+、 /
 * 
 * 非法字符抛出异常
 * 非法输入抛出异常
 * 
 * */
public class Convert {
		
	public static void main(String[] args) throws Exception {

		System.out.println("convert(2,\"1000\",10):"+convert(2,"1000",10));
		System.out.println("convert(10,\"2\",2):"+convert(10,"2",2));
		System.out.println("convert(63,\"Z\",10):"+convert(63,"Z",10));
		System.out.println("convert(64,\"+\",10):"+convert(64,"+",10));
		
		//非法输入		
		//System.out.println(convert(5,"",10));
		//System.out.println(convert(75,"12",10));
		//System.out.println(convert(62,"1-2",10));
		//System.out.println(convert(14,"D",10));
		
		
	}

	static String  convert(int input_mod,String input_value,int output_mod) throws Exception{
		
		if(input_mod<2||input_mod>64||output_mod<2||output_mod>64||input_value==null)
			throw new Exception("the mod should between 2 to 64");
		
		if(input_value=="")
			throw new Exception("input_value is null");
		
		//input_mod 转换为十进制
		int ten_mod_value =0;
		int input_value_length =input_value.length();
		int index = 0;
		
		while(index <input_value_length){
			
			char char_at_index = input_value.charAt(index);
			int digit_at_index = char_to_Integer(char_at_index);
						
			//输入是否在输入进制范围内
			if(digit_at_index > input_mod)
				throw new Exception("input_value is outof the range of input_mod");
			//是否溢出
			if(ten_mod_value>Integer.MAX_VALUE/10)
				throw  new Exception("input_value is overflow ");
			if(ten_mod_value==Integer.MAX_VALUE/10){
				if(digit_at_index>Integer.MAX_VALUE%10)
					throw  new Exception("input_value is overflow ");
			}
			
			ten_mod_value += digit_at_index * Power(input_mod , input_value_length-index-1);
			index++;
		}
				
		
		//将十进制转换为 output_mod 	
		
		StringBuilder  mod_result = new StringBuilder();
		
		while(ten_mod_value>0){				
			mod_result.append(ten_mod_value%output_mod);			
			ten_mod_value = ten_mod_value/output_mod;
			
		}
		
		StringBuilder result = new StringBuilder ();
		
		for(int i=mod_result.length()-1;i>=0;i--){		
			result.append(mod_result.charAt(i));
			
		}
		
		return result.toString();
		}
	
	//幂函数
	static float  Power(int value,int times){
		boolean flag = false;
		float res = 1;
		
		if(times<0){
			flag=true;
			times=-times;
			
		}
		if(times==0)  return res;
		
		while(times>0){
			res*=value;
			times--;
		}				
		
		if(flag)
			res=1/res;
							
		return res;
	}
	
	//char 转化为数字
	static  int char_to_Integer(char char_at_index) throws Exception{
		int digit_at_index=0;
		if(char_at_index>='0'&&char_at_index<='9')
			digit_at_index = char_at_index-'0';
		else if(char_at_index>='a'&&char_at_index<='z')
			digit_at_index = char_at_index-'a'+10;
		else if(char_at_index>='A'&&char_at_index<='Z')
			digit_at_index = char_at_index-'A'+10+26;
		else if(char_at_index=='+'||char_at_index=='/')
			digit_at_index = char_at_index=='+'?62:63;
		else 		
			throw new Exception("illegal input_value");
		
		return digit_at_index;
	}
}

