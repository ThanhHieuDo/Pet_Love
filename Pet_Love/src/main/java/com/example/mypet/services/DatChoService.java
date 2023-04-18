package com.example.mypet.services;

import com.example.mypet.entities.DatCho;
import java.util.Optional;

public interface DatChoService {
    Optional<DatCho> findById(String id);
}
