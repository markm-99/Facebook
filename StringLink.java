package facebook;

public class StringLink {
	 StringLink prev; // references to previous link
     StringLink next; // references to next link
	 String name; // user's name

     StringLink(String name)
     {
    	 this.name = name; 	 
     }
}
