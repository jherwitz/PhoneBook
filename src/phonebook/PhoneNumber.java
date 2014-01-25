package phonebook;

import java.lang.reflect.Field;

/**
 * Class representing a phone number.
 * Structure mainly taken from Effective Java.
 * @author jherwitz
 */
public final class PhoneNumber implements Comparable<PhoneNumber> {
	private final Short areaCode;
	private final Short prefix;
	private final Short lineNumber;
	
	/**
	 * Constructs a PhoneNumber object.
	 * @param areaCode The first three digits of the phone number.
	 * @param prefix Unintuitively, the middle three digits of the phone number. 
	 * @param lineNumber The last four digits of the phone number.
	 */
	public PhoneNumber(int areaCode, int prefix, int lineNumber) {
		PhoneNumber.rangeCheck(areaCode, 999, "area code");
		PhoneNumber.rangeCheck(prefix, 999, "prefix");
		PhoneNumber.rangeCheck(lineNumber, 9999, "line number");
		this.areaCode = (short) areaCode;
		this.prefix = (short) prefix;
		this.lineNumber = (short) lineNumber;
	}
	
	/**
	 * Method which validates whether a given integer n satisfies the expression: 0 <= n <= max.
	 * Shamelessly taken from Effective Java. 
	 * @param arg int to validate
	 * @param max maximum value for arg
	 * @param name name of value for exception messaging. 
	 */
	private static void rangeCheck(int arg, int max, String name) {
		if(arg < 0 || arg > max){
			throw new IllegalArgumentException(name + ": " + arg);
		}
	}
	
	/**
	 * Returns the hashcode of this object. 
	 */
	@Override public int hashCode() {
		int result = 17;
		result = 31 * result + areaCode;
		result = 31 * result + prefix;
		result = 31 * result + lineNumber;
		return result;
		
	}
	
	/**
	 * Method that generically generates this object's hashcode using reflection. Should be equivalent to hashCode().
	 * Could probably be generalized to other objects, but it requires private field access. 
	 */
	public int genericHashCode(){
		int result = 17;
		Field[] fields = this.getClass().getDeclaredFields();
		for(Field field : fields){
			if(field.getType().isPrimitive()){ 
				//todo
			}
			else{
				try {
					result = 31 * result + field.get(this).hashCode();
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	
	/**
	 * Returns the phone number in string form. This takes the form of "(XYX)-XYX-XXYX".
	 */
	@Override 
	public String toString() {
		return String.format("(%03d)-%03d-%04d", areaCode, prefix, lineNumber);
	}

	/**
	 * Comparable method for two PhoneNumbers. Assumes precedence of areaCode > prefix > lineNumber. 
	 * Modified from method in Effective Java.
	 */
	@Override
	public int compareTo(PhoneNumber number) {
		if(number == null){
			throw new IllegalArgumentException("null paramter passed to compareTo");
		}
		
		int areaCodeDiff = areaCode - number.areaCode;
		if(areaCodeDiff != 0) {
			return areaCodeDiff;
		}
		
		int prefixDiff = prefix - number.prefix;
		if(prefixDiff != 0) {
			return prefixDiff;
		}
		
		return lineNumber - number.lineNumber;
	}

	/**
	 * Method which tests equality between two PhoneNumber objects. 
	 * It adheres to the general contract for equals: 
	 * <ul>
	 * <li> Reflexivity: x.equals(x) <-> true </li>
	 * <li> Symmetry: x.equals(x) <-> y.equals(x) </li>
	 * <li> Transitivity: x.equals(y) ^ y.equals(z) -> x.equals(z) </li>
	 * <li> Consistency: x(t).equals(y(t)) <-> x(t+1).equals(y(t+t)) 
	 * 			if x(t)=x(t+1) ^ y(t)=y(t+1)  </li>
	 * </ul> 
	 * These properties have been unit tested in tst/phonebook.PhoneNumberTests
	 */
	@Override
	public boolean equals(Object o){
		if(!(o instanceof PhoneNumber)){
			return false;
		}
		PhoneNumber pn = (PhoneNumber) o;
		return 
			areaCode.equals(pn.areaCode)
			&& prefix.equals(pn.prefix)
			&& lineNumber.equals(pn.lineNumber);
	}
	
}
