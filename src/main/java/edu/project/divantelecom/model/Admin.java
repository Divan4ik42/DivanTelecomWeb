package edu.project.divantelecom.model;

import java.util.Objects;

public class Admin {
    private String id;
    private String name;
    private String lastName;
    private String description;
    private String nick;
    private String password;
    private boolean permission;

    public Admin() {
    }

    public Admin(String name, String lastName, String description, String nick, String password, boolean permission) {
        this.name = name;
        this.lastName = lastName;
        this.description = description;
        this.nick = nick;
        this.password = password;
        this.permission = permission;
    }

    public Admin(String id, String name, String lastName, String description, String nick, String password, boolean permission) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.description = description;
        this.nick = nick;
        this.password = password;
        this.permission = permission;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isPermission() {
        return permission;
    }

    public void setPermission(boolean permission) {
        this.permission = permission;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Admin admin = (Admin) o;
        return getId().equals(admin.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Admin{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", description='" + description + '\'' +
                ", nick='" + nick + '\'' +
                ", password='" + password + '\'' +
                ", permission=" + permission +
                '}';
    }
}
