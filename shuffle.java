import java.util.*;

public class shuffle {
	
	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	public static void exchange(Comparable[] a, int i, int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	
	public static void shuffling(Comparable[] a) {
		int N = a.length;
		Random rand = new Random();
		for (int i = 1; i < N; i++) {
			int r = rand.nextInt(i);
			exchange(a, i, r);
		}
	}
	
	public static void main(String[] args) {
		
		Comparable[] a = {1,2,3,4,5,6,7,8,9,10};
		shuffling (a);
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
	
}
