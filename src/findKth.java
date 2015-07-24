/*
 * 寻找第K小数
 * 
 * 算法导论-第9章
 * 
 * 快排思想找出一个key值，将数组划分成大于和小于key 的两部分
 * 比较 key 的位置与 K 的关系，如果key==K 这个就是第K值
 * 否则 递归调用
 * */
public class findKth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] arr={1,2,3,4,5,3,3,4,2,0};
		int len= arr.length-1;
		int start = 0;
		int k =6;
		int re=FindK(arr,k,start,len);
		System.out.println(re);
	}

	public  static int FindK(int [] arr,int k,int l,int r){	  			
		
		if(l==r)
			return arr[l];		
		
		int t = Sort(arr, l, r);
		//2,新划分的区间与left的距离
		int p = t-l+1;
		//1,这里的 k 都是相对于起始位置 l 的 K,所以判断的时候需要把t 换成相对位置
		if(p==k)  return arr[t];	
		
		if(p<k){
			return FindK(arr,k-p,t+1,r);
		}else{
			//注意这里的left 并不一定是0，因为left 是递归传递过来的参数
			return FindK(arr,k,l,t-1);
		}
		//3,有返回值时有if..return则必须有else..return, 否则报错	
	}
	
	public static int Sort(int [] arr,int l,int r){
		int key = arr[l];
		int i = l;
		int j = r;
		//4,应该判断 i，j的大小而不是l,r
		while (i<j){
			//这里的l<r 是必要的，而且必须是先从后面向前找到小于key 的
			while(i<j&&arr[j]>=key) {
				j--;
				}
			arr[i]=arr[j];
			//注意这里是小于等于
			while(arr[i]<key&&i<j) {
				i++;
			}
			arr[j]=arr[i];
			/*
			 * 这里先找到i,j 交换i,j 最后再交换i n 比较麻烦。
			 * int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;*/
		}
		arr[i]=key;
		return i;
	}
}
