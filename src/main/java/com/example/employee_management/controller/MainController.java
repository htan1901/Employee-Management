package com.example.employee_management.controller;

import com.example.employee_management.java_objects.ListPhongBan;
import com.example.employee_management.java_objects.con_nguoi.PhongBan;
import com.example.employee_management.java_objects.con_nguoi.nhan_vien.GiaoVien;
import com.example.employee_management.java_objects.con_nguoi.nhan_vien.NhanVien;
import com.example.employee_management.java_objects.con_nguoi.nhan_vien.QuanLy;
import com.example.employee_management.service.MainService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class MainController {

	@Autowired
	MainService mainService;

	@GetMapping("/add")
	public String mainAdd () {
		return "add";
	}

	@GetMapping("/list")
	public String mainList (Model model,
						   	@RequestParam (required = false) Integer sort,
						   	@RequestParam (required = false) Integer filter,
						   	@RequestParam (required = false) String search) {
		if (search == null || "".equals(search)) {
			mainService.sort(sort);
			model.addAttribute("listNhanVien", mainService.fill(filter));
		}
		else
			model.addAttribute("listNhanVien", mainService.searchByName(search));
		return "list";
	}

	@GetMapping("/add-teacher")
	public String addTeacher (Model model) {
		model.addAttribute("giaoVien", new GiaoVien());
		model.addAttribute("danhSachPhongBan", ListPhongBan.getInstance());
		return "add-teacher";
	}

	@GetMapping("/add-manager")
	public String addManager (Model model) {
		model.addAttribute("quanLy", new QuanLy());
		model.addAttribute("danhSachPhongBan", ListPhongBan.getInstance());
		return "add-manager";
	}

	@GetMapping("/delete/{maSo}")
	public String deleteByName (@PathVariable String maSo) {
		mainService.removeNhanvien(maSo);
		return "redirect:/list";
	}

	@GetMapping("/edit/{maSo}")
	public String editNhanVien (Model model, @PathVariable String maSo) {
		NhanVien nhanVien = mainService.getNhanVienById(maSo);
		if (nhanVien == null)
			return "redirect:/list";
		model.addAttribute("danhSachPhongBan",ListPhongBan.getInstance());
		if(nhanVien instanceof QuanLy) {
			model.addAttribute("quanLy",nhanVien);
			return "edit-manager";
		}
		else {
			model.addAttribute("giaoVien", nhanVien);
			return "edit-teacher";
		}
	}

	@PostMapping("/add-teacher")
	 public String addTeacher (@ModelAttribute GiaoVien giaoVien, BindingResult result) {
		 if (result.hasErrors()) {
			 PhongBan newPB = ListPhongBan.getInstance()
					 		.stream()
					 		.filter(phongBan -> phongBan.getMaPB().equals(result.getFieldValue("phongBan")))
					 		.findFirst().orElse(null);
			 giaoVien.setPhongBan(newPB);
		 }
		 int state = mainService.addNhanVien(giaoVien);
		 if (state == 1)
			 return "redirect:/add-teacher?type=1";
		 else
			 if (state == 2)
				  return "redirect:/add-teacher?type=2";
			 else
				  return "redirect:/add";
	}

	@PostMapping("/add-manager")
	public String addManaager (@ModelAttribute QuanLy quanLy, BindingResult result) {
		if (result.hasErrors()) {
			PhongBan newPB = ListPhongBan.getInstance()
							.stream()
							.filter(phongBan -> phongBan.getMaPB().equals(result.getFieldValue("phongBan")))
							.findFirst().orElse(null);
			quanLy.setPhongBan(newPB);
		}
		int state = mainService.addNhanVien(quanLy);
		if (state == 1)
			return "redirect:/add-manager?type=1";
		else
		if (state == 2)
			return "redirect:/add-manager?type=2";
		else
			return "redirect:/add";

	}

	@PostMapping("edit-manager/{maSo}")
	public String editNhanVien (@PathVariable String maSo,
							    @ModelAttribute QuanLy quanLy,
							    BindingResult result) {
		if (mainService.changeQuanLy(maSo, quanLy, result))
			return "redirect:/list";
		else
			return "redirect:/edit/"+maSo+"?type=1";
	}

	@PostMapping("edit-teacher/{maSo}")
	public String editNhanVien (@PathVariable String maSo,
							   	@ModelAttribute GiaoVien giaoVien,
							   	BindingResult result) {
		if (mainService.changeGiaovien(maSo, giaoVien, result))
			return "redirect:/list";
		else
			return "redirect:/edit/"+maSo+"?type=1";
	}
}