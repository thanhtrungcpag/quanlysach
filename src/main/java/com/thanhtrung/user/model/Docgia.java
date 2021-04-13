package com.thanhtrung.user.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "docgia", uniqueConstraints = {
		@UniqueConstraint(columnNames = "tenho"),
		@UniqueConstraint(columnNames = "email")})
public class Docgia {

	@Id
	@Column(name= "madocgia", nullable = false)
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int madocgia;
	
	@Column(name = "tenho", nullable = false)
	private String tenho;
	
	@Column(name = "gioitinh" , nullable = false)
	private String gioitinh;
	
	@Column(name = "email", nullable= false)
	private String email;
	
	@Column(name = "lop", nullable = false)
	private String lop;
		
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	@Temporal(TemporalType.DATE)
	@Column(name = "ngaysinh", nullable = false)
	private Date ngaysinh;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "docgia",
			cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private Set<Phieumuon> listPhieumuon = new HashSet<Phieumuon>(0);
	
	public Docgia() {
		
	}

	public Docgia(String tenho, String gioitinh, String email, String lop, Date ngaysinh) {
		this.tenho = tenho;
		this.gioitinh = gioitinh;
		this.email = email;
		this.lop = lop;
		this.ngaysinh = ngaysinh;
	}
	
	public Docgia(String tenho, String gioitinh, String email, String lop, Date ngaysinh,
			Set<Phieumuon> listPhieumuon) {
		this.tenho = tenho;
		this.gioitinh = gioitinh;
		this.email = email;
		this.lop = lop;
		this.ngaysinh = ngaysinh;
		this.listPhieumuon = listPhieumuon;
	}

	public int getMadocgia() {
		return madocgia;
	}

	public void setMadocgia(int madocgia) {
		this.madocgia = madocgia;
	}

	public String getTenho() {
		return tenho;
	}

	public void setTenho(String tenho) {
		this.tenho = tenho;
	}

	public String getGioitinh() {
		return gioitinh;
	}

	public void setGioitinh(String gioitinh) {
		this.gioitinh = gioitinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getLop() {
		return lop;
	}

	public void setLop(String lop) {
		this.lop = lop;
	}

	public Date getNgaysinh() {
		return ngaysinh;
	}

	public void setNgaysinh(Date ngaysinh) {
		this.ngaysinh = ngaysinh;
	}

	public Set<Phieumuon> getListPhieumuon() {
		return listPhieumuon;
	}

	public void setListPhieumuon(Set<Phieumuon> listPhieumuon) {
		this.listPhieumuon = listPhieumuon;
	}

	@Override
	public String toString() {
		return "Docgia [madocgia=" + madocgia + ", tenho=" + tenho + ", gioitinh=" + gioitinh + ", email=" + email
				+ ", lop=" + lop + ", ngaysinh=" + ngaysinh + ", listPhieumuon=" + listPhieumuon + "]";
	}
	
	
	
	
}
