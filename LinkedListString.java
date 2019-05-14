package facebook;
/*
	Will implement a LinkedList for values that will abide to Comparable interface.
	@variable head contains the chain's head link
*/

public class LinkedListString 
{
	private StringLink head; // chain's head link
	/*
		Instance of the LinkedList initialized
	*/
	LinkedListString() 
	{
		head = null; // assigns the head to null
	}
	/*
		Search for a reference to the node, matches the supplied value.
		@return value
		@param p = specific value to search for
	*/
	String search(String peopleName) 
	{
		StringLink a = head; // reference the head of the existing link
		while (a != null && !a.name.equals(peopleName)) 
		{ 
			//iterate through the chain until values start to match			
			a = a.next; // iterate through and add to next Link
		}
		if(a!=null)
		{
			return a.name;
		}
		return null;
	}
	/*
		Key will get the link. LinkedList will use those keys, match keys and values in the form of a hash-table
		@return connects value with a key
		@param 's' lists a key to search for
	*/
		String get(String s) 
		{
		StringLink b = head; // get reference to head Link
		while (b != null && b.name != null && !b.name.equals(s)) 
		{ 
		// go down the chain until a key matches
		b = b.next; // iterate to next Link
		}
		if(b!=null)
		{
			return b.name;
		}
		return null;
	}
	/*
		Using a wrapper class, we can retrieve the data used to connect specific values.
		@return the internal link for the values related to the key
		@param t: stands for key of the link
	*/	
	StringLink grabStringLink(String t)
	{
		StringLink y = head; 
		while(y!= null && y.name!=null && !y.name.equals(t))
		{
			y = y.next;
		}
		return y;
	}
	/*
		Inserts a = new value added to the friend list
		@param z  = new value to insert to friend list
	*/
	/*
	Insertion that also accounts for keys and their specific values
	@param x = displays the value corresponding to key
	@param key = displays specific key to lookup
*/
	void insert(String z) 
	{
		StringLink links = new StringLink(z); // create a link wrapper for the value
		links.next = head; // assign a next to list the head
		if (head != null)
			head.prev = links; // assign previous to head, so link becomes new head
		links.prev = null; // assign link previous to null as it's new head
		head = links; // set head to link
	}
	
	/*
	 * @param x: the corresponding value to remove
		Deleted a value from the list.
    *   y = linked list's head
	*/
	void delete(String x) {
		StringLink y = head; // get reference to head
		while (y != null && !y.name.equals(x)) { // iterate over links until node is found
			y = y.next; // iterate through the list
		}
		if (y.prev != null)
			y.prev.next = y.next; // set previous to be y's next
		else
			head = y.next; // set head to be next node
		if (y.next != null)
			y.next.prev = y.prev; // set y's next's previous to become y's previous
	}
	
	/*
	Prints list of values, 
	 \n = new line (lists),
	@return string of respective values
	*/
	public String toString() 
	{
		String yield = ""; // initialize string to return
		StringLink y = head; // get head reference
		while (y != null) 
		{ // iterate over list
			yield = yield + y.name.substring(0,1).toUpperCase() + y.name.substring(1, y.name.length()).toLowerCase() + "\n"; // add to yield
			y = y.next; // iterate
		}
		return yield; // return string
	}
}
