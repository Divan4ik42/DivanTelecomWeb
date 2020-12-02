package edu.project.divantelecom.forms;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class SubscriberForm {
    private String id = "";
    private String name= "";
    private String lastName= "";
    private String dateOfBirth= "";
    private String operatorCode= "";
    private String userNumber= "";
    private int balance = 0;
    private String description= "";
    private String created_at= "";
    private String lastLogin_at= "";

    public SubscriberForm() {
    }

    public SubscriberForm(String name, String lastName, String dateOfBirth, String operatorCode, String userNumber, int balance, String description) {
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.operatorCode = operatorCode;
        this.userNumber = userNumber;
        this.balance = balance;
        this.description = description;
    }

    public SubscriberForm(String id, String name, String lastName, String dateOfBirth, String operatorCode, String userNumber, int balance, String description) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.operatorCode = operatorCode;
        this.userNumber = userNumber;
        this.balance = balance;
        this.description = description;
    }

    public SubscriberForm(String id, String name, String lastName, String dateOfBirth, String operatorCode, String userNumber, int balance, String description, String created_at, String lastLogin_at) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.operatorCode = operatorCode;
        this.userNumber = userNumber;
        this.balance = balance;
        this.description = description;
        this.created_at = created_at;
        this.lastLogin_at = lastLogin_at;
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

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(String operatorCode) {
        this.operatorCode = operatorCode;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getLastLogin_at() {
        return lastLogin_at;
    }

    public void setLastLogin_at(String lastLogin_at) {
        this.lastLogin_at = lastLogin_at;
    }

    @Override
    public String toString() {
        return "SubscriberForm{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", operatorCode='" + operatorCode + '\'' +
                ", userNumber='" + userNumber + '\'' +
                ", balance='" + balance + '\'' +
                ", description='" + description + '\'' +
                ", created_at='" + created_at + '\'' +
                ", lastLogin_at='" + lastLogin_at + '\'' +
                '}';
    }
}
