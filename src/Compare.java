
public class Compare {

	public static void main(String[] args) {
		 int[] arr = {1,4,2,1,3,7,12,0,9};
		 Insert(arr);

	}
	//插入排序
	public static void Insert(int [] arr){
		int length = arr.length;
		
		for(int i=0;i<length;i++){
			int insertVal = arr[i];
			//错误，应该用insert 来记录下标，而不是i
			 while(i>0&&insertVal<arr[i-1]){
				 arr[i]=arr[i-1];
				 i--;
			 }
			 System.out.println("i:"+i);
			 arr[i]=insertVal;
		}
		
		for(int i=0;i<length;i++){
			System.out.print(arr[i]+" ");
		}
	}
	
	//快排
	public  static  void  QuickSort(int [] arr,int l,int r){
		
		int i = Adjust(arr,l,r);
		//因为此时i 的位置已经找好
		QuickSort(arr, l, i-1);
		QuickSort(arr, i+1, r);
	}
	public static  int Adjust(int [] arr,int l,int r){
		int m = arr[l];

		while(l<r){
			while(l<r&&arr[r]>m){
				r--;			
			}
			arr[l]=arr[r];
			while(l<r&&arr[l]<m){
				l++;
			}
			arr[l]=arr[r];
		}
		arr[l]=m;
		return l;
	}

}
