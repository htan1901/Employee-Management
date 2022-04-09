package com.example.employee_management.java_objects;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import com.example.employee_management.java_objects.con_nguoi.PhongBan;

public class ListPhongBan extends ArrayList<PhongBan> {
    private static ListPhongBan instance;

    public static ListPhongBan getInstance() {
        if (instance == null) {
            instance = new ListPhongBan();
        }
        return instance;
    }

    private ListPhongBan() {
        init("src\\main\\java\\com\\example\\employee_management\\database\\institute_data.txt");
    }



    private void init(String fileName) {
        File instituteFile = new File(fileName);
        try {
            Scanner fileScanner = new Scanner(instituteFile);
            while (fileScanner.hasNext()) {
                String dataFromFile = fileScanner.nextLine();
                int delim = dataFromFile.indexOf(",");
                String maPB = dataFromFile.substring(0,delim);
                String tenPB = dataFromFile.substring(delim+1);
                add(new PhongBan(maPB, tenPB));
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
