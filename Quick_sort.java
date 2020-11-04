
public class Quick_sort {
	
	public static void exch(int [] a, int i, int j) {
		int swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	
	public static int partition(int [] a, int lo, int hi) {
		
		int i = 0, j = hi + 1;
		
		while(true) {
			
			while (a[++i] < a[lo]) { // Always compare a[i] with the partition element(the first element) first
				if (i == hi) {
					break;
				}
			}
			while (a[lo] < a[--j]) {
				if (j == lo) {
					break;
				}
			}	
			if (i >= j) {
				break;
			}
			exch(a, i, j);
			
		}
		
		exch(a, lo, j);
		return j;
		
	}
	
	public static void sort(int [] a) {
		//StdRandom.shuff(a);
		sort(a, 0, a.length - 1);
	}
	
	public static void sort(int[] a, int lo, int hi) {
		
		if(hi <= lo) {
			return;
		}
		int j = partition(a, lo, hi);
		sort(a, lo, j-1);
		sort(a, j+1, hi);		
	}
	
	public static void main(String[] args) {
		
		int[] a = {9, 1, 3, 20, 45, 14, 6, 31};
		sort(a); // passes the array as an argument to sort method
		for (int i = 0; i < a.length; i++) { 
			System.out.print(a[i] + "   ");  
		}	
		
	}
}
