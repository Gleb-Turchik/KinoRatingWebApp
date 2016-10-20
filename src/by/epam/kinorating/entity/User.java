package by.epam.kinorating.entity;

/**
 * Created by Диана и Глеб on 06.08.2016.
 */
public class User {
    private long userId;
    private String name;
    private String surname;
    private String email;
    private String password;
    private boolean ban;
    private Role role;

    public User() {}

    public boolean isBaned() {
        return ban;
    }

    public void setBan(boolean ban) {
        this.ban = ban;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override //TODO подправить или убрать
    public String toString() {
        return "userId - " + userId +
                " FirstName - " + name +
                " LastName - " + surname +
                " email - " + email +
                " password - " + password +
                " Доступ - " + role.getRole() +
                " Access ID - " + role.getRoleId();
    }
}
