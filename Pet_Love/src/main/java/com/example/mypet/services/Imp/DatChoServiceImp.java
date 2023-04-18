package com.example.mypet.services.Imp;

import com.example.mypet.entities.DatCho;
import com.example.mypet.repositories.DatChoRepository;
import com.example.mypet.services.DatChoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DatChoServiceImp implements DatChoService {

    private final DatChoRepository datChoRepository;

    @Autowired
    public DatChoServiceImp(DatChoRepository datChoRepository) {
        this.datChoRepository = datChoRepository;
    }

    @Override
    public Optional<DatCho> findById(String id) {
        return datChoRepository.findById(id);
    }
}
