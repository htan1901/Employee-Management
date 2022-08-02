package com.example.employee_management.utility;

import com.example.employee_management.java_objects.ListPhongBan;
import com.example.employee_management.java_objects.con_nguoi.PhongBan;
import com.example.employee_management.java_objects.con_nguoi.nhan_vien.GiaoVien;
import com.example.employee_management.java_objects.con_nguoi.nhan_vien.NhanVien;
import com.example.employee_management.java_objects.con_nguoi.nhan_vien.QuanLy;
import org.thymeleaf.util.StringUtils;

import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class FileUtils {
    private String fileName = "src/main/java/com/example/employee_management/database/employee_data.txt";
    private static FileUtils instance;

    public static FileUtils getInstance() {
        if (instance == null)
            instance = new FileUtils();
        return instance;
    }

    private FileUtils() { }

    public void saveDataToFile(ArrayList<NhanVien> savedData) throws IOException {
        FileWriter fileWriter = new FileWriter(fileName,false);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (NhanVien i : savedData) {
            bufferedWriter.write(i.toString());
            bufferedWriter.newLine();
            bufferedWriter.flush();
        }
    }

    public ArrayList<NhanVien> getDataFromFile() {
        ArrayList<NhanVien> listNV = new ArrayList<>();
        try {

            File file = new File(fileName);
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNext()) {
                String dataFromFile = fileScanner.nextLine();
                StringTokenizer tokenizer = new StringTokenizer(dataFromFile, ",");
                ArrayList<String> data = new ArrayList<>();
                while (tokenizer.hasMoreTokens()) {
                    data.add(tokenizer.nextToken());
                }
                int type = Integer.parseInt(data.get(0));
                String maSo = data.get(1);
                String hoTen = data.get(2);
                String ngaySinh = data.get(3);
                String ngayNhanViec = data.get(4);
                PhongBan phongBan = ListPhongBan.getInstance()
                        .stream()
                        .filter(nv -> nv.getMaPB().equals(data.get(5)))
                        .findFirst()
                        .orElse(null);
                long luong = Long.parseLong(data.get(6));
                String trinhDo = data.get(7);
                String nganh = data.get(8);
                String noiDaoTao = data.get((9));
                long thuLao = Long.parseLong(data.get(10));
                if (type == 1)  // manager
                    listNV.add(new QuanLy(hoTen, ngaySinh, maSo, ngayNhanViec, phongBan, luong, trinhDo, nganh, noiDaoTao, thuLao));
                else  // teacher
                    listNV.add(new GiaoVien(hoTen, ngaySinh, maSo, ngayNhanViec, phongBan, luong, trinhDo, nganh, noiDaoTao, thuLao));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listNV;
    }

}
