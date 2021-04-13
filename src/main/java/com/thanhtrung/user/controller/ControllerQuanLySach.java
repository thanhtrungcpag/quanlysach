package com.thanhtrung.user.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thanhtrung.user.model.Bansao;
import com.thanhtrung.user.model.Docgia;
import com.thanhtrung.user.model.Loaisach;
import com.thanhtrung.user.model.Muon;
import com.thanhtrung.user.model.NXBinBansao;
import com.thanhtrung.user.model.Nhaxuatban;
import com.thanhtrung.user.model.Phieumuon;
import com.thanhtrung.user.model.Sach;
import com.thanhtrung.user.model.Tacgia;
import com.thanhtrung.user.service.BansaoService;
import com.thanhtrung.user.service.DocgiaService;
import com.thanhtrung.user.service.LoaisachService;
import com.thanhtrung.user.service.NXBService;
import com.thanhtrung.user.service.PhieumuonService;
import com.thanhtrung.user.service.SachService;
import com.thanhtrung.user.service.TacgiaService;

@Controller
public class ControllerQuanLySach {

	@Autowired
	private DocgiaService docgiaService;
	
	@Autowired
	private NXBService nxbService;
	
	@Autowired
	private TacgiaService tacgiaService;
	
	@Autowired
	private LoaisachService loaisachService;
	
	@Autowired
	private SachService sachService;
	
	@Autowired
	private BansaoService bansaoService;
	
	
	@Autowired
	private PhieumuonService phieumuonService;
	
	// docgia
	
	@GetMapping("/docgia")
	public String index(Model model) {
		
		model.addAttribute("listdocgia", docgiaService.findAll());
		
		return "list";
	}
	
	@GetMapping("/docgia/search")
	public String search(@RequestParam("search") String search, Model model) {
		if (search.equals("")) {
			return "redirect:/docgia";
		}
		
		// kiem tra co phai la so hay khong
		
		String digit = "\\d*";
			
		if(search.matches(digit)) {
		//	return "layout";
			model.addAttribute("listdocgia",docgiaService.findByMadocgia(Integer.parseInt(search)));
		}else {
			model.addAttribute("listdocgia", docgiaService.findByTenho(search));
//			List<Docgia> listdocgia = docgiaService.findByTenho(search);
//			for(int i = 0; i < listdocgia.size(); i++) {
//				System.out.println("test: "+listdocgia.get(i).toString());
//			}
		}
	
		return "list";
	}
	
	@GetMapping("/docgia/create")
	public String create(Model model) {
		model.addAttribute("docgia", new Docgia());
		return "form";
	}
	
	@PostMapping("/docgia/save")
	public String save(@Valid Docgia docgia, BindingResult result ,RedirectAttributes redirect) {
		if(result.hasErrors()) {
			return "form";
		}
				
		docgiaService.save(docgia);
		redirect.addFlashAttribute("success", "Thành công!");
		
		return "redirect:/docgia";
	}
	
	@GetMapping("/docgia/{madocgia}/delete")
	public String docgiaDelele(@PathVariable int madocgia, RedirectAttributes redirect) {
		
		docgiaService.delete(madocgia);
		redirect.addFlashAttribute("success", "Xoá thành công!");
		
		
		return "redirect:/docgia";
	}
	
	@GetMapping("/docgia/{madocgia}/edit")
	public String docgiaEdit(@PathVariable int madocgia, Model model) {
		
		model.addAttribute("docgia", docgiaService.findById(madocgia));
		return "form";
		
	}
	
	@GetMapping("/docgia/{madocgia}/chitiet")
	public String chitiet(@PathVariable int madocgia, Model model) {
		
		model.addAttribute("docgia", docgiaService.findById(madocgia).get());
		return "chitiet";
		
	}
	
	@GetMapping("/docgia/{madocgia}/trasach")
	public String trasach(@PathVariable int madocgia,Model model) {
		model.addAttribute("docgia", docgiaService.findById(madocgia).get());
		return "trasach";
	}
	
	@PostMapping("/docgia/trasach/save")
	public String trasachSave(
			@RequestParam(name = "listphieumuon", required = false) int[] listphieumuon,
			@RequestParam(name = "mabansao", required = false) int[] listmabansao
			) {
		
		
		for(int i = 0; i < listphieumuon.length; i++) {
			
			Muon muon = new Muon();
			
			
			for(int j = 0 ; j < listmabansao.length; j++) {
				muon.setPhieumuon(phieumuonService.findById(listphieumuon[i]).get());
				muon.setBansao(bansaoService.findById(listmabansao[i]).get());
				muon.setTinhtrang(true);
				System.out.println("muonsfsd "+muon);
			}
		}
			
	
		
		
		return "index";
	}
	
	
	// ket thuc doc gia
		
		
	//nhaxuatban
	
	@GetMapping("/nxb")
	public String nxb(Model model) {
		
		model.addAttribute("listnxb", nxbService.findAll());
		
		return "nxb";
	}
	
	// create nxb
	
	@GetMapping("/nxb/create")
	public String nxbcreate(Model model) {
		
		model.addAttribute("nxb", new Nhaxuatban());
		
		return "formnxb";
	}
	
	@PostMapping("/nxb/save")
	public String nxbsave(@Valid Nhaxuatban nxbtemp,BindingResult result, RedirectAttributes redirect ){
		if(result.hasErrors()) {
			return "formnxb";
		}
		
		
		nxbService.save(nxbtemp);
		redirect.addFlashAttribute("success", "Thêm thành công nhà xuất bản!");
		return "redirect:/nxb";
	}
	
	@GetMapping("/nxb/search")
	public String nxbsearch(@RequestParam("nxbsearch") String search, Model model) {
		if (search.equals("")) {
			return "redirect:/nxb";
		}
		
		// kiem tra co phai la so hay khong
		
		String digit = "\\d*";
	
		
		
		if(search.matches(digit)) {
		//	return "layout";
			model.addAttribute("listnxb", nxbService.findByManxb(Integer.parseInt(search)));
		}else {
			model.addAttribute("listnxb", nxbService.findByTennxb(search));
		}
		
		
		return "nxb";

	}
	
	@GetMapping("/nxb/{manxb}/delete")
	public String nxbdelete(@PathVariable int manxb, RedirectAttributes  result) {
		
		
		nxbService.delete(manxb);
		
		result.addFlashAttribute("success", "Bạn đã xóa nhà xuất bản");
		
		return "redirect:/nxb";
	}
	
	@GetMapping("/nxb/{manxb}/edit")
	public String edit(@PathVariable int manxb, Model model) {
		model.addAttribute("nxb", nxbService.findById(manxb));
		return "formnxb";
	}
	
	
	//ket thuc nxb
	
	// tacgia
	@GetMapping("/tacgia")
	public String tacgia(Model model) {
		
		model.addAttribute("listtacgia", tacgiaService.findAll());
		
		return "tacgia";
	}
	
	@GetMapping("/tacgia/create")
	public String tacgiacreate(Model model) {
		
		model.addAttribute("tacgia", new Tacgia());
		
		return "formtacgia";
	}
	
	@PostMapping("/tacgia/save")
	public String tacgiasave(@Valid Tacgia tacgia,
			BindingResult result, RedirectAttributes redirect ) {
		System.out.println("tacgiaTEST "+ tacgia.toString());
		if(result.hasErrors()) {
			return "formtacgia";
		}
		tacgiaService.save(tacgia);
		redirect.addFlashAttribute("success", "Thêm tác giả thành công!");
		
		return "redirect:/tacgia";
	}
	
	@GetMapping("/tacgia/search")
	public String tacgiasreach(@RequestParam("search") String search, Model model) {
		if(search.equals(""))
			return "redirect:/tacgia";
		
		String digit = "\\d*";
		if(search.matches(digit)) {
			model.addAttribute("listtacgia", tacgiaService.findByMatacgia(Integer.parseInt(search)));
		}else {
			model.addAttribute("listtacgia", tacgiaService.findBytentacgia(search));
		}
				
		return "tacgia";
	}
	
	@GetMapping("/tacgia/{matacgia}/delete")
	public String tacgiadelete(@PathVariable int matacgia,
			RedirectAttributes redirect ) {
		
		tacgiaService.delete(matacgia);
		redirect.addFlashAttribute("success", "Xóa tác giả thành công");
		
		return "redirect:/tacgia";
	}
	
	@GetMapping("/tacgia/{matacgia}/edit")
	public String tacgiaedit(@PathVariable int matacgia, Model model) {
		
		model.addAttribute("tacgia", tacgiaService.findById(matacgia));
		
		return "formtacgia";
	}
	
	// end tacgia
		
	// the loai
		
	@GetMapping("/loaisach")
	public String theloai(Model model) {
		
		model.addAttribute("listloaisach", loaisachService.findAll());
				
		return "loaisach";
	}
	
	@GetMapping("/loaisach/create")
	public String loaisachCreate(Model model) {
		
		model.addAttribute("loaisach", new Loaisach());
		
		return "formloaisach";
	}
	
	@PostMapping("/loaisach/save")
	public String loaisachSave(@Valid Loaisach loaisach, BindingResult result,
			RedirectAttributes redirect) {
		
		if(result.hasErrors()) {
			return "formloaisach";
		}
		
		loaisachService.save(loaisach);
		redirect.addFlashAttribute("success", "Thành công");
		
		return "redirect:/loaisach";
	}
	
	@GetMapping("/loaisach/{maloai}/delete")
	public String loaisachdelete(@PathVariable int maloai, 
			RedirectAttributes redirect) {
		
		loaisachService.delete(maloai);
		
		redirect.addFlashAttribute("success", "Xoá thành công!");
		
		return "redirect:/loaisach";
	}
	
	@GetMapping("/loaisach/{maloai}/edit")
	public String loaisachEdit(@PathVariable int maloai,Model model) {
		
		model.addAttribute("loaisach", loaisachService.findById(maloai));
				
		return "formloaisach";
	}
	
	@GetMapping("/loaisach/search")
	public String loaisachSearch(@RequestParam("loaisachsearch") String search, Model model) {
		
		if(search.equals(""))
			return "redirect:/loaisach";
		
		String digit = "\\d*";
		if(search.matches(digit)) {
			model.addAttribute("listloaisach", loaisachService.findByMaloai(Integer.parseInt(search)));
		}else {
			model.addAttribute("listloaisach", loaisachService.findByTenloai(search));
		}
		
		
		return "loaisach";
	}
	
	// end loai sach
	
	// sach 
	
	@GetMapping("/sach")
	public String sach(Model model) {
		
		model.addAttribute("listsach", sachService.findAll());
				
		return "sach";
	}
	
	@GetMapping("/sach/create")
	public String sachCreate(Model model) {
		
		model.addAttribute("sach", new Sach());
		model.addAttribute("listloai", loaisachService.findAll());
		return "formsach";
	}
	
	@PostMapping("/sach/save")
	public String sachSave(@ModelAttribute("sach") Sach sach,
			@RequestParam(value = "loais", required = false)int[] loai,
			BindingResult result, RedirectAttributes redirect) {
		if(result.hasErrors() || loai == null ) {
			return "formsach";
		}
		for(int i = 0; i < loai.length; i++) {
			if(loaisachService.findById(loai[i]) != null) {
				sach.getListLoaisach().add(loaisachService.findById(loai[i]).get());
				loaisachService.findById(loai[i]).get().getListSach().add(sach);
			}
		}
			
		sachService.save(sach);
		redirect.addFlashAttribute("success", "Thành công!");
		
		
		return "redirect:/sach";
	}

	@GetMapping("/sach/{masach}/edit")
	public String sachEdit(@PathVariable int masach, Model model) {
		
		model.addAttribute("sach", sachService.findById(masach));
		//System.out.println(sachService.findById(masach).get().getListLoaisach());
		return "formsach";
	}
	
	@GetMapping("/sach/{masach}/delete")
	public String sachDelete(@PathVariable int masach, 
			RedirectAttributes redirect) {
		sachService.delete(masach);
		redirect.addFlashAttribute("success", "Xóa Thành công");
		return "redirect:/sach";
	}
	
	@GetMapping("/sach/search")
	public String sachSearch(@RequestParam("sachsearch") String search, Model model) {
		
		if(search.equals(""))
			return "redirect:/sach";
		
		String digit = "\\d*";
		if(search.matches(digit)) {
			model.addAttribute("listsach", sachService.findByMasach(Integer.parseInt(search)));
		}else {
			model.addAttribute("listsach", sachService.findByTensach(search));
		}
		
		
		return "sach";
	}

	
	@GetMapping("/sach/{masach}/thembansao")
	public String thembansao(@PathVariable int masach, Model model) {
		
		model.addAttribute("sach", sachService.findById(masach).get() );
		model.addAttribute("listtacgia", tacgiaService.findAll());
		model.addAttribute("listnxb", nxbService.findAll());
		
		return "formbansao";
	}
	
	@PostMapping("/sach/savebansao")
	public String savebansao(
			@RequestParam(value = "masach", required = false) String masachString,
			@RequestParam(value = "soluong", required = false) int soluong,
			@RequestParam(value = "phienban", required = false) int phienban,
			@RequestParam(value = "giasach", required = false) int giasach,
			@RequestParam(value = "manxb", required = false) int manxb,
			@RequestParam(value = "matacgia", required = false) int[] listmatacgia,
			RedirectAttributes redirect
			) {

		System.out.println("Ma sach "+masachString+"\nSo luong: " + soluong + "\n manxb " + manxb );
		
		int masach = Integer.parseInt(masachString);
		
		Bansao[] bansao =  new Bansao[soluong];
		for(int  i = 0; i < soluong;  i++) {
			 bansao[i] = new Bansao();
			System.out.println("\n BUS \n");
			// Them 1 sach nhieu ban sao
			bansao[i].setSach(sachService.findById(masach).get());
			sachService.findById(masach).get().getListBansao().add(bansao[i]);
			
			
			
			// luu tacgia
			System.out.println("\n BUS \n");
			for(int j = 0; j < listmatacgia.length; j++) {
				if(tacgiaService.findById(listmatacgia[j]) != null) {
					bansao[i].getListTacGia().add(tacgiaService.findById(listmatacgia[j]).get());
					tacgiaService.findById(listmatacgia[j]).get().getListBansao().add(bansao[i]);
				}
			}
			
			// luu nxb in ban sao
			System.out.println("\nTEST\n");
			NXBinBansao nxbinBansao = new NXBinBansao();
			nxbinBansao = new NXBinBansao();
			nxbinBansao.setBansao(bansao[i]);
			nxbinBansao.setNhaxuatban(nxbService.findById(manxb).get());
			nxbinBansao.setGia(giasach);
			nxbinBansao.setPhienban(phienban);
			System.out.println("\n" + nxbinBansao);
			//luu bansao va  nxb
			
			bansao[i].getListNXBinBanSao().add(nxbinBansao);
			System.out.println("\n \n Ban sao sao ban sao \n \n"+bansao[i].getListNXBinBanSao());
			bansaoService.save(bansao[i]);
			
		}
		
		redirect.addFlashAttribute("success", "Tạo "+ soluong+" bản sao thành công");
		
		
		return "redirect:/sach";
	}
	
	// ket thuc sach
	
	//ban sao
	
	@GetMapping("/bansao")
	public String bansao(Model model) {
		model.addAttribute("listbansao", bansaoService.findAll());
		
		return "bansao";
	}
	

	//phieu muon;
	
	@GetMapping("/phieumuon")
	public String phieumuon(Model model) {
		
		model.addAttribute("listphieumuon", phieumuonService.findAll());
		
		
		return "phieumuon";
	}
	
	@GetMapping("/phieumuon/{madocgia}/create")
	public String phieumuonCreate(@PathVariable int madocgia, Model model) {
	//	System.out.println("sdfsjklsf \n \n "+docgiaService.findById(madocgia).get());
		model.addAttribute("docgia", docgiaService.findById(madocgia).get());
		model.addAttribute("ngay", java.time.LocalDate.now());
		model.addAttribute("listbansao", bansaoService.findAll());
		return "formphieumuon";
	}
	
	@PostMapping("/phieumuon/save")
	public String phieumuonSave(
			@RequestParam(value = "madocgia", required = false) int madocgia,
			@RequestParam(value = "mabansao", required = false) int[] listmabansao
			,@RequestParam(value = "ngaymuon", required = false) String ngaymuon
			,@RequestParam(value = "ngaytra", required = false) String ngaytra,
			@RequestParam(value = "tenphieu", required = false) String tenphieu,
			@RequestParam(value = "loaiphieu", required = false) String loaiphieu
		) {
		for(int i = 0 ; i< listmabansao.length; i++) {
			System.out.println("\n ma ban sao = " +listmabansao[i]);
		}
		
		System.out.println("\n ma doc gia = " + madocgia);
		System.out.println(java.time.LocalDate.now()); 
		System.out.println("ngay hien tai:" + new Date());
		Phieumuon phieumuon = new Phieumuon();
		Muon[] muon = new Muon[listmabansao.length];
		for(int i = 0; i < listmabansao.length; i++) {
			if(bansaoService.findById(listmabansao[i]) != null) {
				muon[i] = new Muon();
				muon[i].setBansao(bansaoService.findById(listmabansao[i]).get());
				muon[i].setPhieumuon(phieumuon);
				bansaoService.findById(listmabansao[i]).get().setTinhtrang(true);
				try {
					muon[i].setNgaymuon(new SimpleDateFormat("yyyy-MM-dd").parse(ngaymuon));
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					muon[i].setNgaytra(new SimpleDateFormat("yyyy-MM-dd").parse(ngaytra));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				phieumuon.getListMuon().add(muon[i]);
				
			}
		}
		phieumuon.setLoai(tenphieu);
		phieumuon.setTenphieu(loaiphieu);
		
		docgiaService.findById(madocgia).get().getListPhieumuon().add(phieumuon);
		
		phieumuon.setDocgia(docgiaService.findById(madocgia).get());
		docgiaService.findById(madocgia).get().getListPhieumuon().add(phieumuon);
		
		phieumuonService.save(phieumuon);
			
		return "index";
	}
	
	@GetMapping("/phieumuon/{maphieu}/chitietphieumuon")
	public String chitietphieumuon(@PathVariable int maphieu, Model model) {
		System.out.println("maphieu: \n"+maphieu);
		model.addAttribute("phieumuon", phieumuonService.findById(maphieu).get());
		
		
		return "chitietphieumuon";
	}
	
	
	
	
}
