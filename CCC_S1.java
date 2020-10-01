// Note, "=" operator assigns left reference to right value, the order matters!

/*2020.10.01 it took me 80 minutes for me to finish
 *(would be faster tahn 80 minutes in an actual test, this time include chating and other stuff, I would say 60 minutes in an actual test)
 * 2020 senior CCC . S1
 * https://cemc.uwaterloo.ca/contests/computing/2020/ccc/seniorEF.pdf
 */

import java.util.*;
import java.lang.Math; 

public class CCC_S1 {
	
	int number; //number of imputs
	ArrayList<Integer> time = new ArrayList<Integer>();
	ArrayList<Integer> distance = new ArrayList<Integer>();
	double speed = 0.00;
	
	public static void main(String[] args) {
		
		CCC_S1 a = new CCC_S1();
		Scanner s = new Scanner(System.in);
		int number = s.nextInt();
		for (int i=0; i<number; i++) {
			int temp_time = s.nextInt();
			int temp_distance = s.nextInt();
			a.time.add(temp_time);
			a.distance.add(temp_distance);
		}
		
		for (int i=0; i<a.time.size(); i++) {
			for (int o=i+1; o<a.time.size(); o++) {
				double d = Math.abs(a.time.get(o) - a.time.get(i));
				double e = Math.abs(a.distance.get(o) - a.distance.get(i));		
				if(e/d > a.speed) {
					a.speed = e/d;
				}
				
			}
		}
		
		System.out.println(a.speed);
		
	}
	
}
