/* 2018 CCC S1
 * about 40 minutes to complete
 * https://www.cemc.uwaterloo.ca/contests/computing/2018/stage%201/seniorEF.pdf
 */
import java.util.*; 

public class CCC {
	
	public static void main(String[] args) {
		
		ArrayList<Double> al = new ArrayList<Double>();
		Scanner s = new Scanner(System.in);
		int number = s.nextInt();
		for (int i = 0; i < number; i++) {
			double temp = s.nextInt();
			al.add(temp);
		}
		ArrayList<Double> a = new ArrayList<Double>();
		Collections.sort(al); 
		for(int i = 1; i < al.size(); i++) {
			double temp = (al.get(i) - al.get(i-1))/2;
			a.add(temp);
		}
		double last = 0;
		for(int i = 1; i < a.size(); i++) {
			double temp = a.get(i)+a.get(i-1);
			if (i == 1) {
				last = temp;
			}
			else{
				if(temp<last) {
					last = temp;
				}
			}
		}
		System.out.print(last);
	}
	
}
