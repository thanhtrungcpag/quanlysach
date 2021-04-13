package com.thanhtrung.user.service;

import java.util.List;
import java.util.Optional;

import com.thanhtrung.user.model.Tacgia;

public interface TacgiaService {

	Iterable<Tacgia> findAll();
	Optional<Tacgia> findById(int matacgia);
	List<Tacgia> findBytentacgia(String tentacgia);
	List<Tacgia> findByMatacgia(int matacgia);
	void save(Tacgia tacgia);
	void delete(int matacgia);
	
}
