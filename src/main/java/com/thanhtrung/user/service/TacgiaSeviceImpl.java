package com.thanhtrung.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thanhtrung.user.model.Tacgia;
import com.thanhtrung.user.responsitory.TacgiaResponsitory;

@Service
public class TacgiaSeviceImpl implements TacgiaService {

	@Autowired
	private TacgiaResponsitory tacgiaService;
	
	@Override
	public Iterable<Tacgia> findAll() {
		
		return tacgiaService.findAll();
	}

	@Override
	public Optional<Tacgia> findById(int matacgia) {
		
		return tacgiaService.findById(matacgia);
	}

	@Override
	public List<Tacgia> findBytentacgia(String tentacgia) {
		
		return tacgiaService.findByTentacgia(tentacgia);
	}

	@Override
	public List<Tacgia> findByMatacgia(int matacgia) {
		
		return tacgiaService.findBymatacgia(matacgia);
	}

	@Override
	public void save(Tacgia tacgia) {
		tacgiaService.save(tacgia);
		
	}

	@Override
	public void delete(int matacgia) {
		
		tacgiaService.deleteById(matacgia);;
		
	}

}
