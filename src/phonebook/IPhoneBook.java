package phonebook;

import java.util.Map;

//design questions: can one phone number have multiple names?
//		  can one name have multiple phone numbers?

/**
 * Stub interface for PhoneBook operations. SUBJECT TO CHANGE. <br>
 * This is in the early stages of design, these are just some possible interesting ops.  
 * @author jherwitz
 */
public interface IPhoneBook {
	public PhoneNumber lookupPhoneNumberByName(Name name);
	public Name lookupNameByPhoneNumber(PhoneNumber number);
	public long getNumberOfEntries();
	public long getNumberOfEntriesForAreaCode(short areaCode);
	public void addEntry(PhoneNumber number, Name name);
	public void addEntries(Map<PhoneNumber, Name> entries);
	public void removeEntryByPhoneNumber(PhoneNumber n);
	public void removeEntryByName(Name n);
}
