package com.thanhtrung.user.service;

import java.util.List;
import java.util.Optional;

import com.thanhtrung.user.model.Sach;


public interface SachService {

	Iterable<Sach> findAll();
	Optional<Sach> findById(int masach);
	List<Sach> findByMasach(int masach);
	List<Sach> findByTensach(String tensach);
//	List<Loaisach> findByListLoaisach(int masach);
//	List<Loaisach> findGetAllLoaisach();
	void save(Sach sach);
	void delete(int masach);
	
}
