package facebook;
/*
	Person class will resemble a profile in facebook's system.
	@variable name: declares the user's name 
	@variable friends: provides the IDs of the user's friends
	@implements Comparable: used to compare 2 profiles for deep-equality
*/

public class Person implements Comparable {
	LinkedListString friends; // LinkedList stores the user's friends IDs	
	 Person next; // reference to the next link
	 Person prev; // reference to the previous link
	 String name; // name of the user

	
	 Person(String x) 
	{
		this.name = x; // profile name will then be set
		next = null;
		prev = null;
		friends = new LinkedListString(); // LinkedListString method used to initialize the linkedList
	}

	Person(String name, LinkedListString friends) 
	{
		this.name = name; // set the name on created profile
		next = null;
		prev = null;
		
		if (friends != null) // if friend list does not exist
			this.friends = friends; // update the friends list
		else
			this.friends = new LinkedListString(); // new friends are initialized to a blank list
	}
	/*
		Add friend names to the profile of the user 
		@param nameId: parameter that identifies the name to add to the friend list
	*/
	
	public void addFriend(String nameId) {
		friends.insert(nameId); // inserts a nameId to the LinkedList to set a relation
	}
	/*
		Remove friends from the user profile
		@param nameId: parameter will then classify a friend to remove from the friend list
	*/
	
	public void removeFriend(String nameId) 
	{
		friends.delete(nameId); // removes friendId from any relations with the linkedList
	}
	/*
		classifies a person by name and uses a respective lowercase hashcode with it.
	*/
	public int hashCode() {
		return name.toLowerCase().hashCode();
	}
	/*
		allows the equality and comparison between
		2 profiles based on their hashCodes.

		@param object
		an object that is easily able to be compared to
		@implements Comparable 
	*/
	
	@Override
	public int compareTo(Object o) {
		int x = hashCode();
		int y = o.hashCode();
		if( x > y)
		{
			return 1;	
		}
		else if ( x < y)
		{
			return -1;
		}
		return 0;
	}			
	/*
		Shows a string display
		of the profile of each user.
		
		@return user's name with a return statement of it's properties
	*/
	public String toString() {
		return name.substring(0,1).toUpperCase() + name.substring(1, name.length()).toLowerCase();
	}
}
