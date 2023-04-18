package com.example.mypet.dtos;

import com.example.mypet.entities.embedded.GiaDichVu;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DichVuDto {
    @Id
    private String id;
    private String maDichVu;
    private String tenDichVu;
    private String noiDung;
    private List<GiaDichVu> giaDichVus = new ArrayList<>();
    private boolean trangThai = true;

    public DichVuDto() {
    }

    public DichVuDto(String id, String maDichVu, String tenDichVu, String noiDung, List<GiaDichVu> giaDichVus, boolean trangThai) {
        this.id = id;
        this.maDichVu = maDichVu;
        this.tenDichVu = tenDichVu;
        this.noiDung = noiDung;
        this.giaDichVus = giaDichVus;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public String getMaDichVu() {
        return maDichVu;
    }

    public String getTenDichVu() {
        return tenDichVu;
    }

    public String getNoiDung() {
        return noiDung;
    }

    public List<GiaDichVu> getGiaDichVus() {
        return giaDichVus;
    }

    public boolean isTrangThai() {
        return trangThai;
    }
}

