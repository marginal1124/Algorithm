
public class Sorts {

/**插入排序**/
	/*1，直接插入排序*/
	
	public static void StraightInsert(int [] arr){
		int len = arr.length;
		if(len==0||len==1)  return;
		
		for(int i=0;i<len-1;i++){
			int next = i+1;
			if(arr[next]>arr[i]){
				
				int InsertIndex = i;
				
				while(InsertIndex>=0&&arr[next]<arr[InsertIndex]){
					arr[InsertIndex]=arr[InsertIndex-1];
					InsertIndex--;
					
				}
				arr[InsertIndex]=arr[next];
			}
			
		}
		
		
	}
	
}
