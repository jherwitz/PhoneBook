package phonebook;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit tests for phonebook.PhoneNumber.
 * @author jherwitz
 */
public class PhoneNumberTests {

	//TODO: generate random phone numbers for these tests
	
	@Test
	public void testHashCodeLegality(){
		PhoneNumber number1 = new PhoneNumber(999,999,9999);
		PhoneNumber number2 = new PhoneNumber(999,999,9999);
		assertTrue(number1.hashCode() == number2.hashCode());
	}
	
	@Test
	public void testHashCodeSparseness(){
		PhoneNumber number1 = new PhoneNumber(999,999,9998);
		PhoneNumber number2 = new PhoneNumber(999,999,9999);
		assertFalse(number1.hashCode() == number2.hashCode());
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testOutOfRangeNumberException(){
		PhoneNumber number = new PhoneNumber(110,1101,1100);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testOutOfRangeNumberExceptionAgain(){
		PhoneNumber number = new PhoneNumber(110,-10,1100);
	}
	
	@Test
	public void testGenericHashCode(){
		PhoneNumber number1 = new PhoneNumber(101,202,3303);
		assertTrue(number1.hashCode() == number1.genericHashCode());
	}
	
	@Test
	public void testGenericHashCodeAgain(){
		PhoneNumber number1 = new PhoneNumber(000,000,0000);
		assertTrue(number1.hashCode() == number1.genericHashCode());
	}
	
	@Test 
	public void testPhoneNumberComparisonLineNumber(){
		PhoneNumber number1 = new PhoneNumber(999,999,9998);
		PhoneNumber number2 = new PhoneNumber(999,999,9999);
		assertTrue(number1.compareTo(number2) < 0);
	}

	@Test
	public void testPhoneNumberComparisonAreaCode(){
		PhoneNumber number1 = new PhoneNumber(998,999,9998);
		PhoneNumber number2 = new PhoneNumber(999,999,9999);
		assertTrue(number1.compareTo(number2) < 0);
	}
	
	@Test
	public void testPhoneNumberComparisonPrefix(){
		PhoneNumber number1 = new PhoneNumber(999,998,9998);
		PhoneNumber number2 = new PhoneNumber(999,999,9999);
		assertTrue(number1.compareTo(number2) < 0);
	}
	
	@Test
	public void testToStringNotBroken(){
		PhoneNumber number1 = new PhoneNumber(000,000,0000);
		String str = number1.toString();
		assertTrue(str != null && str != "");
	}
	
	@Test
	public void testPhoneNumberNotEqualToDifferentObject(){
		PhoneNumber number = new PhoneNumber(101,110,1101);
		assertFalse(number.equals(new Object()));
	}
	
	@Test
	public void testPhoneNumberEquals(){
		PhoneNumber number1 = new PhoneNumber(999,999,9999);
		PhoneNumber number2 = new PhoneNumber(999,999,9999);
		assertTrue(number1.equals(number2));
	}
	
	@Test
	public void testPhoneNumberNotEquals(){
		PhoneNumber number1 = new PhoneNumber(998,999,9999);
		PhoneNumber number2 = new PhoneNumber(999,999,9999);
		assertFalse(number1.equals(number2));
	}
	
	@Test
	public void testPhoneNumberEqualsNull(){
		PhoneNumber number1 = new PhoneNumber(998,999,9999);
		assertFalse(number1.equals(null));
	}
	
	@Test
	public void testPhoneNumberEqualsReflexivity(){
		PhoneNumber number1 = new PhoneNumber(998,999,9999);
		assertTrue(number1.equals(number1));
	}
	
	@Test
	public void testPhoneNumberEqualsSymmetry(){
		PhoneNumber number1 = new PhoneNumber(998,999,9999);
		PhoneNumber number2 = new PhoneNumber(999,999,9999);
		assertFalse(number1.equals(number2) && number2.equals(number1));
	}
		
	@Test
	public void testPhoneNumberEqualsTransitivity(){
		PhoneNumber number1 = new PhoneNumber(999,999,9999);
		PhoneNumber number2 = new PhoneNumber(999,999,9999);
		PhoneNumber number3 = new PhoneNumber(999,999,9999);
		assertTrue(number1.equals(number2) && number2.equals(number3) && number1.equals(number3));
	}
	
	@Test
	public void testPhoneNumberEqualsConsistency() throws InterruptedException{
		PhoneNumber number1 = new PhoneNumber(998,999,9999);
		PhoneNumber number2 = new PhoneNumber(999,999,9999);
		boolean try1 = number1.equals(number2);
		Thread.sleep(1000);
		boolean try2 = number1.equals(number2);
		assertTrue(try1==try2);
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testPhoneNumberComparisonWithNull(){
		PhoneNumber number1 = new PhoneNumber(101,111,1101);
		number1.compareTo(null);
	}
}
