package com.example.mypet.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by: IntelliJ IDEA
 * User      : thangpx
 * Date      : 4/11/23
 * Time      : 9:17 PM
 * Filename  : TaiKhoan
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "user")
public class TaiKhoan {
    @Id
    private String id;

    private String name;

    // email không được trùng nhau
    private String email;

    @JsonIgnore
    private String password;

    private String dienThoai;

    public class TaiKhoan {
        private String name;
        private String email;
        private String password;
        private String dienThoai;
        private boolean trangThai = true;
        private List<String> roles = new ArrayList<>();
    
        public TaiKhoan(String name, String email, String password, String dienThoai, boolean trangThai) {
            this.name = name;
            this.email = email;
            this.password = password;
            this.dienThoai = dienThoai;
            this.trangThai = trangThai;
        }
    
        public boolean isTrangThai() {
            return trangThai;
        }
    
        public void setTrangThai(boolean trangThai) {
            this.trangThai = trangThai;
        }
    
        public List<String> getRoles() {
            return roles;
        }
    
        public void setRoles(List<String> roles) {
            this.roles = roles;
        }
    }
    
}
