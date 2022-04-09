package com.example.employee_management.java_objects.con_nguoi.nhan_vien;

import com.example.employee_management.java_objects.con_nguoi.PhongBan;

public abstract class NhanVienCLC extends NhanVien {
	protected String trinhDo;
	protected String nganh;
	protected String noiDaoTao;

	@Override
	public String toString() {
		return super.toString()  + trinhDo + "," + nganh + "," + noiDaoTao + ",";
	}

	public NhanVienCLC(NhanVienCLC nhanVienCLC) {
		super(nhanVienCLC);
		this.trinhDo = nhanVienCLC.trinhDo;
		this.nganh = nhanVienCLC.nganh;
		this.noiDaoTao = nhanVienCLC.noiDaoTao;
	}

	public NhanVienCLC() {
		trinhDo = "null";
		nganh = "null";
	}

	public NhanVienCLC(String hoTen, String ngaySinh, String maSo,String ngayNhanViec, PhongBan phongBan, long luong, String trinhDo,
			String nganh, String noiDaoTao) {
		super(hoTen, ngaySinh, maSo, ngayNhanViec, phongBan, luong);
		this.trinhDo = trinhDo;
		this.nganh = nganh;
		this.noiDaoTao = noiDaoTao;
	}

	public String getTrinhDo() {
		return trinhDo;
	}

	public void setTrinhDo(String trinhDo) {
		this.trinhDo = trinhDo;
	}

	public String getNganh() {
		return nganh;
	}

	public void setNganh(String nganh) {
		this.nganh = nganh;
	}

	public String getNoiDaoTao() {
		return noiDaoTao;
	}

	public void setNoiDaoTao(String noiDaoTao) {
		this.noiDaoTao = noiDaoTao;
	}

}
