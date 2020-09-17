/* When constructing an object a, and assigning object a to b, 
b and a are both references to the object a;
whereas when you assign a variable a to b, a and b are both independent varibles

-----------------------------------------------------------------------
As an example :
--------------------------------------------
int a = 5;
int b = a;
b and a are 2 objects both equals to 5
--------------------------------------------
private node first = null;
node oldfirst = first; 
here, oldfirst and first are both reference to the null object
------------------------------------------------------------------------

when you want to create an independent object, you have to use new operater
like 
first = new node();
*/

package hello;

public class hello {

	private node first = null;
	
	private class node{
		String item;
		node next;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void push(String item) {
		node oldfirst = first; 
		first = new node();
		first.item = item;
		first.next = oldfirst;
	}
	
	public String pop() {
		String item = first.item;
		first = first.next;
		return item;
	}
	
}


// ----------------------------------------------------------------------------------------------------------------------
/* 
Unlike the previous version which only works for Strings, this version uses java generics which allows it to work with every data type
*/
public class hello<Item> {

	private node first = null;
	
	private class node{
		Item item;
		node next;
	}
	
	public boolean isEmpty() {
		return first == null;
	}
	
	public void push(Item item) {
		node oldfirst = first; 
		first = new node();
		first.item = item;
		first.next = oldfirst;
	}
	
	public Item pop() {
		Item item = first.item;
		first = first.next;
		return item;
	}
	
}
