package com.thanhtrung.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thanhtrung.user.model.Bansao;
import com.thanhtrung.user.model.Sach;
import com.thanhtrung.user.responsitory.BansaoResponsitory;

@Service
public class BansaoServiceImpl implements BansaoService {
	
	@Autowired
	private BansaoResponsitory bansaoRes;

	@Override
	public Iterable<Bansao> findAll() {
	
		return bansaoRes.findAll();
	}

	@Override
	public Optional<Bansao> findById(int mabansao) {
		
		return bansaoRes.findById(mabansao);
	}

	@Override
	public List<Bansao> findByMabansao(int mabansao) {
		
		return bansaoRes.findByMabansao(mabansao);
	}

	@Override
	public List<Bansao> findBySach(Sach sach) {
		
		return bansaoRes.findBySach(sach);
	}

	@Override
	public void save(Bansao bansao) {
		bansaoRes.save(bansao);
		
	}

	@Override
	public void delete(int mabansao) {
		bansaoRes.deleteById(mabansao);
		
	}

}
