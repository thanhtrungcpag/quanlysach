package com.thanhtrung.user.service;

import java.util.List;
import java.util.Optional;

import com.thanhtrung.user.model.Phieumuon;


public interface PhieumuonService {

	Iterable<Phieumuon> findAll();
	Optional<Phieumuon> findById(int maphieu);
	List<Phieumuon> findByMaphieu(int maphieu);
	List<Phieumuon> findByTenphieu(String tenphieu);
	List<Phieumuon> findByLoai(String loai);
	void save(Phieumuon phieumuon);
	void delete(int maphieu);
	
}
