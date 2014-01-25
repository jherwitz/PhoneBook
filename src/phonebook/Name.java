package phonebook;

/**
 * Class which represents a full name of something.
 * Currently only supports first and last names.
 * Will eventually add support for titles, suffixes, and middle initials. <br>
 * As per Effective Java item 13, these parts have been abstracted away. 
 * This way they can be added at a later date without changing this class's public API. 
 * @author jherwitz
 */
public class Name implements Comparable<Name>{
	//TODO: mr. mrs. etc
	private final String firstName;
	//TODO: optional middle initial
	private final String lastName;
	//TODO: suffix
	
	/**
	 * Instantiates a name object.
	 * @param firstName A first name.
	 * @param lastName A last name.
	 */
	public Name(String firstName, String lastName){
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	/**
	 * Returns the name in String form.
	 * Adheres to the format "\"{LASTNAME}, {FIRSTNAME}"\".
	 */
	@Override
	public String toString(){
		return String.format("\"%s, %s\"", lastName, firstName);
	}
	
	/**
	 * Checks if this Name object is equal to paramter object.
	 * Two Names are equal if all name fields are equivalent in value. 
	 * @param o Object to check for equivalence.
	 */
	@Override
	public boolean equals(Object o){
		if(!(o instanceof Name)){
			return false;
		}
		Name n = (Name) o;
		return 
			firstName == n.firstName
			&& lastName == n.lastName;
	}
	
	@Override
	public int hashCode(){
		int result = 17;
		result = 31 * result + firstName.hashCode();
		result = 31 * result + lastName.hashCode();
		return result;
	}

	/**
	 * Comparable method for Name objects. <br>
	 * Compares by alphabetical order of last name, then first name (in case of a tie). <br/>  
	 */
	//XXX: This will likely break for different capitlizations throughout the string. (e.g., "MacBeth" or "othello").
	//TODO: make a CaseInsensitiveString class for this case
	@Override
	public int compareTo(Name name) {
		if(name == null){
			throw new IllegalArgumentException("null parameter passed to compareTo");
		}
		
		if(this.equals(name)){
			return 0;
		}
		else if(this.lastName.equals(name.lastName)){
			return firstName.compareTo(name.firstName);
		}
		else{
			return lastName.compareTo(name.lastName);
		}
	}
	
}
