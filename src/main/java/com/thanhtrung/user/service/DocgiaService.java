package com.thanhtrung.user.service;

import java.util.List;
import java.util.Optional;

import com.thanhtrung.user.model.Docgia;


public interface DocgiaService {
	Iterable<Docgia> findAll();
	Optional<Docgia> findById(int madocgia);
	List<Docgia> findByTenho(String tenho);
	List<Docgia> findByEmail(String email);
	List<Docgia> findByLop(String lop);
	List<Docgia> findByMadocgia(int madocgia);
	void save(Docgia docgia);
	void delete(int madocgia);
}
