package phonebook;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

/**
 * Unit tests for phonebook.Name.
 * @author jherwitz
 */
public class NameTests {

	@Test
	public void testNameConstruction(){
		Name name = new Name("Julian", "Herwitz");
		assertTrue(name != null);
	}
	
	@Test
	public void testNameFirstNameAccessor(){
		Name name = new Name("Julian", "Herwitz");
		String fn = name.toString();
		assertEquals(fn, "\"Herwitz, Julian\"");
	}
	
	@Test
	public void testHashCodeLegality(){
		Name name1 = new Name("Julian", "Herwitz");
		Name name2 = new Name("Julian", "Herwitz");
		assertTrue(name1.hashCode() == name2.hashCode());
	}
	
	@Test
	public void testHashCodeSparseness(){
		Name name1 = new Name("Julian", "Herwitz");
		Name name2 = new Name("Iulian", "Herwitz");
		assertFalse(name1.hashCode() == name2.hashCode());
	}
	
	@Test
	public void testEqualsToDifferentObject(){
		Name name1 = new Name("Julian", "Herwitz");
		assertFalse(name1.equals(new Object()));
	}
	
	@Test
	public void testEquals(){
		Name name1 = new Name("Julian", "Herwitz");
		Name name2 = new Name("Julian", "Herwitz");
		assertTrue(name1.equals(name2));
	}
	
	@Test
	public void testNotEquals(){
		Name name1 = new Name("Julian", "Herwitz");
		Name name2 = new Name("Iulian", "Herwitz");
		assertFalse(name1.equals(name2));
	}
	
	@Test (expected = IllegalArgumentException.class)
	public void testNameComparisonWithNull(){
		Name name = new Name("The", "Dude");
		name.compareTo(null);
	}
	
	@Test
	public void testNameComparisonBySortingArrayOfNames(){
		Name name1 = new Name("Julian", "Herwitz");
		Name name2 = new Name("Bob", "Smith");
		Name name3 = new Name("Bob", "Smith");
		Name name4 = new Name("Bill", "Smith");
		//veryify sorted correctly w/ arrays.sort
		Name[] names = {name1, name2, name3, name4};
		Name[] correctNamesOrdering = {name1, name4, name3, name3};
		Arrays.sort(names);
		for(int i=0; i<names.length; i++){
			names[i].equals(correctNamesOrdering[i]);
		}
	}
	
}
