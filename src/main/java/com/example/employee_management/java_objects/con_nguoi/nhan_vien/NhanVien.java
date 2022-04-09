package com.example.employee_management.java_objects.con_nguoi.nhan_vien;

import com.example.employee_management.java_objects.con_nguoi.ConNguoi;
import com.example.employee_management.java_objects.con_nguoi.PhongBan;

public abstract class NhanVien extends ConNguoi {
	protected String maSo;
	protected String ngayNhanViec;
	protected PhongBan phongBan;
	protected long luong;

	public abstract String getChucVu();

	@Override
	public String toString() {
		return maSo + "," +super.toString() + ngayNhanViec + "," + phongBan.getMaPB() + "," + luong + ",";
	}

	public NhanVien(NhanVien nhanVien) {
		super(nhanVien);
		this.maSo = nhanVien.maSo;
		this.ngayNhanViec = nhanVien.ngayNhanViec;
		this.phongBan = nhanVien.phongBan;
		this.luong = nhanVien.luong;
	}

	public NhanVien() {
	}

	public NhanVien(String hoTen, String ngaySinh, String maSo,String ngayNhanViec, PhongBan phongBan, long luong) {
		super(hoTen, ngaySinh);
		this.maSo = maSo;
		this.ngayNhanViec = ngayNhanViec;
		this.phongBan = phongBan;
		this.luong = luong;
	}

	public String getMaSo() {
		return maSo;
	}

	public void setMaSo(String maSo) {
		this.maSo = maSo;
	}

	public String getNgayNhanViec() {
		return ngayNhanViec;
	}

	public void setNgayNhanViec(String ngayNhanViec) {
		this.ngayNhanViec = ngayNhanViec;
	}

	public PhongBan getPhongBan() {
		return phongBan;
	}

	public void setPhongBan(PhongBan phongBan) {
		this.phongBan = phongBan;
	}

	public Long getLuong() {
		return luong;
	}

	public void setLuong(long luong) {
		this.luong = luong;
	}

}
