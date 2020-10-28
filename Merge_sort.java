public class Merge_sort {

	public static boolean less(int v, int w) {
		if (w>v) {
			return true;
		}
		else {
			return false;
		}
	}
	
	
	public static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
		
		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];  
		}
		
		int i = lo, j = mid+1; 
		
		for (int k = lo; k <= hi; k++) {
			if (i > mid) {
				a[k] = aux[j++];
			}
			else if (j > hi) {  // else if not if
				a[k] = aux[i++];
			}
			else if (less(aux[j], aux[i])) {  // else if not if
				a[k] = aux[j++]; 
			}
			else {
				a[k] = aux[i++];
			}
		}
		
	}
	
	public static void sorting(int[] a, int[] aux, int lo, int hi) {
		
		if (hi <= lo) {
			return;
		}
		
		int midd = lo + (hi - lo) / 2;
		sorting (a, aux, lo, midd); // not sorting (aux, a, lo, midd);
		sorting (a, aux, midd+1, hi);
		merge(a, aux, lo, midd, hi);
	}
	
	public static void sort(int[] a) {
		int[] aux = new int[a.length];
		sorting(a,aux,0,a.length-1);
	}
	
	public static void main(String[] args) {
		
		int[] a = {80, 16, 70, 56, 52, 62, 98, 30, 79, 55, 55};
		sort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "   ");
		}
			
	}
	
}