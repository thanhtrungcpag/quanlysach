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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "sach", uniqueConstraints= {
		@UniqueConstraint(columnNames= "tensach")})
public class Sach {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "masach", nullable = false)
	private int masach;
	
	@Column(name = "tensach", nullable = false)
	private String tensach;
	
	@ManyToMany(mappedBy = "listSach", cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH})
	private Set<Loaisach> listLoaisach= new HashSet<Loaisach>();
	
	@OneToMany(fetch=FetchType.EAGER,cascade = {CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH}, mappedBy = "sach")
	private Set<Bansao> listBansao = new HashSet<Bansao>();
	
	public Sach() {
		
	}

	public Sach(String tensach) {
		this.tensach = tensach;
	}


	public Sach(String tensach, Set<Loaisach> listSachloai, Set<Bansao> listBansao) {
		this.tensach = tensach;
		this.listLoaisach = listSachloai;
		this.listBansao = listBansao;
	}

	public int getMasach() {
		return masach;
	}

	public void setMasach(int masach) {
		this.masach = masach;
	}


	public String getTensach() {
		return tensach;
	}

	public void setTensach(String tensach) {
		this.tensach = tensach;
	}

	public Set<Bansao> getListBansao() {
		return listBansao;
	}

	public void setListBansao(Set<Bansao> listBansao) {
		this.listBansao = listBansao;
	}

	public Set<Loaisach> getListLoaisach() {
		return listLoaisach;
	}

	public void setListLoaisach(Set<Loaisach> listLoaisach) {
		this.listLoaisach = listLoaisach;
	}
	
	public int getSoluong() {
		return listBansao.size();
	}
	
	
}
