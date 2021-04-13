package com.thanhtrung.user.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Nhaxuatban")
public class Nhaxuatban {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "manxb")
	private int manxb;
	
	@Column(name = "tennxb")
	private String tennxb;
	
//	@OrderBy("empNo desc")
	@OneToMany(cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH},
			mappedBy = "nhaxuatban")
	private Set<NXBinBansao> listNXBinBansao = new HashSet<NXBinBansao>(0);

	
	public Nhaxuatban(String tennxb, Set<NXBinBansao> listNXBinBansao) {
		this.tennxb = tennxb;
		this.listNXBinBansao = listNXBinBansao;
	}
	public Nhaxuatban() {
		
	}
	
	public Nhaxuatban(int manxb, String tennxb) {
		this.manxb = manxb;
		this.tennxb = tennxb;
	}

	public int getManxb() {
		return manxb;
	}

	public void setManxb(int manxb) {
		this.manxb = manxb;
	}

	public String getTennxb() {
		return tennxb;
	}

	public void setTennxb(String tennxb) {
		this.tennxb = tennxb;
	}

	public Set<NXBinBansao> getListNXBinBansao() {
		return listNXBinBansao;
	}

	public void setListNXBinBansao(Set<NXBinBansao> listNXBinBansao) {
		this.listNXBinBansao = listNXBinBansao;
	}
	
	
}



