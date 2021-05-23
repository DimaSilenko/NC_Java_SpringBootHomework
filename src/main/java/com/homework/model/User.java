package com.homework.model;

import javax.validation.constraints.*;

public class User {

    @Pattern(regexp = "[a-zA-Z]{1,30}")
    @NotBlank
    private String firstName;

    @Pattern(regexp = "[a-zA-Z]{1,30}")
    @NotBlank
    private String lastName;

    @Pattern(regexp = "[a-zA-Z]{1,30}")
    @NotBlank
    private String patronymic; //отчество

    @Min(18)
    @Max(100)
    private int age;

    //Что-то вроде МРОТ
    @Min(12800)
    private double salary;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    @Pattern(regexp = "[a-zA-Z]{1,30}")
    private String company;

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

    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return firstName + "|" + lastName + "|" + patronymic + "|" + age + "|" + salary + "|" + email + "|" + company;
    }

    public void setParams(String[] buffer) {
        this.setFirstName(buffer[0]);
        this.setLastName(buffer[1]);
        this.setPatronymic(buffer[2]);
        this.setAge(Integer.parseInt(buffer[3]));
        this.setSalary(Double.parseDouble(buffer[4]));
        this.setEmail(buffer[5]);
        this.setCompany(buffer[6]);
    }
}
