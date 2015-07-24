public class SearchAlorithms {
	
	//pivot为可以自己定义选定的参照值
	//看看这个可不可以
	//http://www.bubuko.com/infodetail-437781.html
	static  int partition(int[] a, int start, int end, int pivot) {
		          int i = start;
		          int j = start;
		          for(j = start; j < end; j++) {
		              if(a[j]<=pivot) {                
		                  int temp=a[i];
		                   a[i]=a[j];
		                  a[j]=temp;
		                  i++;
		              }
		        }
		          int temp2 = a[i];
		         a[i]=a[end];
		          a[end]=temp2;
		         return i;        
		    }
		      
		static  int selectkth(int[] a, int start, int end, int k) {
		         if(start == end) 
		             return a[start];
		         int q = partition(a,start,end,a[end]);
		         int p = q-start+1;
		         if(k == p)
		             return a[q];
	        else if(k < p) {
		             return selectkth(a, start, q-1, k);
		        }
		        else return selectkth(a, q+1 , end, k-p);        
		      }
		     
		  public  static  void  main(String[] args){
		    	 
			  int[] arr ={11,11,43,43,34,49,15};
			  int k =4;
			  int end = arr.length-1;
			  int res = selectkth(arr, 0, end, k);
			  System.out.print(res);
		     }
}