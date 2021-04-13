package com.thanhtrung.user.model;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tacgia", uniqueConstraints = {
		@UniqueConstraint(columnNames = "tentacgia")
})
public class Tacgia {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "matacgia", nullable = false)
	private int matacgia;
	
	@Column(name = "tentacgia", nullable = false)
	private String tentacgia;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "yyyy-MM-dd") 
	@Column(name = "namsinh", nullable = false)
	private Date namsinh;
	
	@ManyToMany
	@JoinTable(name = "tacgiabansao", 
	joinColumns = @JoinColumn( name = "matacgia", referencedColumnName = "matacgia"  ),
	inverseJoinColumns = @JoinColumn(name = "mabansao", referencedColumnName = "mabansao" ))
	private Set<Bansao> listBansao = new HashSet<Bansao>(0);

	public Tacgia(String tentacgia, Date namsinh, Set<Bansao> listBansao) {
		this.tentacgia = tentacgia;
		this.namsinh = namsinh;
		this.listBansao = listBansao;
	}

	public Tacgia() {
		
	}

	public int getMatacgia() {
		return matacgia;
	}

	public void setMatacgia(int matacgia) {
		this.matacgia = matacgia;
	}

	public String getTentacgia() {
		return tentacgia;
	}

	public void setTentacgia(String tentacgia) {
		this.tentacgia = tentacgia;
	}

	public Date getNamsinh() {
		return namsinh;
	}

	public void setNamsinh(Date namsinh) {
		this.namsinh = namsinh;
	}

	public Set<Bansao> getListBansao() {
		return listBansao;
	}

	public void setListBansao(Set<Bansao> listBansao) {
		this.listBansao = listBansao;
	}

	@Override
	public String toString() {
		return tentacgia+" ";
	}
	
	
}

