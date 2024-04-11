package SMS;

import java.io.Serializable;

public class Address implements Serializable {
    private String Street;
    private String PostOffice;
    private String District;

    public Address(String street, String postOffice, String district) {
        this.Street = street;
        this.PostOffice = postOffice;
        this.District = district;
    }

    public Address(String address) {
        String[] str = address.split(", ");
        this.Street = str[0];
        this.PostOffice = str[1];
        this.District = str[2];
    }

    public String getStreet() {
        return Street;
    }

    public void setStreet(String street) {
        Street = street;
    }

    public String getPostOffice() {
        return PostOffice;
    }

    public void setPostOffice(String postOffice) {
        PostOffice = postOffice;
    }

    public String getDistrict() {
        return District;
    }

    public void setDistrict(String district) {
        District = district;
    }

    public String toString() {
        return Street + ", " + PostOffice + ", " + District;
    }
}
