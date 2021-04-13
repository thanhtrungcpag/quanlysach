package com.thanhtrung.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thanhtrung.user.model.Sach;
import com.thanhtrung.user.responsitory.SachResponsitory;


@Service
public class SachServiceImpl implements SachService{

	@Autowired
	private SachResponsitory sachRes;
	
	
	@Override
	public Iterable<Sach> findAll() {
		
		return sachRes.findAll();
	}

	@Override
	public Optional<Sach> findById(int masach) {
		
		return sachRes.findById(masach);
	}

	@Override
	public List<Sach> findByMasach(int masach) {
		
		return sachRes.findByMasach(masach);
	}

	@Override
	public List<Sach> findByTensach(String tensach) {
		
		return sachRes.findByTensach(tensach);
	}

	@Override
	public void save(Sach sach) {
		sachRes.save(sach);
		
	}

	@Override
	public void delete(int masach) {
		sachRes.deleteById(masach);

	}

//	@Override
//	public List<Loaisach> findByListLoaisach(int masach) {
//		
//		return sachRes.findByListLoaisach(masach);
//	}



}
