package pers.lcy.graduationdesign.model;

public class User {
    private Integer id;

    private String username;

    private String password;

    private String salt;

    private Integer role;

    public User(Integer id, String username, String password, String salt, Integer role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.salt = salt;
        this.role = role;
    }

    public User() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public Integer getRole() {
        return role;
    }

    public void setRole(Integer role) {
        this.role = role;
    }
}