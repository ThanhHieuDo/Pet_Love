package com.example.mypet;

import com.example.mypet.entities.DatCho;
import com.example.mypet.entities.DichVu;
import com.example.mypet.entities.LoaiThuCung;
import com.example.mypet.entities.TaiKhoan;
import com.example.mypet.entities.embedded.GiaDichVu;
import com.example.mypet.entities.embedded.ThongTinDatCho;
import com.example.mypet.repositories.DatChoRepository;
import com.example.mypet.repositories.DichVuRepository;
import com.example.mypet.repositories.LoaiThuCungRepository;
import com.example.mypet.repositories.TaiKhoanRepository;
import com.example.mypet.utils.EnumTrangThaiDatCho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

@SpringBootApplication
public class MyPetApplication implements CommandLineRunner {
    @Autowired
    private TaiKhoanRepository taiKhoanRepository;

    @Autowired
    private DichVuRepository dichVuRepository;

    @Autowired
    private LoaiThuCungRepository loaiThuCungRepository;

    @Autowired
    private DatChoRepository datChoRepository;

    public static void main(String[] args) {
        SpringApplication.run(MyPetApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        initDataIfEmpty();
    }

    private void initDataIfEmpty() throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT"));

        if (taiKhoanRepository.count() == 0) {
            TaiKhoan taiKhoan = new TaiKhoan("hieu", "hieu@gmail.com", "160801", "0922336932", true);
            taiKhoanRepository.save(taiKhoan);
        }

        if (dichVuRepository.count() == 0) {
            GiaDichVu giaDichVu = new GiaDichVu("Cho", 35.3, 100000.2);
            List<GiaDichVu> giaDichVuList = new ArrayList<>();
            giaDichVuList.add(giaDichVu);
            DichVu dichVu = new DichVu("ma1", "Tam thu", "Tam cho, meo,...", giaDichVuList);
            dichVuRepository.save(dichVu);
        }

        if (loaiThuCungRepository.count() == 0) {
            LoaiThuCung loaiThuCung = new LoaiThuCung("mathucung1", "Loai Nho Con");
            loaiThuCungRepository.save(loaiThuCung);
        }

        if (datChoRepository.count() == 0) {
            ThongTinDatCho thongtin1 = new ThongTinDatCho("tam meo", "250000");
            ThongTinDatCho thongtin2 = new ThongTinDatCho("tam cho", "220000");
            List<ThongTinDatCho> thongTinDatChoList = new ArrayList<>();
            thongTinDatChoList.add(thongtin1);
            thongTinDatChoList.add(thongtin2);
            DatCho datCho = new DatCho("suttycr7@gmail.com", thongTinDatChoList, EnumTrangThaiDatCho.DA_DAT);
            datChoRepository.save(datCho);
        }
    }
}
