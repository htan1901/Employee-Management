package com.example.employee_management.java_objects;

import com.example.employee_management.java_objects.con_nguoi.ConNguoi;
import com.example.employee_management.java_objects.con_nguoi.nhan_vien.GiaoVien;
import com.example.employee_management.java_objects.con_nguoi.nhan_vien.NhanVien;
import com.example.employee_management.java_objects.con_nguoi.nhan_vien.QuanLy;
import com.example.employee_management.utility.FileUtils;
import org.thymeleaf.util.StringUtils;

import java.util.ArrayList;

public class ListNhanVien extends ArrayList<NhanVien> {


	public ListNhanVien() {
		addAll(FileUtils.getInstance().getDataFromFile());
	}

	private void validData(NhanVien e) {
		if (StringUtils.isEmpty(e.getNgaySinh()))
			e.setNgaySinh("01/01//1999");
		if (StringUtils.isEmpty(e.getNgayNhanViec()))
			e.setNgayNhanViec("01/01/2030");
		if (e.getLuong() == null )
			e.setLuong(0);
		if (e instanceof GiaoVien) {
			if (StringUtils.isEmpty(((GiaoVien) e).getNoiDaoTao()))
				((GiaoVien) e).setNoiDaoTao("BKAV");
			if (((GiaoVien) e).getThuLaoGD() == 0)
				((GiaoVien) e).setThuLaoGD(0);
		}
		if (e instanceof QuanLy) {
			if (StringUtils.isEmpty(((QuanLy) e).getNoiDaoTao()))
				((QuanLy) e).setNoiDaoTao("BKAV");
			if (((QuanLy) e).getPhuCapCV() == 0)
				((QuanLy) e).setPhuCapCV(0);
		}
	}

//	public void saveData(NhanVien e) {
//		try {
//			FileWriter fileWriter = new FileWriter(fileName,true);
//			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//			validData(e);
//			bufferedWriter.write(e.toString());
//			bufferedWriter.newLine();
//			bufferedWriter.close();
//		} catch (FileNotFoundException fileNotFoundException) {
//
//		} catch (IOException ioException) {
//			ioException.printStackTrace();
//		}
//	}

	public ArrayList<NhanVien> fillManager() {
		ArrayList<NhanVien> listQL = new ArrayList<>();
		for (ConNguoi i : this) 
			if(i instanceof QuanLy)
				listQL.add(new QuanLy((QuanLy)i));
		return listQL;
	}

	public ArrayList<NhanVien> fillTeacher() {
		ArrayList<NhanVien> listGV = new ArrayList<>();
		for (ConNguoi i : this) 
			if(i instanceof GiaoVien)
				listGV.add(new GiaoVien((GiaoVien)i));
		return listGV;
	}

}
