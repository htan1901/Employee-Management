package com.example.employee_management.java_objects.con_nguoi;

public class HocVien extends ConNguoi {
	private float diemToan;
	private float diemVan;
	private float diemLy;

	@Override
	public String toString() {
		return super.toString() +
						"\nDiem toan: " + diemToan +
						"\nDiem van: " + diemVan +
						"\nDiem ly: " + diemLy;
	}

	public HocVien(HocVien hocVien) {
		super(hocVien);
		this.diemLy = hocVien.diemLy;
		this.diemToan = hocVien.diemToan;
		this.diemVan = hocVien.diemVan;
	}

	public HocVien() {
	}

	public HocVien(String hoTen, String ngaySinh, float diemToan, float diemVan, float diemLy) {
		super(hoTen, ngaySinh);
		this.diemToan = diemToan;
		this.diemVan = diemVan;
		this.diemLy = diemLy;
	}

	@Override
	public Long tinhLuong() {
		return 0L;
	}

	public float getDiemLy() {
		return diemLy;
	}

	public float getDiemToan() {
		return diemToan;
	}

	public float getDiemVan() {
		return diemVan;
	}

	public void setDiemLy(float diemLy) {
		if (diemLy < 0) {
			this.diemLy = 0;
			return;
		}
		this.diemLy = diemLy;
	}

	public void setDiemVan(float diemVan) {
		if (diemVan < 0) {
			this.diemVan = 0;
			return;
		}
		this.diemVan = diemVan;
	}

	public void setDiemToan(float diemToan) {
		if (diemToan < 0) {
			this.diemToan = 0;
			return;
		}
		this.diemToan = diemToan;
	}
}
