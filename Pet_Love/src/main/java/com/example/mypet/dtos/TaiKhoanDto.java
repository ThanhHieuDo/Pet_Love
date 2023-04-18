package com.example.mypet.dtos;



import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TaiKhoanDto {
    private String name;
    private String email;
    private String password;
    private String dienThoai;
    private List<String> roles = new ArrayList<>();

    public TaiKhoanDto() {
    }

    public TaiKhoanDto(String name, String email, String password, String dienThoai, List<String> roles) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.dienThoai = dienThoai;
        this.roles = roles;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getDienThoai() {
        return dienThoai;
    }

    public List<String> getRoles() {
        return roles;
    }
}

