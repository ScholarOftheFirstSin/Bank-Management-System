/*
 * Athanasios Filippidis
 * aflpd@bu.edu
 * BU ID U95061883
 * */
package bank;

public class Person {

    private Name name;

    public Person(String firstName, String lastName) {
        this.name = new Name(firstName, lastName);
    }


    @Override
    public String toString() {
        return name.toString();
    }

	public Name getName() {
		return name;
	}

}
