/*The difference between if and else if 
 *for else if, if the first if is true, all of the else if s won't be executed,
 */

public class Merge_sort {

	public static boolean less(int v, int w) {
		if (w>v) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public static void merge(int[] a, int[] aux, int lo, int midd, int hi) {
		
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];  
		}
		
		int i = lo, j = midd+1; 
		
		for (int k = lo; k <= hi; k++) {
			if (i > midd) {
				a[k] = aux[j++];  
			}
			else if (j > hi) {
				a[k] = aux[i++];
			}
			else if (less(aux[j], aux[i])) { 
				a[k] = aux[j++]; 
			}
			else {
				a[k] = aux[i++];
			}
			/*for (int io = 0; io < a.length; io++) {
				System.out.print(a[io] + "   ");
			}
			System.out.println();
			for (int io = 0; io < a.length; io++) {
				System.out.print(aux[io] + "   ");
			}
			System.out.println();*/
		}
		
	}
	
	public static void sorting(int[] a, int[] aux, int lo, int hi) {
		
		if (hi <= lo) {  
			return; 
			// base case for the recursion later
		}
		// we use index variables lo, midd, hi to "divide and conquer"
		// the original value is low = 0, mid = 5, high = 10
		int midd = lo + (hi - lo) / 2; 
		sorting (a, aux, lo, midd); 
		sorting (a, aux, midd+1, hi); 
		
		/*System.out.println(lo);
		System.out.println(midd);
		System.out.println(hi);
		System.out.println(); */
		
		merge(a, aux, lo, midd, hi); 
		
	}
	
	public static void sort(int[] a) {
		int[] aux = new int[a.length]; // creates an auxiliary array with the same length
		sorting(a,aux,0,a.length-1); // passes the array and the auxiliary to sorting method with the first and last index number
	}
	
	public static void main(String[] args) {
		
		int[] a = {80, 16, 70, 56, 52, 98, 30,  79};
		sort(a); // passes the array as an argument to sort method
		for (int i = 0; i < a.length; i++) { 
			System.out.print(a[i] + "   ");  
		}
			
	}
	
}