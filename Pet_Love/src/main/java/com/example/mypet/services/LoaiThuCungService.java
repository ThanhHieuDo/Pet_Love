package com.example.mypet.services;

import com.example.mypet.entities.LoaiThuCung;
import java.util.List;
import java.util.Optional;

public interface LoaiThuCungService {
    List<LoaiThuCung> findAll();
    Optional<LoaiThuCung> findById(String id);
}
