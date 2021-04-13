package com.thanhtrung.user.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "nxbin")
public class NXBinBansao implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "mabansao")
	private Bansao bansao;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "manxb")
	private Nhaxuatban nhaxuatban;
	
	@Column(name = "gia", nullable = false)
	private int gia;
	
	@Column(name = "phienban", nullable = false)
	private int phienban;
	
	
 
	public NXBinBansao(Bansao bansao, Nhaxuatban nhaxuatban, int gia, int phienban) {
		this.bansao = bansao;
		this.nhaxuatban = nhaxuatban;
		this.gia = gia;
		this.phienban = phienban;
	}
	
	public NXBinBansao() {
		
	}
	public Bansao getBansao() {
		return bansao;
	}
	public void setBansao(Bansao bansao) {
		this.bansao = bansao;
	}
	public Nhaxuatban getNhaxuatban() {
		return nhaxuatban;
	}
	public void setNhaxuatban(Nhaxuatban nhaxuatban) {
		this.nhaxuatban = nhaxuatban;
	}
	public int getGia() {
		return gia;
	}
	public void setGia(int gia) {
		this.gia = gia;
	}
	public int getPhienban() {
		return phienban;
	}
	public void setPhienban(int phienban) {
		this.phienban = phienban;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "NXBinBansao [bansao=" + bansao +
				", nhaxuatban=" + nhaxuatban +
				", gia=" + gia + ", phienban="
				+ phienban + "]";
	}
	
}
