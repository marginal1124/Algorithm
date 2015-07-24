/*
 * 期望值为线性时间的寻找第K 大数
 * 
 * 快排中的key值随机寻找  Math.Random()
 * 
 * */
public class LineFindKth {

	public static void main(String[] args) {

		int [] arr ={1,2,3,3,4,4,4};
		int l =0;
		int r = arr.length-1;
		int k =5;
		
		System.out.println(findK(arr,l,r,k));

	}
	
	public static int findK(int arr[],int l,int r,int k){
		
		if(l==r)  return arr[l];
		
		int t = randomQuickSort(arr,l,r);
		//这里不可以直接比较k 与 t 的关系 因为 k 是相对的位置
		//求出t 的相对位置
		int length = t-l+1;
		if(length == k) return arr[t];
		
		if(length<k) 
			 return findK(arr,t+1,r,k-length);
		else return findK(arr,l,t-1,k);
		
	}

	static int randomQuickSort(int[] arr, int l, int r) {
		// l-r 之间的随机整数
		int random = (int) (Math.random()*(r-l+1)) + l;
		System.out.print("random:"+random+" ");
		
		if(random!=l){
			int temp = arr[random];
			arr[random] = arr[l];
			arr[l] = temp;
		}
		
		return quickSort(arr,l,r);
	}

	static int quickSort(int[] arr, int l, int r) {
		int key = arr[l];
		int i = l;
		int j = r;
		
		while(i<j){
			while(i<j&&arr[j]>=key)  j--;
			arr[i]=arr[j];
			
			while (i<j&&arr[i]<key)  i++;
			//i  ,j 交换位置
			arr[j]=arr[i];
		}
		
		arr[i]=key;
		return i;
	}

}
