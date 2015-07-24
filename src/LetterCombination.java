import java.util.ArrayList;

//经典的递归问题，标准的DFS。。都不太会~~(>_<)~~
//所以这里直接参考答案了
//输入数字，给出电话号码盘上对应的字符串的全排列
public class LetterCombination {

	public static void main(String[] args) {
		String digits="03";
		
		ArrayList<String> res = letterComb(digits);
		for(int i=0;i<res.size();i++){
			System.out.print(res.get(i)+" ");
		}
	}
	public static ArrayList<String> letterComb(String digits){
		String [] map = {" "," ","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
	
		ArrayList<String> res = new ArrayList<String>();
		int len = digits.length();
		StringBuilder temp = new StringBuilder();
		
		if(len==0)  return res;
	
		dfs(digits,temp,res,map,0);
		return res;
	}
	public static void dfs(String digits,StringBuilder temp,ArrayList<String> res,String[] map,int deep){
		
		
		int len = digits.length();
		
		//System.out.println(num+"|"+map[num]);
		if(deep==len){
			res.add(temp.toString());
			return;
		}
		else{
			int num = digits.charAt(deep)-'0';
			for(int j=0;j<map[num].length();j++){
				temp.append(map[num].charAt(j));
				//System.out.println(map[num].charAt(j));
				dfs(digits,temp,res,map,deep+1);
				//将temp送入下一层循环后，应该将最后一位刚添加的清除，否则下一个j++会导致temp还留有上次循环添加的，长度边长
				temp.deleteCharAt(temp.length()-1);
			}
		}
	}

}
