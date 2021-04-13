package com.thanhtrung.user.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "phieumuon")
public class Phieumuon {
	
	
	@Id
	@Column(name = "maphieu", nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int maphieu;
	
	@Column(name = "tenphieu", nullable = false)
	private String tenphieu;
	
	@Column(name = "loai", nullable = false)
	private String loai;
	

	@ManyToOne(fetch =FetchType.LAZY, cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "madocgia", nullable = false)
	private Docgia docgia;
	



	@OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},			
				mappedBy = "phieumuon")
	private Set<Muon> listMuon= new HashSet<Muon>();

	public Phieumuon(String tenphieu, String loai, Docgia docgia) {
		super();
		this.tenphieu = tenphieu;
		this.loai = loai;
		this.docgia = docgia;
	}

	public Phieumuon(String tenphieu, String loai, Docgia docgia, Set<Muon> listMuon) {
		super();
		this.tenphieu = tenphieu;
		this.loai = loai;
		this.docgia = docgia;
		this.listMuon = listMuon;
	}
	
	public Phieumuon() {
		
	}

	public int getMaphieu() {
		return maphieu;
	}

	public void setMaphieu(int maphieu) {
		this.maphieu = maphieu;
	}

	public String getTenphieu() {
		return tenphieu;
	}

	public void setTenphieu(String tenphieu) {
		this.tenphieu = tenphieu;
	}

	public String getLoai() {
		return loai;
	}

	public void setLoai(String loai) {
		this.loai = loai;
	}

	public Docgia getDocgia() {
		return docgia;
	}

	public void setDocgia(Docgia docgia) {
		this.docgia = docgia;
	}

	public Set<Muon> getListMuon() {
		return listMuon;
	}

	public void setListMuon(Set<Muon> listMuon) {
		this.listMuon = listMuon;
	}

	@Override
	public String toString() {
		return "Phieumuon [maphieu=" + maphieu +
				", tenphieu=" + tenphieu + ", loai=" +
				loai + ", docgia=" + docgia
				+ "]";
	}
	
	
	
}
