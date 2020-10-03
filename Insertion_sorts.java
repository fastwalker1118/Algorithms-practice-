
public class Insertion_sorts implements Comparable{

	public static void sort(Comparable[] a) {
		int N = a.length;
		for(int i = 0; i < N; i++) {
			for (int j = i; j > 0; j--) {
				if(less(a[j], a[j-1])) {
					exchange(a,j,j-1);
				}
				else {
					break;
				}
			}
		}
	}
	
	public static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	public static void exchange(Comparable[] a, int i, int j) {
		Comparable swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	
	public static void main(String[] args) {
		
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
			
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
