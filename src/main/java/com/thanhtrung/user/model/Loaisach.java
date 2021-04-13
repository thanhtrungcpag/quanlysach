package com.thanhtrung.user.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "loaisach", uniqueConstraints= {
		@UniqueConstraint(columnNames = "tenloai")
})
public class Loaisach {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY)
	@Column(name = "maloai", nullable = false)
	private int maloai;
	
	@Column(name = "tenloai", nullable = false)
	private String tenloai;
		
	@ManyToMany
	@JoinTable(name = "sach_loai", 
	joinColumns = @JoinColumn( name = "maloai", referencedColumnName = "maloai"  ),
	inverseJoinColumns = @JoinColumn(name = "masach", referencedColumnName = "masach" ))
	private Set<Sach> listSach = new HashSet<Sach>(0);

	public Loaisach() {
		
	}

	public Loaisach(String tenloai) {
		this.tenloai = tenloai;
	}

	public Loaisach(String tenloai, Set<Sach> listSach) {
		this.tenloai = tenloai;
		this.listSach = listSach;
	}

	public int getMaloai() {
		return maloai;
	}

	public void setMaloai(int maloai) {
		this.maloai = maloai;
	}

	public String getTenloai() {
		return tenloai;
	}

	public void setTenloai(String tenloai) {
		this.tenloai = tenloai;
	}

	public Set<Sach> getListSach() {
		return listSach;
	}

	public void setListSach(Set<Sach> listSach) {
		this.listSach = listSach;
	}

	@Override
	public String toString() {
		return "Loaisach [maloai=" + maloai +
				", tenloai=" + tenloai +
				", listSach=" + listSach + "]";
	}
	
}
