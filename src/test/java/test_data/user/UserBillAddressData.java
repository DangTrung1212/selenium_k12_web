package test_data.user;

public class UserBillAddressData {
    private String firstname;
    private String lastname;
    private String email;
    private String country;
    private String state;
    private String city;
    private String add1;


    private String zipcode;
    private String phoneNum;

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getCountry() {
        return country;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getAdd1() {
        return add1;
    }

    @Override
    public String toString() {
        return "UserBillAddressData{" +
                "firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", city='" + city + '\'' +
                ", add1='" + add1 + '\'' +
                ", zipcode='" + zipcode + '\'' +
                ", phoneNum='" + phoneNum + '\'' +
                '}';
    }
}
