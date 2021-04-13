package com.thanhtrung.user.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name = "bansao")
public class Bansao {
	
	@Id
	@Column(name = "mabansao", nullable = false)
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	private int mabansao;
	

	@OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
			 mappedBy = "bansao")
	private Set<Muon> listMuon= new HashSet<Muon>();
	
	@OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
			 mappedBy = "bansao")
	private Set<NXBinBansao> listNXBinBanSao= new HashSet<NXBinBansao>();
	
	@ManyToMany(mappedBy = "listBansao"	)
	private Set<Tacgia> listTacGia = new HashSet<Tacgia>();

	@ManyToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "masach", nullable = false)
	private Sach sach;
	
	@Column(name = "tinhtrang", nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean tinhtrang;
	
	public Bansao() {
	}

	public Bansao(Set<Muon> listMuon, Set<NXBinBansao> listNXBinBanSao, Set<Tacgia> listTacGia, Sach sach) {
		this.listMuon = listMuon;
		this.listNXBinBanSao = listNXBinBanSao;
		this.listTacGia = listTacGia;
		this.sach = sach;
	}

	public int getMabansao() {
		return mabansao;
	}

	public void setMabansao(int mabansao) {
		this.mabansao = mabansao;
	}

	public Set<Muon> getListMuon() {
		return listMuon;
	}

	public void setListMuon(Set<Muon> listMuon) {
		this.listMuon = listMuon;
	}

	public Set<NXBinBansao> getListNXBinBanSao() {
		return listNXBinBanSao;
	}

	public void setListNXBinBanSao(Set<NXBinBansao> listNXBinBanSao) {
		this.listNXBinBanSao = listNXBinBanSao;
	}

	public Set<Tacgia> getListTacGia() {
		return listTacGia;
	}

	public void setListTacGia(Set<Tacgia> listTacGia) {
		this.listTacGia = listTacGia;
	}

	public Sach getSach() {
		return sach;
	}

	public void setSach(Sach sach) {
		this.sach = sach;
	}
	
	public boolean isTinhtrang() {
		return tinhtrang;
	}

	public void setTinhtrang(boolean tinhtrang) {
		this.tinhtrang = tinhtrang;
	}
	
	
	
	
}
