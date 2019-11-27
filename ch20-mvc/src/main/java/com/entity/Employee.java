package com.entity;

import javax.validation.constraints.*;
import java.util.Date;

public class Employee {
    private Integer id;
    @Size(min = 2,max = 10,message = "添加错误！")
    private String username;
    @Pattern(regexp = "^1(3|4|5|7|8)\\d{9}$",message = "手机号码格式错误")
    @NotBlank(message = "号码不能为空")
    private String phone;
    @Email(message = "邮箱格式错误")
    private String email;
    @Past(message = "生日日期错误！")
    private Date birthday;
    @DecimalMax(value = "1",message = "状态值错误")
    @NotNull(message = "状态不能为空")
    private Integer hidden;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", hidden=" + hidden +
                '}';
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
        this.username = username;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getHidden() {
        return hidden;
    }

    public void setHidden(Integer hidden) {
        this.hidden = hidden;
    }
}
