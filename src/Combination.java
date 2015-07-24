import java.util.Vector;

/*
 * 组合问题，{1,2}组合{}{1}，{2}，{1,2}
 * */
public class Combination {

	public static void main(String[] args) {
		
		char [] ch = {'a','b','c'};
		//Vector<String> res = subSet(ch);
		
		/*for(int i=0;i<res.size();i++){
			System.out.print(res.get(i)+" ");
		}*/
		
		int [] arr = {3,5};
		ArrCom(arr);
	}
	
	public static void  comb(char[] ch){
		
		int length = ch.length;
		//左移相当于求幂。左右移时应该先换为二进制，再移位
		int num = 2<<(length-1);
		System.out.println(num+","+length);
		
		for(int i=0;i<num;i++){
			
			for(int j=0 ;j<length;j++){
				
				int temp = 1<<j;
				//按位与&
				if((temp&i)!=0)
					System.out.print(ch[j]);
				
			}
			System.out.println();
		}
	}
	
	public static void ArrCom(int[] arr){
		int len = arr.length;
		boolean [] solution = new boolean[len];
		
		combi(arr,solution,0);
	}
	public static void combi(int [] arr,boolean [] solution,int t){
		int len = arr.length;
		if(t==len){
			for(int j=0;j<solution.length;j++){
				if(solution[j])
				System.out.print(arr[j]);
			}
			System.out.println();
			return;
		}
		
		//将t 加入子集合
		solution[t]=true;
		combi(arr,solution,t+1);
		//不加入
		solution[t]=false;
		combi(arr,solution,t+1);
		
	}
	
	
	//使用DFS 深度优先搜索来解决
	
	public static Vector<String> subSet(char[] ch){
		
		Vector<String> ve = new Vector<String>();
		
		int len = ch.length;
		StringBuffer stb = new StringBuffer();
		if(len==0)  return ve;
		dfs(ch,ve,stb,0);
		
		return ve;
	}
	
	//这里的 DFS 与电话字母组合的不同是这个的字符来源都是一样的，
	//而第二个每次递归，所添加到后面的字符来源变化
	public static  void dfs(char [] ch,Vector<String> ve,StringBuffer stb,int deep){
		int len = ch.length;
		if(deep==len){
			ve.add(stb.toString());
			return;
		}
		else{
			
			//不选择本节点
			dfs(ch,ve,stb,deep+1);
			
			//选择本节点
			stb.append(ch[deep]);
			dfs(ch,ve,stb,deep+1);
			
			//可是这里为什么一定要最后删除掉前面加上的呢？、
			//因为上面==len 只是return 不再计算，return之后还会计算吗？不会！！
			System.out.println(stb+",");
			
			stb.deleteCharAt(stb.length()-1);
			
			//return了 就是本次递归退出了整程序，所以这段不执行
			if(deep==len){
				System.out.println(">>");
			}
			
			
		}
		
	}

}

