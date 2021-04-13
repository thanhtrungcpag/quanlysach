package com.thanhtrung.user.service;

import java.util.List;
import java.util.Optional;

import com.thanhtrung.user.model.Nhaxuatban;

public interface NXBService {

	Iterable<Nhaxuatban> findAll();
	List<Nhaxuatban> findByManxb(int manxb);
	Optional<Nhaxuatban> findById(int manxb);
	List<Nhaxuatban> findByTennxb(String tennxb);
	void save(Nhaxuatban nxb);
	void delete(int manxb);
	
}
