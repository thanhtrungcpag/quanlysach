package com.thanhtrung.user.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Type;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "muon")
public class Muon implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "maphieu")
	private Phieumuon phieumuon;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "mabansao")
	private Bansao bansao;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	@Temporal(TemporalType.DATE)
	@Column(name = "ngaymuon", nullable = false)
	private Date ngaymuon;
	
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	@Temporal(TemporalType.DATE)
	@Column(name = "ngaytra", nullable = false)
	private Date ngaytra;
	
	@Column(name = "tinhtrang", nullable = false)
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean tinhtrang;
	
	public Muon() {
		
	}
	
	public Muon(Phieumuon phieumuon, Bansao bansao, Date ngaymuon, Date ngaytra) {
		this.phieumuon = phieumuon;
		this.bansao = bansao;
		this.ngaymuon = ngaymuon;
		this.ngaytra = ngaytra;
	}

	public Phieumuon getPhieumuon() {
		return phieumuon;
	}

	public void setPhieumuon(Phieumuon phieumuon) {
		this.phieumuon = phieumuon;
	}

	public Bansao getBansao() {
		return bansao;
	}

	public void setBansao(Bansao bansao) {
		this.bansao = bansao;
	}

	public Date getNgaymuon() {
		return ngaymuon;
	}

	public void setNgaymuon(Date ngaymuon) {
		this.ngaymuon = ngaymuon;
	}

	public Date getNgaytra() {
		return ngaytra;
	}

	public void setNgaytra(Date ngaytra) {
		this.ngaytra = ngaytra;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Muon [phieumuon=" + phieumuon +
				", bansao=" + bansao + ", ngaymuon=" +
				ngaymuon + ", ngaytra=" + ngaytra
				+ "]";
	}

	public boolean isTinhtrang() {
		return tinhtrang;
	}

	public void setTinhtrang(boolean tinhtrang) {
		this.tinhtrang = tinhtrang;
	}
	
	

	
	
	
}
