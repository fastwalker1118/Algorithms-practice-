/* 2018 CCC S2
 * took me about 80 minutes to complete
 * https://www.cemc.uwaterloo.ca/contests/computing/2018/stage%201/seniorEF.pdf
 * 2020-11-02-7:02
 */
import java.util.*; 

public class CCCs2 {
	
	ArrayList<Integer> al = new ArrayList<Integer>();
	
	public static boolean issorted(ArrayList<Integer> a) {
		int o = 0;
		for(int i = 1; i < a.size(); i++) {
			if(a.get(i) < a.get(i-1)) {
				o = 1;
			}
		}
		if(o == 1) {
			return false;
		}
		else {
			return true;
		}
	}
	
	public static boolean ok(ArrayList<Integer> al, int number) {
		
		int isfal = 0;
		int size = al.size();
		ArrayList<Integer> temp = new ArrayList<Integer>();
		for(int i = 0; i < size/number; i++) {
			temp.add(al.get(i*number));
		}
		if(issorted(temp) == false) {
			isfal = 1;
		}
		ArrayList<Integer> tem = new ArrayList<Integer>();
		
		for(int i = 0; i < size/number; i++) {
			for(int j = (i+1)*number - number; j < (i+1)*number; j++) {
				tem.add(al.get(j));
			}
			if(issorted(tem) == false) {
				isfal = 1;
			}
			tem.clear();
		}
		if(isfal == 0) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static void turn(ArrayList<Integer> al, int number) {
		
		ArrayList<Integer> temp = new ArrayList<Integer>();
		int var = 0;
		while(var < number) {
			for (int i = number - 1; i >= 0; i--) {
				temp.add(al.get(i*number+var));
			}
			++var;
		}
		al.clear();
		for(int i = 0; i < temp.size(); i++) {
			al.add(temp.get(i));		
		}
	}
	
	public static void main(String[] args) {
		
		CCCs2 talia = new CCCs2();
		Scanner s = new Scanner(System.in);
		int number = s.nextInt();
		for (int i = 0; i < number*number; i++) {
			int temp = s.nextInt();
			talia.al.add(temp);
		}	
		while(ok(talia.al,number) == false) {
			turn(talia.al,number);
		}	
		for(int j = 0; j < number; j++) {
			for(int i = 0; i < number; i++) {
				System.out.print(talia.al.get(j*number + i) + "  ");
			}
			System.out.println();
		}
	}
	
}
