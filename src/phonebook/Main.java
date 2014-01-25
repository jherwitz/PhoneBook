package phonebook;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		PhoneNumber number1 = new PhoneNumber(301,367,9822);
		PhoneNumber number2 = new PhoneNumber(301,367,9821);
		number1.genericHashCode();
		System.out.println(number1 + ": " + number1.hashCode());
		System.out.println(number1 + ": " + number1.genericHashCode());
		System.out.println(number2 + ": " + number2.hashCode());
		System.out.println(number2 + ": " + number2.genericHashCode());
	}

}
