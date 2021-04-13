package com.thanhtrung.user.service;

import java.util.List;
import java.util.Optional;

import com.thanhtrung.user.model.Loaisach;


public interface LoaisachService {
	Iterable<Loaisach> findAll();
	Optional<Loaisach> findById(int maloai);
	List<Loaisach> findByTenloai(String tenloai);
	List<Loaisach> findByMaloai(int maloai);
	void save(Loaisach loaisach);
	void delete(int maloai);
}
