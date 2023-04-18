package com.example.mypet.dtos;

import com.example.mypet.entities.embedded.ThongTinDatCho;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DatChoDto {
    @Id
    private String id;
    private String email;
    private List<ThongTinDatCho> thongTinDatChos = new ArrayList<>();
    private Date thoiGian;
    private String canDan;
    private String trangThaiDatCho;
    private boolean trangThai = true;

    public DatChoDto() {
    }

    public DatChoDto(String id, String email, List<ThongTinDatCho> thongTinDatChos, Date thoiGian, String canDan, String trangThaiDatCho, boolean trangThai) {
        this.id = id;
        this.email = email;
        this.thongTinDatChos = thongTinDatChos;
        this.thoiGian = thoiGian;
        this.canDan = canDan;
        this.trangThaiDatCho = trangThaiDatCho;
        this.trangThai = trangThai;
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public List<ThongTinDatCho> getThongTinDatChos() {
        return thongTinDatChos;
    }

    public Date getThoiGian() {
        return thoiGian;
    }

    public String getCanDan() {
        return canDan;
    }

    public String getTrangThaiDatCho() {
        return trangThaiDatCho;
    }

    public boolean isTrangThai() {
        return trangThai;
    }
}
