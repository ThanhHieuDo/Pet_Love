package com.example.mypet.controller;

import com.example.mypet.dtos.TaiKhoanDto;
import com.example.mypet.entities.ResponseObject;
import com.example.mypet.entities.TaiKhoan;
import com.example.mypet.repositories.TaiKhoanRepository;
import com.example.mypet.services.TaiKhoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/user")
public class TaiKhoanController {

    private final TaiKhoanService taiKhoanService;
    private final TaiKhoanRepository taiKhoanRepository;

    @Autowired
    public TaiKhoanController(TaiKhoanService taiKhoanService, TaiKhoanRepository taiKhoanRepository) {
        this.taiKhoanService = taiKhoanService;
        this.taiKhoanRepository = taiKhoanRepository;
    }

    @PostMapping("/insert")
    public ResponseEntity<ResponseObject> insert(@RequestBody TaiKhoanDto dto) {

        List<TaiKhoan> foundUsers = taiKhoanRepository.findByemail(dto.getEmail().trim());

        if(foundUsers.size() > 0) {
            return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(
                    new ResponseObject("failed", "User name already taken", "")
            );
        }

        TaiKhoan taikhoan = new TaiKhoan();
        taikhoan.setName(dto.getName());
        taikhoan.setEmail(dto.getEmail());
        taikhoan.setDienThoai(dto.getDienThoai());
        taikhoan.setPassword(dto.getPassword());
        taikhoan.setRoles(dto.getRoles());
        taiKhoanRepository.save(taikhoan);

        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("oke", "them thanh cong", taikhoan));
    }

    @GetMapping("/all")
    public List<TaiKhoan> getAllProducts() {
        return taiKhoanRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponseObject> findById(@PathVariable String id) {
        Optional<TaiKhoan> taiKhoan = taiKhoanService.findById(id);

        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("oke", "tim kiem oke", taiKhoan));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ResponseObject> updateUser(@RequestBody TaiKhoan newTaiKhoan, @PathVariable String id) {
        TaiKhoan updatedProduct = taiKhoanRepository.findById(id)
                .map(taiKhoan -> {
                    taiKhoan.setDienThoai(newTaiKhoan.getDienThoai());
                    taiKhoan.setEmail(newTaiKhoan.getEmail());
                    taiKhoan.setPassword(newTaiKhoan.getPassword());
                    taiKhoan.setRoles(newTaiKhoan.getRoles());
                    taiKhoan.setName(newTaiKhoan.getName());
                    return taiKhoanRepository.save(taiKhoan);
                }).orElseGet(() -> {
                    newTaiKhoan.setId(id);
                    return taiKhoanRepository.save(newTaiKhoan);
                });
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseObject("ok", "Update user successfully", updatedProduct));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseObject> deleteProduct(@PathVariable String id) {
        if (taiKhoanRepository.existsById(id)) {
            taiKhoanRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body(
                    new ResponseObject("ok", "Delete user successfully", ""));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new ResponseObject("failed", "Cannot find product to delete", ""));
        }
    }
}

