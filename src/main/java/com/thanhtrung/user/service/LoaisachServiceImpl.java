package com.thanhtrung.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thanhtrung.user.model.Loaisach;
import com.thanhtrung.user.responsitory.LoaisachResponsitory;

@Service
public class LoaisachServiceImpl implements LoaisachService {
	
	@Autowired
	private LoaisachResponsitory loaisachRes;
	

	@Override
	public Iterable<Loaisach> findAll() {
		
		return loaisachRes.findAll();
	}

	@Override
	public Optional<Loaisach> findById(int maloai) {
		
		return loaisachRes.findById(maloai);
	}

	@Override
	public List<Loaisach> findByTenloai(String tenloai) {
		
		return loaisachRes.findByTenloai(tenloai);
	}

	@Override
	public List<Loaisach> findByMaloai(int maloai) {
		
		return loaisachRes.findByMaloai(maloai);
	}

	@Override
	public void save(Loaisach loaisach) {
		loaisachRes.save(loaisach);
		
	}

	@Override
	public void delete(int maloai) {
		loaisachRes.deleteById(maloai);
		
	}

}
