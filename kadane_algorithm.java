//simple trick to find out the subarray with maxium sum

pub lic class dp53 {

	public static int kadane(int[] arr) {
		
		int max_sofar = 0;
		int max_ending = 0;
		
		for (int i = 0; i < arr.length; i++) {
			
			max_ending = max_ending + arr[i];
			if (max_sofar < max_ending) {
				max_sofar = max_ending;
			}
			if (max_ending < 0) {
				max_ending = 0;
			}
			 
		}
		
		return max_sofar;
		
	}
	public static void main (String args[]) {
				
		int[] talia = {-2,1,-3,4,-1,2,1,-5,4};

		System.out.println(kadane(talia));
		
	}
}
