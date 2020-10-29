package edu.project.divantelecom.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.util.Objects;

public class Subscriber {
    private String id;
    private String name;
    private String lastName;
    private LocalDate dateOfBirth;
    private int operatorCode;
    private int userNumber;
    private String paymentMethod;
    private String description;
    private LocalDateTime created_at;
    private LocalDateTime lastLogin_at;

    public Subscriber(LocalDate of) {
        age = Period.between(dateOfBirth , LocalDate.from(lastLogin_at)).getYears();
    }

    public Subscriber(LocalDate dateOfBirth, LocalDateTime lastLogin_at) {
        this.dateOfBirth = dateOfBirth;
        this.lastLogin_at = lastLogin_at;
        age = Period.between(dateOfBirth , LocalDate.from(lastLogin_at)).getYears();
    }

    public Subscriber(String name, String lastName, int operatorCode, int userNumber, String paymentMethod, String description) {
        this.name = name;
        this.lastName = lastName;
        this.operatorCode = operatorCode;
        this.userNumber = userNumber;
        this.paymentMethod = paymentMethod;
        this.description = description;
        age = Period.between(dateOfBirth , LocalDate.from(lastLogin_at)).getYears();
    }

    public Subscriber(String id, String name, String lastName, LocalDate dateOfBirth, int operatorCode, int userNumber, String paymentMethod, String description, LocalDateTime created_at, LocalDateTime lastLogin_at) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.operatorCode = operatorCode;
        this.userNumber = userNumber;
        this.paymentMethod = paymentMethod;
        this.description = description;
        this.created_at = created_at;
        this.lastLogin_at = lastLogin_at;
        age = Period.between(dateOfBirth , LocalDate.from(lastLogin_at)).getYears();
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public int getOperatorCode() {
        return operatorCode;
    }

    public void setOperatorCode(int operatorCode) {
        this.operatorCode = operatorCode;
    }

    public int getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(int userNumber) {
        this.userNumber = userNumber;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getLastLogin_at() {
        return lastLogin_at;
    }

    public void setLastLogin_at(LocalDateTime lastLogin_at) {
        this.lastLogin_at = lastLogin_at;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscriber that = (Subscriber) o;
        return getId().equals(that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    int age;

    @Override
    public String toString() {
        return "Subscriber{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + age +
                ", operatorCode=" + operatorCode +
                ", userNumber=" + userNumber +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", description='" + description + '\'' +
                ", created_at=" + created_at +
                ", lastLogin_at=" + lastLogin_at +
                '}';
    }

    public static void main(String[] args) {
        Subscriber s1 = new Subscriber(LocalDate.of(1986,06,19),LocalDateTime.now());
        System.out.println(s1);
    }
}

