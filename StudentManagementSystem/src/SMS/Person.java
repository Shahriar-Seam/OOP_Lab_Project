package SMS;

import java.io.Serializable;

public class Person implements Serializable {
    protected String Name;
    protected int Age;
    protected Address address;
    protected DateOfBirth dateOfBirth;

    public Person(String Name, Address address, DateOfBirth dateOfBirth) {
        this.Name = Name;
        this.address = address;
        this.dateOfBirth = dateOfBirth;
        this.Age = dateOfBirth.getAge();
    }

    public String getName() {
        return Name;
    }

    public Address getAddress() {
        return address;
    }

    public DateOfBirth getDateOfBirth() {
        return dateOfBirth;
    }

    public int getAge() {
        return Age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "Name='" + Name + '\'' +
                ", Age=" + Age +
                ", address=" + address +
                ", dateOfBirth=" + dateOfBirth +
                '}';
    }
}
