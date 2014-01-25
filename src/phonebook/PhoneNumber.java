package phonebook;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import org.junit.Test;

//from effective java, item 9
public final class PhoneNumber implements Comparable<PhoneNumber> {
	private final Short areaCode;
	private final Short prefix;
	private final Short lineNumber;
	
	public PhoneNumber(int areaCode, int prefix, int lineNumber) {
		PhoneNumber.rangeCheck(areaCode, 999, "area code");
		PhoneNumber.rangeCheck(prefix, 999, "prefix");
		PhoneNumber.rangeCheck(lineNumber, 9999, "line number");
		this.areaCode = (short) areaCode;
		this.prefix = (short) prefix;
		this.lineNumber = (short) lineNumber;
	}
	
	private static void rangeCheck(int arg, int max, String name) {
		if(arg < 0 || arg > max){
			throw new IllegalArgumentException(name + ": " + arg);
		}
	}
	
	public short getAreaCode(){
		return areaCode.shortValue();
	}
	
	public short getPrefix(){
		return prefix.shortValue();
	}
	
	public short getLineNumber(){
		return lineNumber.shortValue();
	}
	
	//TODO: GENERIC HASH CODE FUNC USING REFLECTION
	@Override public int hashCode() {
		int result = 17;
		result = 31 * result + areaCode;
		result = 31 * result + prefix;
		result = 31 * result + lineNumber;
		return result;
		
	}
	
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
	
	@Override public String toString() {
		return String.format("(%03d)-%03d-%04d", areaCode, prefix, lineNumber);
	}

	/**
	 * compareTo method which takes advantage of result sign, instead of forcing -1/0/1
	 * Assumes precedence of areaCode > prefix > lineNumber 
	 */
	@Override
	public int compareTo(PhoneNumber number) {
		int areaCodeDiff = areaCode - number.getAreaCode();
		if(areaCodeDiff != 0) {
			return areaCodeDiff;
		}
		
		int prefixDiff = prefix - number.getPrefix();
		if(prefixDiff != 0) {
			return prefixDiff;
		}
		
		return lineNumber - number.lineNumber;
	}

}
