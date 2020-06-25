package com.coronavirus.insumos.dto;

import javax.swing.*;

public class SingUpDto extends UserDto {

    private String password;

    public SingUpDto() {}

    public void setPassword(String password) { this.password = password; }
    public String getPassword() { return password; }
}
