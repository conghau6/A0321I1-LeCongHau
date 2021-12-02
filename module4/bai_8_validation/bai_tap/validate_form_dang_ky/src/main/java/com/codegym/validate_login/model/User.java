package com.codegym.validate_login.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;

public class User {
    private String name;
    private String phone;

    @Email(message = "Nhập chưa đúng định dạng email")
    private String email;

    @Min(value = 18, message = "Nhập lớn hơn 18 tuổi")
    private int age;

    public User() {
    }

    public User(String name, String phone, @Email String email, @Min(18) int age) {
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
