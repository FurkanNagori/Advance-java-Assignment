package bean;

public class UserLoginBean implements java.io.Serializable, Comparable<UserLoginBean> {
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
        if (!(object instanceof UserLoginBean)) return false;
        UserLoginBean userLoginBean = (UserLoginBean) object;
        return this.username.equalsIgnoreCase(username);
    }

    public int compareTo(UserLoginBean other) {
        return this.username.compareTo(other.username);
    }

    public int hashCode() {
        return username.hashCode();
    }
}



