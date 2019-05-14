package facebook;
//hash function: assigns an index to specific keys that are best fit and capable of retrieving elements
//arr: determines an array's size 
//when more values than index slots, collisions happen

import java.util.Scanner;
/*
	Parses input for the command line and will provide a router to each HashTable function
	@variable input: uses a scanner input
	@variable profiles: HashTable capable of storing profiles for each user
	@variable ownerName: stores main account user name
*/
public class FacebookScanner 
{
	//use scanner class to input and prompt user with respective output
	Scanner input = new Scanner(System.in); // scanner input that utilizes the Scanner class
	private HashTable profiles; // hashTable of the username capable of displaying a profile of objects
	private String ownerName = "mark"; // main username of the internal account
	
	public static void main(String[] args) 
	{
		new FacebookScanner(); // provides new instance of class called FacebookScanner
	}
	
	//constructor
	FacebookScanner() 
	{
		profiles = new HashTable(); // initializes a hashTable that consists of 100 corresponding slots
		initializeProfiles(); // initialize given profiles
		help(); // menu for help text now printed
		while (true)
		{ 
			// console input listened
			String line = input.nextLine(); // retrieve console input
			router(line); // router is capable of listing console input itself
		}
	}	
	void initializeProfiles() 
	{
		System.out.println("Names of each profile and friends have been initialized:" );
	String [] ProfileNames=  { ownerName, "Liam", "Emma", "Noah", "Olivia", "William", "Ava", "James", "Isabella", "Logan", "Sophia", "Benjamin", "Mia", "Mason", "Charlotte", "Elijah", "Amelia", "Oliver", "Evelyn", "Jacob","Abigail", "Lucas", "Harper", "Michael", "Emily", "Alexander", "Elizabeth", "Ethan", "Avery", "Daniel", "Sofia", "Matthew", "Ella", "Aiden", "Madison", "Henry", "Scarlett", "Joseph", "Victoria", "Jackson", "Aria", "Samuel", "Grace", "Sebastian", "Chloe", "David", "Camila", "Carter", "Penelope","Wyatt", "Riley"};
	//for loop to iterate through the list of arrays
	for (int i =0; i < ProfileNames.length; i++)
	{
		profiles.insert(ProfileNames[i].toLowerCase(), new Person(ProfileNames[i].toLowerCase())); // name of profiles
	}
	
	for(int i =0; i<ProfileNames.length; i++)
	{
		Person profile = profiles.search(ProfileNames[i].toLowerCase());
		profile.addFriend(ProfileNames[(i + 1) % ProfileNames.length].toLowerCase()); // function to add a friend
	//print statement showing relationship of friends to user
		System.out.println(profile.name + " is friends with " + ProfileNames[(i + 1) % ProfileNames.length].toLowerCase());	
	}
	
}
	/*
		Help command menu printed to guide the user (helper text)
	*/
	void help() {
		String textHelper = 
		"\n You are logged in to the account name:\n"+
		"\t\t mark \n" +
		
		"Welcome to Micro-Facebook! Provided below are a list of commands you can use:\n"+
		"\tcreate name\n"+
		"\t\t- creates a brand new profile with the name provided \n"+
		"\t\t- ex. create mark\n"+
		"\tadd friendName\n"+
		"\t\t- will add a new friend to the current account\n"+
		"\t\t- ex. add mark\n"+
		"\tremove friendName\n"+
		"\t\t- will remove a friend from the current account\'s friends\n"+
		"\t\t- ex. remove mark\n"+
		"\tsearch name\n"+
		"\t\t- searches profiles with name \"name\" and finds a way to return that name to its friends list.\n"+
		"\t\t- ex. search mark\n"+
		"\tlist\n"+
		"\t\t- lists friends of the current account\n"+
		"\t\t- ex. list\n"+
		"\tisfriend friendName\n"+
		"\t\t- displays whether current account considers \"friendName\" a friend.\n"+
		"\t\t- ex. isfriend mark\n"+
		"\tfriends accountName,friendName\n"+
		"\t\t- finds out whether a profile is friends with another.\n"+
		"\t\t- ex. friends mark,bob\n";
		System.out.println(textHelper);
	}
	/*
		Takes data and parses in order to route every respective method.
		@param input: every input will contain a data input
	*/
	
	//uses router in order to generate appropriate commands listed
	void router(String input) {
		try {
			String data = input.toLowerCase().trim(); // trims data and converts it to lowerCase
			if (data.indexOf("create") == 0) { // when command is created
				String[] parts = data.split("create"); // retrieve viable possible options that are split in the data
				if (parts.length > 1) { // checks to see if the string part lengths are greater than 1, if so, trims value 
					String friendName = parts[1].trim(); // trim data to appropriate part
					createProfile(friendName); // create profile for name
				} 
				else 
				{
					throw new Error("Wrong format. Not a valid option.\n"); // wrong format for possible options
				}
			} 
			else if (data.indexOf("add") == 0) { // if the command is add
				String[] parts = data.split("add"); // get possible options and adds parts
				if (parts.length > 1) { // check parts of each string
					String friendName = parts[1].trim(); // trim the output
					addFriend(ownerName, friendName); // addFriend
				} 
				else 
				{
					throw new Error("Sorry! Not a valid option.\n"); // possible options provided in wrong format
				}
			} else if (data.indexOf("remove") == 0) { // if command is to be removed, then use indexOf to trim it accordingly
				String[] parts = data.split("remove"); // get possible options
				if (parts.length > 1) { // check part lengths
					String friendName = parts[1].trim(); // parse possible options
					removeFriend(ownerName, friendName); // removeFriend
				} else {
					throw new Error("Sorry! Not a valid option.\n"); // possible options in wrong format
				}
				
			} 
			else if (data.indexOf("search") == 0) 
			{ // if command is search
				String[] parts = data.split("search"); // get possible options
				if (parts.length > 1) 
				{ // check parts of the string
					String friendName = parts[1].trim(); // trim possible options from the string 
					listFriends(friendName); //lists the given friends in friends list
				} 
				else
				{
					throw new Error("Sorry! Not a valid option.\n");
				}
			} else if (data.indexOf("list") == 0) { // if command is listed
				listFriends(ownerName); // able to listFriends
			} else if (data.indexOf("isfriend") == 0) { // when command isFriend
				String[] parts = data.split("isfriend"); // retrieve possible possible options
				if (parts.length > 1) { // check part lengths
					String friendName = parts[1].trim(); // trim possible options
					friendsWith(ownerName, friendName); // determine if friendsWith
				} 
				else 
				{
					throw new Error("Sorry! Not a valid option.\n"); // possible options are in the wrong format
				}
			} 
			else if (data.indexOf("friends") == 0) 
			{ // if command is friends
				String[] parts = data.split("friends"); // get possible options
				if (parts.length > 1) 
				{ // check parts
					String options = parts[1].trim(); // trim parts of the string
					String[] names = options.split(","); // get sub-parts of the string

					if (names.length > 1) 
					{ // check sub-parts 
						friendsWith(names[0].trim(), names[1].trim()); // determine if friendsWith a specific name
					} else {
						throw new Error("Sorry! possible options need to be listed in appropriate format: ownerName,friendName.\n"); // possible options with incorrect format
					}
				} else {
					throw new Error("Sorry! No possible options provided.\n"); // possible options with incorrect format
				}
			} else if (data.indexOf("help") == 0) 
			{ // if command is for help
				help(); //menu for help
			} else {
				throw new Error("Sorry! Invalid option. Type the keyword `help` and press enter to generate a complete list of possible options.\n"); // command with incorrect format
			}
		} catch(Error err)
		{
		
		//catch common errors and print a statement for the user to see these errors
			
			System.out.println("Error: " + err.getMessage()+ "\n"); // print out the found errors
		}
	}

	/*
		Make a new profile
		@param name: parameter of name used to generate a new profile
	*/
	void createProfile(String name) {
		profiles.insert(name, new Person(name)); // insert into the hashtable
		System.out.println("Profile Created.\n"); // able to log profile creation
	}
	
	/*
		Adds friend to specified profile
		@param profileName: profileName of user to add friend to
		@param friendName: friendName of friend to add
		@throws an error
	*/
	void addFriend(String profileName, String friendName) throws Error 
	{
		Person profile = profiles.search(profileName); // retrieve the profile
		if (profile == null)
			throw new Error("Sorry! Profile doesn\'t exist.\n"); // if profile doesn't exist, throw
		Person friend = profiles.search(friendName); // get profile and search for the appropriate friend name
		if (friend == null)
			throw new Error("Sorry! Friend\'s profile doesn\'t exist.\n"); // when checking, if profile doesn't exist, throw an exception
		profile.addFriend(friend.name); //start by adding friend to profile
		System.out.println("Friend Added.\n"); // log the respective friend added
	}
	
	/*
		Removes a friend from profile.
		@param profileName: gives the profile in order to remove specific friend
		@param friendName: gives the profile of a friend to remove
		@throws the appropriate Error
	*/
	void removeFriend(String profileName, String friendName) throws Error {
		Person profile = profiles.search(profileName); // get profile
		if (profile == null)
			throw new Error("Sorry! Profile doesn\'t exist.\n"); // if profile doesn't exist, throw
		Person friend = profiles.search(friendName); // get profile
		if (friend == null)
			throw new Error("Sorry! Friend\'s profile doesn\'t exist.\n"); // if profile doesn't exist, throw
		profile.removeFriend(friend.name); // remove friend to profile
		System.out.println("Friend Removed.\n"); // log friend removed
	}
	
	/*
		List friends associated with a profile
		@param profileName
			- profile to list friends of
		@throws Error
	*/
	void listFriends(String profileName) throws Error {
		Person profile = profiles.search(profileName); // get profile
		if (profile == null)
			throw new Error("Sorry! Profile doesn\'t exist.\n"); // if profile doesn't exist, throw
		LinkedListString friends = profile.friends; // get profile friends
		System.out.println(friends+"\n"); // print the friends associated
		System.out.println("Friends:"); // print the list friends
	}
	
	/*
		Decides if 2 profiles are friends
		@param nameProfile: people who are friends on the list 
		@param friendNames: friend to find on profile's friends list
	*/
	void friendsWith(String nameProfile, String friendNames) throws Error {
		Person profile = profiles.search(nameProfile); // get profile
		if (profile == null)
			throw new Error("Sorry! Profile doesn\'t exist.\n"); // when profile does not exist, throw an exception
		String match = profile.friends.search(friendNames); // search friends for friend profile and its respective attributes
		
		//Using ternary operators to make it less spaced out and more efficient
		//? return this value  if condition is true */ 
	    //: return this value if condition is false */
		System.out.println("("+(match == null ? "No" : "Yes")+") "+ nameProfile +(match == null ? "is NOT friends with" : " is friends with ")+friendNames+"\n"); //result the gives user output
	}
}
