
public class KthOFtwoArr {

	public static void main(String[] args) {

		int [] a = {};
		int [] b = {2,3};
		/*
		 * 计算普通 K 大数
		 * 
		 * int k = 5;
		System.out.println(findKofTwoArr(a, 0, a.length-1, b, 0, b.length-1, k));
		*/
		
		
		/*
		 * 计算中位数*/
	    double result;
		int alen = a.length;
		int blen = b.length;
		int kth ;
		System.out.println(alen);
		//判断数组长度之和是否为奇数
		if((alen+blen)%2==1){
			kth=(alen+blen+1)/2;
			
			result = findKofTwoArr(a, 0, alen-1, b, 0, blen-1, kth);
		}else {
			kth = (alen+blen)/2;
			
			result =( findKofTwoArr(a, 0, alen-1, b, 0, blen-1, kth)+findKofTwoArr(a, 0, alen-1, b, 0, blen-1, kth+1))/2;
		}
		System.out.println("the Kth menber is "+result);
	}
	
	public  static  double findKofTwoArr(int [] a,int aStart, int aEnd,int b[],int bStart,int bEnd,int k){
	
	    int alen = aEnd - aStart+1;
	    int blen = bEnd - bStart+1;
	    
	    if(alen>blen)  return findKofTwoArr(b,bStart,bEnd,a,aStart,aEnd,k);
	    
	    //这里k 仍然是相对于start的位置。
	    if(alen==0)  return b[bStart+k-1];

	    if(k==1)  return a[aStart]>b[bStart]?b[bStart]:a[aStart];
	  
	    
	    //判断数组A 长度是否大于k/2
	    int ak = alen>(k/2)?(k/2):alen;
	    int bk = k-ak;
	 
	    
	    //比较k/2 处的两个数组值的大小
	    //注意这里的ak bk 都是相对位置，所以求其所在位置的数组值的大小需要加上 start
	    if(a[aStart+ak-1] == b[bStart+bk-1]) return a[aStart+ak-1];
	    else if(a[aStart+ak-1] > b[bStart+bk-1]){
	    	return  findKofTwoArr(a, aStart, aEnd, b, bStart+bk, bEnd, k-bk);
	    }
	    else  return findKofTwoArr(a, aStart+ak, aEnd, b, bStart, bEnd, k-ak);
	
	}

}
