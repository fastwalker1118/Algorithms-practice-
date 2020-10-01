// Note, "=" operator assigns left reference to right value, the order matters!

/*2020.10.01 it took me 50 minutes for me to finish
 * 2020 senior CCC . S1
 * https://cemc.uwaterloo.ca/contests/computing/2020/ccc/seniorEF.pdf
 */

import java.util.*;
import java.lang.Math; 

public class CCC_S1 {
	
	int number; //number of imputs
	ArrayList<Integer> time = new ArrayList<Integer>();
	ArrayList<Integer> distance = new ArrayList<Integer>();
	int shortest_time = 100000000;
	int longest_distance = 0;
	
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
				int d = Math.abs(a.time.get(o) - a.time.get(i));
				if(d<a.shortest_time) {
					a.shortest_time = d;
				}
				int e = Math.abs(a.distance.get(o) - a.distance.get(i));
				if(e>a.longest_distance) {
					a.longest_distance = e;
				}
				
			}
		}
		
		System.out.println(a.longest_distance/a.shortest_time);
		
	}
	
}
