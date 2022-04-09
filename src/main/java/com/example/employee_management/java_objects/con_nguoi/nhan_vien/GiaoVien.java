package com.example.employee_management.java_objects.con_nguoi.nhan_vien;

import com.example.employee_management.java_objects.con_nguoi.PhongBan;

public class GiaoVien extends NhanVienCLC {
	private long thuLaoGD;

	@Override
	public String toString() {
		return "2," + super.toString() + thuLaoGD;
	}

	@Override
	public Long tinhLuong() {
		return luongCoBan + luong + thuLaoGD;
	}

	@Override
	public String getChucVu() {
		return "Giáo viên";
	}

	public GiaoVien(GiaoVien giaoVien) {
		super(giaoVien);
		this.thuLaoGD = giaoVien.thuLaoGD;
	}

	public GiaoVien() {
	}

	public GiaoVien(String hoTen, String ngaySinh, String maSo, String ngayNhanViec, PhongBan phongBan, long luong, String trinhDo,
			String nganh, String noiDaoTao, long thuLaoGD) {
		super(hoTen, ngaySinh, maSo, ngayNhanViec, phongBan, luong, trinhDo, nganh, noiDaoTao);
		this.thuLaoGD = thuLaoGD;
	}

	public long getThuLaoGD() {
		return thuLaoGD;
	}

	public void setThuLaoGD(long thuLaoGD) {
		this.thuLaoGD = thuLaoGD;
	}

}
