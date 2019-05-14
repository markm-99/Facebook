package facebook;
//import java.lang.reflect.Array;
/*
	Using HashTable to deal with chaining for collisions.
	@variable arr: internal array of chained linkedlists
*/
public class HashTable
{
	private LinkedListProfile[] arr; // lists an array of linkedlists for chaining
	/*
		initialize a new HashTable
		@variable arr: gives # of slots to begin with
	*/
	HashTable() 
	{
		arr = new LinkedListProfile[15]; // array initialized with it's max slot size 
	}
	/*
		hashTable consists of a key and value pair inserted
		@param key: key to be used
		@param value: value classified with respective key
	*/
	void insert(String key, Person value) 
	{
		int ID = hash(key); // use the key and map to correct slot index
		if (arr[ID] == null) {
			arr[ID] = new LinkedListProfile(); // once initialized, chaining proceeds when the slot is empty
		}
		
		Person x = arr[ID].get(key.toString()); // check to see if value already exists in chain 
		if (x != null)
			x= value; // if it exists, then update the value 
		else
			arr[ID].insert(value); // otherwise insert back to the chain
	}
	/*
		Deletes value related to key
		@param key: key of value to remove
	*/
	
	void delete(String key) {
		int identityx = hash(key); // able to convert key to slot index
		if (arr[identityx] == null) // able to check if slot is empty 
	return;
		Person x = arr[identityx].get(key.toString()); // retrieve value for key
		if (x == null) //ignore value if it does not exist
			return;
		arr[identityx].delete(x); // remove value from slot's chain if the value does exist
	}
	/*
		Looks through HashTable for value corresponding to key.
		@param key: key to search for
		@return a value associated with key if any found
	*/
	
	//allows us to search for a certain name and check if they are the user's friends
	Person search(String key) {
		int identityx = hash(key); // convert key to slot index
		if (arr[identityx] == null) // ensure slot has values
			return null;
		return arr[identityx].get(key.toString()); // get value from slot-chain
	}
	/*
		Hashes a key and maps it to hash slots that are still open
		@param key: provides key to hash
		@return: return the slot index
	*/
	private int hash(String key) {
		int hashCode = Math.abs(key.hashCode()); //the key-string hashCode to be returned. Absolute value to make sure it is non-negative
		
		return (hashCode % 7) % arr.length; // hashCode % 7 with mod to set a slot count and map its indexes.

	}
}
