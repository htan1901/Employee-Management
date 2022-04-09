package com.example.employee_management.java_objects.con_nguoi.nhan_vien;

import com.example.employee_management.java_objects.con_nguoi.PhongBan;

public class QuanLy extends NhanVienCLC {
	private long phuCapCV;

	@Override
	public String toString() {
		return "1," + super.toString() + phuCapCV;
	}

	@Override
	public Long tinhLuong() {
		return luongCoBan + luong + phuCapCV;
	}

	@Override
	public String getChucVu() {
		return "Quản lý";
	}

	public QuanLy(){
	}

	public QuanLy(String hoTen, String ngaySinh, String maSo, String ngayNhanViec, PhongBan phongBan, long luong,
			String trinhDo, String nganh, String noiDaoTao, long phuCapCV) {
		super(hoTen, ngaySinh, maSo, ngayNhanViec, phongBan, luong, trinhDo, nganh, noiDaoTao);
		this.phuCapCV = phuCapCV;
	}

	public QuanLy(long phuCapCV) {
		this.phuCapCV = phuCapCV;
	}

	public QuanLy(QuanLy nhanVienQuanLy) {
		super(nhanVienQuanLy);
		this.phuCapCV = nhanVienQuanLy.phuCapCV;
	}

	public long getPhuCapCV() {
		return phuCapCV;
	}

	public void setPhuCapCV(long phuCapCV) {
		this.phuCapCV = phuCapCV;
	}
	
}
