/*
 * 给定一个字符串，要求把字符串前面的若干个字符移动到字符串的尾部，
 * 如把字符串“abcdef”前面的2个字符'a'和'b'移动到字符串的尾部，
 * 使得原字符串变成字符串“cdefab”。
 * */
public class reverse {

	public static void main(String[] args) {
		String s=new String("hello");
	
		System.out.println(test1(s,2));

	}
	//使用StringBuffer
	static  String test1(String s,int n){
		
		StringBuffer str1 = new StringBuffer();
		StringBuffer str2 = new StringBuffer();
		
		for(int i=0;i<s.length();i++){
			if(i<n){
				str1.append(s.charAt(i));
			}else{
				str2.append(s.charAt(i));
			}
		}
		str2.append(str1);
		return str2.toString();
		
	}

	 
	}

