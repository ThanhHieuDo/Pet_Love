package com.example.mypet.services;

import com.example.mypet.entities.DichVu;
import java.util.List;
import java.util.Optional;

public interface DichVuService {
    Optional<DichVu> findById(String id);
    List<DichVu> findAll();
}
