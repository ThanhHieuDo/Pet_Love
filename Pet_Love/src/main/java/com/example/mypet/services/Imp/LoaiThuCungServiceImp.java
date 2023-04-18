package com.example.mypet.services.Imp;

import com.example.mypet.entities.LoaiThuCung;
import com.example.mypet.repositories.LoaiThuCungRepository;
import com.example.mypet.services.LoaiThuCungService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoaiThuCungServiceImp implements LoaiThuCungService {

    private final LoaiThuCungRepository loaiThuCungRepository;

    @Autowired
    public LoaiThuCungServiceImp(LoaiThuCungRepository loaiThuCungRepository) {
        this.loaiThuCungRepository = loaiThuCungRepository;
    }

    @Override
    public List<LoaiThuCung> findAll() {
        return loaiThuCungRepository.findAll();
    }

    @Override
    public Optional<LoaiThuCung> findById(String id) {
        return loaiThuCungRepository.findById(id);
    }
}
