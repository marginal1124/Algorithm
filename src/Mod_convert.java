/*
 * X进制转化为Y进制函数,其中X和Y为2到64之间的任意数
 * 
 * 0-64 的表示方式：0-9 、 a-z 、 A-Z 、+、 /
 * 
 * 非法字符抛出异常
 * 非法输入抛出异常
 * 
 * 字符串起始是 '-' 的话如何考虑??小数如何考虑，小数的位数？
 * 
 * */
public class Mod_convert {
		
	public static void main(String[] args) throws Exception {
		System.out.println("convert(4,\"4.2\",10):"+convert(4,"3.2",2));
		System.out.println("convert(10,\"2\",2):"+convert(10,"2",2));
		System.out.println("convert(63,\"Z\",10):"+convert(63,"Z",10));
		System.out.println("convert(64,\"+\",10):"+convert(64,"+",10));
		
		//非法输入		
		//System.out.println(convert(65,"12",10));
		//System.out.println(convert(62,"1-2",10));
		//System.out.println(convert(14,"14",10));
		//System.out.println(convert(4,"3.1.2",10));
		
		
	}
	static String  convert(int input_mod,String input_value,int output_mod) throws Exception{
		
		if(input_mod<2||input_mod>64||output_mod<2||output_mod>64||input_value==null)
			throw new Exception("the mod should between 2 to 64");
		
		if(input_value=="")
			throw new Exception("input_value is null");
				
		int Integer_value =0;
		float Decimal_value = 0;
		
		int index = 0;
		int the_number_of_point=0;
		int point_index = input_value.length();
		
		//判断是否为小数
		for(int i=1;i<input_value.length();i++){
			if(input_value.charAt(i)=='.'){
				the_number_of_point++;
				point_index=i;
			}		
		}
		if(the_number_of_point>1)
			throw new Exception("illegal input_value");	
		
		//input_value 转换为十进制
		while(index <input_value.length()){
			
			char char_at_index = input_value.charAt(index);
			
			int digit_at_index = 1;		
			if(index!=point_index){
				digit_at_index = char_to_Integer(char_at_index);	
			}
			
			//输入是否在输入进制范围内
			if(digit_at_index >= input_mod)
				throw new Exception("input_value is outof the range of input_mod");
			
			if(index < point_index)
				Integer_value += digit_at_index * Power(input_mod , point_index-index-1);	
			if(index > point_index)	{	
				Decimal_value += digit_at_index * Power(input_mod , -index+point_index);
			
			}
			
			index++;
		}
						
		//将十进制转换为 output_mod 	
		
		StringBuilder  mod_result_Integer_part = new StringBuilder();
		//整数部分
		while(Integer_value>0){				
			mod_result_Integer_part.append(Integer_value % output_mod);			
			Integer_value = Integer_value / output_mod;
			
		}
		
		StringBuilder result = new StringBuilder ();
		
		for(int j = mod_result_Integer_part.length()-1;j >= 0;j--){		
			result.append(mod_result_Integer_part.charAt(j));
			
		}
		//小数部分
		if(point_index!=input_value.length()){
			result.append('.');
			while(Decimal_value!=0){
				int Integer_part = (int) (Decimal_value*output_mod);
				result.append(Integer_part);
				Decimal_value = Decimal_value*output_mod-Integer_part;
			}
			
			result.append('0');
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
	
	//char 类型转化为数字
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