package com.example.mypet.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class LoaiThuCungDto {

    @Id
    private String id;
    private String maLoaiThuCung;
    private String tenLoaiThuCung;
    private boolean trangThai = true;

    public LoaiThuCungDto() {
    }

    public LoaiThuCungDto(String id, String maLoaiThuCung, String tenLoaiThuCung, boolean trangThai) {
        this.id = id;
        this.maLoaiThuCung = maLoaiThuCung;
        this.tenLoaiThuCung = tenLoaiThuCung;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public String getMaLoaiThuCung() {
        return maLoaiThuCung;
    }

    public String getTenLoaiThuCung() {
        return tenLoaiThuCung;
    }

    public boolean isTrangThai() {
        return trangThai;
    }
}
