package com.example.employee_management.service;

import com.example.employee_management.java_objects.ListNhanVien;
import com.example.employee_management.java_objects.ListPhongBan;
import com.example.employee_management.java_objects.con_nguoi.PhongBan;
import com.example.employee_management.java_objects.con_nguoi.nhan_vien.GiaoVien;
import com.example.employee_management.java_objects.con_nguoi.nhan_vien.NhanVien;
import com.example.employee_management.java_objects.con_nguoi.nhan_vien.QuanLy;
import com.example.employee_management.utility.FileUtils;
import com.example.employee_management.utility.Validator;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

@Service
public class MainService {
    private final ListNhanVien listNhanVien = new ListNhanVien();

    public ListNhanVien getListNhanVien() {
        return listNhanVien;
    }

    public int addNhanVien(NhanVien nv) {
        if (!Validator.isIdValid(nv.getMaSo(), listNhanVien))
            return 1;
        if (!Validator.isSalaryValid(nv.getLuong()))
            return 2;
        listNhanVien.add(nv);
//        listNhanVien.saveData(nv);
        try {
            FileUtils.getInstance().saveDataToFile(listNhanVien);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public NhanVien getNhanVienById(String maSo) {
        NhanVien nv = listNhanVien.stream()
                                .filter(nhanVien -> nhanVien.getMaSo().equals(maSo))
                                .findFirst()
                                .orElse(null);
        return nv;
    }

    public boolean changeGiaovien(String maSo, GiaoVien giaoVien, BindingResult result) {
        if (!Validator.isIdValid(maSo,listNhanVien) && !maSo.equals(giaoVien.getMaSo()))
            return false;
        GiaoVien oldNhanVien = (GiaoVien) getNhanVienById(maSo);
        oldNhanVien.setMaSo(giaoVien.getMaSo());
        oldNhanVien.setHoTen(giaoVien.getHoTen());
        oldNhanVien.setNgaySinh(giaoVien.getNgaySinh());
        oldNhanVien.setNgayNhanViec(giaoVien.getNgayNhanViec());
        PhongBan newPB = ListPhongBan.getInstance().stream().filter(phongBan -> phongBan.getMaPB().equals(result.getFieldValue("phongBan"))).findFirst().orElse(null);
        oldNhanVien.setPhongBan(newPB);
        oldNhanVien.setLuong(giaoVien.getLuong());
        oldNhanVien.setTrinhDo(giaoVien.getTrinhDo());
        oldNhanVien.setNganh(giaoVien.getNganh());
        oldNhanVien.setNoiDaoTao(giaoVien.getNoiDaoTao());
        oldNhanVien.setThuLaoGD(giaoVien.getThuLaoGD());
        try {
            FileUtils.getInstance().saveDataToFile(listNhanVien);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public boolean changeQuanLy(String maSo, QuanLy quanLy, BindingResult result) {
        if (!Validator.isIdValid(maSo,listNhanVien) && !maSo.equals(quanLy.getMaSo()))
            return false;
        QuanLy oldNhanVien = (QuanLy) getNhanVienById(maSo);
        oldNhanVien.setMaSo(quanLy.getMaSo());
        oldNhanVien.setHoTen(quanLy.getHoTen());
        oldNhanVien.setNgaySinh(quanLy.getNgaySinh());
        oldNhanVien.setNgayNhanViec(quanLy.getNgayNhanViec());
        PhongBan newPB = ListPhongBan.getInstance().stream().filter(phongBan -> phongBan.getMaPB().equals(result.getFieldValue("phongBan"))).findFirst().orElse(null);
        oldNhanVien.setPhongBan(newPB);
        oldNhanVien.setLuong(quanLy.getLuong());
        oldNhanVien.setTrinhDo(quanLy.getTrinhDo());
        oldNhanVien.setNganh(quanLy.getNganh());
        oldNhanVien.setNoiDaoTao(quanLy.getNoiDaoTao());
        oldNhanVien.setPhuCapCV(quanLy.getPhuCapCV());
        try {
            FileUtils.getInstance().saveDataToFile(listNhanVien);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return true;
    }

    public void sort(Integer option) {
        if (option == null)
            return;
        switch (option) {
            case 1 -> listNhanVien.sort((o1, o2) -> o1.tinhLuong().compareTo(o2.tinhLuong()));
            case 2 -> listNhanVien.sort((o1, o2) -> o2.tinhLuong().compareTo(o1.tinhLuong()));
        }
    }

    public ArrayList<NhanVien> fill(Integer option) {
        if (option == null)
            option = 0;
        switch (option) {
            case 1 -> {
                return listNhanVien.fillManager();
            }
            case 2 -> {
                return listNhanVien.fillTeacher();
            }
            default -> {
                return listNhanVien;
            }
        }
    }

    public ArrayList<NhanVien> searchByName(String hoTen) {
       ArrayList<NhanVien> searchList = new ArrayList<>();
        for (NhanVien nv : listNhanVien)
            if (nv.getHoTen().toLowerCase(Locale.ROOT).contains(hoTen.toLowerCase(Locale.ROOT)))
                searchList.add(nv);
        return searchList;
    }

    public void removeNhanvien(String maSo) {
        listNhanVien.remove(
                listNhanVien.stream()
                        .filter(nhanVien -> nhanVien.getMaSo().equals(maSo))
                        .findFirst()
                        .orElse(null)
        );
        try {
            FileUtils.getInstance().saveDataToFile(listNhanVien);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
