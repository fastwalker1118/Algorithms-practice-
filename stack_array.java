public class stack_array {
	
	private String[] s;
	private int N = 0;
	
	public stack_array() {
		s = new String[1];
	}
	
	public boolean isEmpty() {
		return N == 0;
	}
	
	public void push(String item) {
		if(N==s.length) {
			resize(2*s.length);
		}
		s[N++] = item;
	}
	
	public void resize(int capacity) {
		String[] copy = new String[capacity];
		for (int i = 0; i<N; i++) {
			copy[i] = s[i];
		}
		s = copy;
	}
	
	public String pop() {
		String item = s[--N];
		s[N] = null;
		return item;
	}
	
}	