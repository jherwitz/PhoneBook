package phonebook;

//can one phone number have multiple names?
public interface IPhoneBook {
	public PhoneNumber lookupPhoneNumberByName(Name name);
	public Name lookupNameByPhoneNumber(PhoneNumber number);
	public long getNumberOfEntries();
	public long getNumberOfEntriesForAreaCode(short AreaCode);
	public void addEntry(PhoneNumber n, Name m);
	public void addEntries(PhoneNumber[] ns, Name[] ms);
	public void removeEntryByPhoneNumber(PhoneNumber n);
	public void removeEntryByName(Name n);
}
