package com.example.employee_management.utility;

import com.example.employee_management.java_objects.con_nguoi.nhan_vien.NhanVien;

import java.util.ArrayList;
import java.util.Locale;

public class Validator {

    public static boolean isSalaryValid(long salary) {
        return salary > 0;
    }

    public static boolean isIdValid(String id, ArrayList<NhanVien> listNV) {
        NhanVien nv = listNV.stream()
                            .filter(i -> i.getMaSo().toLowerCase(Locale.ROOT).equals(id.toLowerCase(Locale.ROOT)))
                            .findFirst()
                            .orElse(null);
        return nv == null;
    }
}
