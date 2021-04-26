package testing;
import java.util.*;
public class binary_search {

	public static void main(String[] args) {
		
		int[] arr = {1,2,3,4,5,6,7,8,9,10,16,18,20,21};
		
		Scanner s = new Scanner(System.in);
		System.out.println("enter the key : ");
		int key = s.nextInt();
		int low=0;
		int high= arr.length - 1;
		int mid=0;
		
		while(low<=high) {
			
			mid=(low+high)/2;
			
			if(key<arr[mid]) high=mid-1;
			else if(key>arr[mid]) low=mid+1;
			
			else if(key==arr[mid]) {
				System.out.println("found at index:"+mid);
				break;
			}
		}
	}	
}
