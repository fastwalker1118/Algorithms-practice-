import java.io.*;
import java.util.*;

public class dfs {
	   
		static ArrayList<Integer> key = new ArrayList();
		static ArrayList<Integer> value = new ArrayList();
	
	 	public static void add(int k, int v) {
	 		key.add(k);
	 		value.add(v);
	 	} 
	 	
	 	public static void recur(ArrayList<Integer> visited, int s) {
	 		visited.add(s);
	 		System.out.println(s);
	 		
	 		for (int i = 0; i < key.size(); i++) {
	 			if (key.get(i) == s) {
	 				if (visited.contains(value.get(i)) == false) {
	 					recur(visited, value.get(i));
	 				}
	 			}
	 		}
	 	} 
	 	
	 	
	    public static void main(String args[]) {	
	    	ArrayList<Integer> talia = new ArrayList();
	    	add(0, 1);
	    	add(0, 2);
	    	add(1, 2);
	    	add(2, 0);
	    	add(2, 3);
	    	add(3, 3);
	    	recur(talia, 2);
	    }
}
