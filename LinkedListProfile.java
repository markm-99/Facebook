package facebook;
/*
 * 	@variable head: Uses chain's head link.
	Uses a LinkedList that allows values to follow the Comparable properties.
*/
public class LinkedListProfile 
{
	private Person head; // uses the head link of the chain
	/*
	initializes an instance of LinkedList.
	*/
	LinkedListProfile() 
	{
		head = null; //assigns the head to null
	}
	/*
		Looks for a reference to the node and match each respective value.
		@return value
		@param p = specific value to search for
	*/
	Person search(String p) 
	{
		Person z = head; // uses the head as a reference to the existing link 
		while (z != null && !z.name.equals(p)) 
		{ // iterate through the chain until reaching corresponding values in order to begin matching
			z = z.next; // iterate through the chain and add to next Link
		}
		
		if(z!=null)
		{
			return z;
		}
		return null;
	}	
	
	/*
	Retrieve the data by the key. 
	Keys associated with values such as a hash-table
	@param  p = the key to search for
	@return value = value that corresponds to the key
	*/
	Person get(String p) 
	{
		Person b = head; // get reference to the head Link
		while (b != null && !b.name.equals(p) && b.name != null) 
		{ 
			// go down the chain until a key matches
			b = b.next; // iterate to next Link
		}
		if(b!=null)
		{
		  return b;
		}
		return null;
	}
	/*
		Supports the connection of corresponding values to be retrieved
		Start inserting new values to list
		@param p = value to insert to the list
		@return internal link of value to it's respective key
	*/
	void insert(Person p) 
	{
		Person link = p; // create link and it's wrapper for the associated value
		link.next = head; // assign next to the list's head 
		if (head != null)
			head.prev = link; // assign previous to head, so link becomes new head
		head = link; // assign head to link
		link.prev = null; // assign link previous to null as it's new head
	}
	/*
	Display a list of values 
	@return appropriate string of values
	 */

	public String toString() 
	{
	Person y = head; // get the head reference
	String yield = ""; // initialize a string to return
	while (y != null) 
	{ 
		// iterate over the current list
		yield += y.toString()+ "\n"; // add on to the current output
		y = y.next; // iterate to the next
	}
	return yield; // return string
}

	/*
	Deletes a value from list.
	@param p: the value to remove
	*/
	void delete(Person p) {
		Person y = head; // get reference to head
		while (!y.equals(p) && y != null) { // iterate over links until node is found
			y = y.next; // iterate
		}
		if (y.prev != null)
			y.prev.next = y.next; // assign previous to y's next
		else
		if (y.next != null)
			y.next.prev = y.prev; // assign y's next's previous to y's previous
	}

	/*
	   @param p = value that corresponds to key
	   @param key = key to search up
	*/
	void insert(Person p,String key) 
	{
		Person link = p; // create a link wrapper for value
		link.next = head; // assign next to head
		link.name = key; // assign name to key
		if (head != null)
			head.prev = link; // assign previous to head, so link becomes new head
		head = link; // assign head to link
		link.prev = null; // assign link previous to null as it's new head
	}
}
	
	