package dto;
public class UserLoginDTO implements java.io.Serializable,Comparable<UserLoginDTO>
{
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean equals(Object object) {
        if (!(object instanceof UserLoginDTO)) return false;
        UserLoginDTO userLoginDTO = (UserLoginDTO) object;
        return this.username.equalsIgnoreCase(username);
    }

    public int compareTo(UserLoginDTO other) {
        return this.username.compareTo(other.username);
    }

    public int hashCode() {
        return username.hashCode();
    }
}
