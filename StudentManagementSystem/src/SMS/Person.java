package SMS;

import java.io.ObjectOutputStream;
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

    public void setName(String name) {
        Name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public DateOfBirth getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(DateOfBirth dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
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
