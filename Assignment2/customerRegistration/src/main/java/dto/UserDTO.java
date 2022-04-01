package dto;

public class UserDTO implements java.io.Serializable,Comparable<UserDTO>
{private int partyId;
    private String firstName;
    private String lastName;
    private String address;
    private String city;
    private int zip;
    private String state;
    private String country;
    private String phone;


    public UserDTO() {
        this.partyId = 0;
        this.firstName = "";
        this.lastName = "";
        this.address = "";
        this.city = "";
        this.zip = 0;
        this.state = "";
        this.country = "";
        this.phone = "";
    }

    public int getPartyId() {
        return partyId;
    }

    public void setPartyId(int partyId) {
        this.partyId = partyId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZip() {
        return zip;
    }

    public void setZip(int zip) {
        this.zip = zip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public boolean equals(Object object) {
        if (!(object instanceof UserDTO)) return false;
        UserDTO userDTO = (UserDTO) object;
        return this.address.equalsIgnoreCase(userDTO.address);
    }

    public int compareTo(UserDTO other) {
        return this.address.compareTo(other.address);
    }

    public int hashCode() {
        return partyId;
    }
}
