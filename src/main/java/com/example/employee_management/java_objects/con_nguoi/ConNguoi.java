package com.example.employee_management.java_objects.con_nguoi;

public abstract class ConNguoi {
	protected String hoTen;
	protected String ngaySinh;
	protected final long luongCoBan = 30;

	public ConNguoi(ConNguoi conNguoi) {
		this.hoTen = conNguoi.hoTen;
		this.ngaySinh = conNguoi.ngaySinh;
	}

	public ConNguoi() {
	}

	public ConNguoi(String hoTen, String ngaySinh) {
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
	}

	@Override
	public String toString() {
		return hoTen + "," + ngaySinh + ",";
	}

	public abstract Long tinhLuong();

	public String getHoTen() {
		return hoTen;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public Long getLuongCoBan() {
		return luongCoBan;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
}
