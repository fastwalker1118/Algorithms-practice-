/*
 * Comparable interface is used to sort arrays
 * A comparable object is capable of comparing itself with another object
 */

public class Selection_sort implements Comparable{
	
	public static void sort(Comparable[] a) {
		int N = a.length;
		for(int i = 0; i < N; i++) {
			int min = i;
			for (int j = i+1; j < N; j++) {
				if(less(a[j], a[min])) {
					min = j;
				}
			}
			exchage(a, i, min);
		}
	}
	
	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	public static void exchage(Comparable[] a, int i, int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	
	/*public static void main(String[] args) {
		
		Comparable[] a = {1,5,3,5,2,9,5,1,9,0,12,43,23};
		sort(a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		
		Comparable[] b = {'T','a','l','i','a','i','s','S','O','p','r','e','t','t','y'};
		sort(b);
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
		
	}*/

	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}


