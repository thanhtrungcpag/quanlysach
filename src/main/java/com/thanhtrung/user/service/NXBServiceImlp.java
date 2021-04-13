package com.thanhtrung.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thanhtrung.user.model.Nhaxuatban;
import com.thanhtrung.user.responsitory.NXBResponsitory;

@Service
public class NXBServiceImlp implements NXBService {
	
	@Autowired
	private NXBResponsitory nxb;

	@Override
	public Iterable<Nhaxuatban> findAll() {
		
		return nxb.findAll();
	}

	@Override
	public List<Nhaxuatban> findByManxb(int manxb) {
		
		return nxb.findByManxb(manxb);
	}

	@Override
	public List<Nhaxuatban> findByTennxb(String tennxb) {
		
		return nxb.findByTennxb(tennxb);
	}

	@Override
	public void save(Nhaxuatban nxb) {
		this.nxb.save(nxb);
		
	}

	@Override
	public void delete(int manxb) {
		nxb.deleteById(manxb);
		
	}

	@Override
	public Optional<Nhaxuatban> findById(int manxb) {
		
		return nxb.findById(manxb);
	}

}
