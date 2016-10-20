package by.epam.kinorating.entity;

/**
 * Created by Диана и Глеб on 15.08.2016.
 */
public class Role {
    private long roleId;
    private String role;

    public long getRoleId() {
        return roleId;
    }

    public void setRoleId(long roleId) {
        this.roleId = roleId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "Role - " + role +  //TODO убрать или поправить
                " Role ID - " + roleId;
    }
}
