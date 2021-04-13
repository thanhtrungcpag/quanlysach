package com.thanhtrung.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thanhtrung.user.model.Phieumuon;
import com.thanhtrung.user.responsitory.PhieumuonResponsitory;


@Service
public class PhieumuonServiceImpl implements PhieumuonService {

	@Autowired
	PhieumuonResponsitory phieumuonRes;
	
	@Override
	public Iterable<Phieumuon> findAll() {
		
		return phieumuonRes.findAll();
	}

	@Override
	public Optional<Phieumuon> findById(int maphieu) {
		
		return phieumuonRes.findById(maphieu);
	}

	@Override
	public List<Phieumuon> findByMaphieu(int maphieu) {
		
		return phieumuonRes.findByMaphieu(maphieu);
	}

	@Override
	public List<Phieumuon> findByTenphieu(String tenphieu) {
		
		return phieumuonRes.findByTenphieu(tenphieu);
	}

	@Override
	public List<Phieumuon> findByLoai(String loai) {
	
		return phieumuonRes.findByLoai(loai);
	}

	@Override
	public void save(Phieumuon phieumuon) {
		phieumuonRes.save(phieumuon);

	}

	@Override
	public void delete(int maphieu) {
		phieumuonRes.deleteById(maphieu);

	}

}
