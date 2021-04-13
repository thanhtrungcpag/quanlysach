package com.thanhtrung.user.service;

import java.util.List;
import java.util.Optional;

import com.thanhtrung.user.model.Bansao;
import com.thanhtrung.user.model.Sach;

public interface BansaoService {

	Iterable<Bansao> findAll();
	Optional<Bansao> findById(int mabansao);
	List<Bansao> findByMabansao(int mabansao);
	List<Bansao> findBySach(Sach sach);
	void save(Bansao bansao);
	void delete(int mabansao);
	
}
