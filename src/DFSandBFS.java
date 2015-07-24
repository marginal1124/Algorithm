import java.util.*;
/*
 * 深度优先，广度优先   邻接链表
 * */
public class DFSandBFS {

	//构建图
	private int n;
	private List<ArrayList<Integer>> G;
	private boolean[]  visited ;
	
	public DFSandBFS(int n,List<ArrayList<Integer>> G){
		this.n = n;
		this.G = G;
		visited = new boolean[n];
		
		
	}
	/*
	 * 犯的错误：
	 * List 是抽象的  后面 new需要ArrayList 实现
	 * ArrayList的get(i)，是获取下标
	 * 构造函数
	 * */
	
	/*
	 * 广度优先，队列
	 * 1，将起始元素放入队列中
	 * 2，对队首元素进行操作。并将它相邻的未被访问过的元素放入队列----因为邻接表，所以会比DFS简单很多，
	 * 
	 * */
	public  void bfsSearch(int v){
		//队列用queue，
		Queue<Integer> que = new LinkedList<Integer>();
		
		que.add(v);
		
		while(!que.isEmpty()){
			/*
			 * 注意
			 * 不能是peek:does not remove, the head of this queue
			 * 
			 * poll:Retrieves and removes the head of this queue
			 * */
			v = que.poll();
			//v = que.remove();---remove()方法同样可以
			
			
			System.out.print(" "+v+",");			
			visited[v-1] = true;
			//que.remove(v);
			
			for(int i=0;i<G.get(v-1).size();i++){
				
				int temp = G.get(v-1).get(i);
				if(!visited[temp-1]){
					que.add(temp);
					visited[temp-1] = true;
				}
			}	
		}
	}
	
	public void dfsSearch(int v){
		
		System.out.print(v+" ");
		 visited[v-1] = true;
		 
		 for(int i=0;i<G.get(v-1).size();i++){
			 int k = G.get(v-1).get(i);
			 
			 if(!visited[k-1]){
				 dfsSearch(k);
			 }
		 }
	}
	
	/*
	 * 栈方法
	 * 1，将第一个元素推入栈中，并输出
	 * 2，判断栈顶元素，根据临界链表，是否存在没有被访问过的元素
	 * 3，如果存在，将其输出，并压入栈中
	 * 4，如果不存在，将它移除，并返回第二步
	 * 
	 * PS：何时对元素输出，需要看具体的要求了。这里DFS，就是第一次访问到该元素的时候了
	 * */
	public  void dfsSearchStack(int v){
		Stack<Integer> s = new Stack<Integer>();
		
		System.out.print(v+",");
		//这里也是v-1！！
		visited[v-1]=true;
		s.push(v);
		while(!s.isEmpty()){
			
			int temp = isVisited(s.peek());
			
			if(temp==-1){
				s.pop();
			}else {	
				//这里出错，应该 temp-1 的啊，为什么不对
				visited[temp-1]=true;
				System.out.print(temp+",");				
				s.push(temp);				
			}
		}		
	}
	
	public int isVisited(int v){
		ArrayList<Integer> list = G.get(v-1);
		int t=-1;
		
		for(int i=0;i<list.size();i++){
			//晕，这里应该是list.get(i)减去1
			if(visited[list.get(i)-1]==false){
				t = list.get(i);
				//System.out.print(" (t="+t+") ");
				return t;
			}
		}
		
		return t;
	}
	
	public static void main(String[] args) {
		 
		int n = 6;
		//这里new 后面就不可以用List了， 因为List是抽象的
		//如果图中是用字母表示的话，邻接表可以用hashMap来表示
		//这里直接用下标来表示定点数
		List<ArrayList<Integer>>  G = new ArrayList<ArrayList<Integer>>();
		
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		list1.add(2);list1.add(3);
		G.add(list1);
		
		ArrayList<Integer> list2 = new ArrayList<Integer>();
		list2.add(4);list2.add(1);
		G.add(list2);
		
		ArrayList<Integer> list3 = new ArrayList<Integer>();
		list3.add(1);list3.add(4);list3.add(5);
		G.add(list3);
		
		ArrayList<Integer> list4 = new ArrayList<Integer>();
		list4.add(2);list4.add(3);list4.add(6);
		G.add(list4);
		
		ArrayList<Integer> list5 = new ArrayList<Integer>();
		list5.add(3);list5.add(6);
		G.add(list5);
		
		ArrayList<Integer> list6 = new ArrayList<Integer>();
		list6.add(5);list6.add(4);
		G.add(list6);			
		
		DFSandBFS bfs = new DFSandBFS(n,G);
		//bfs.bfsSearch(1);
		//bfs.dfsSearch(1);
		
		bfs.dfsSearchStack(1);
	
	}
}



