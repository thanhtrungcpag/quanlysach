package com.thanhtrung.user.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thanhtrung.user.model.Docgia;
import com.thanhtrung.user.responsitory.DocgiaResponsitory;

@Service
public class DocgiaServiceImpl implements DocgiaService {
	
	@Autowired
	DocgiaResponsitory docgiaResponsitory; 

	@Override
	public Iterable<Docgia> findAll() {
		
		return docgiaResponsitory.findAll();
	}

	@Override
	public Optional<Docgia> findById(int madocgia) {
		
		return docgiaResponsitory.findById(madocgia);
	}

	@Override
	public List<Docgia> findByTenho(String tenho) {
		
		return docgiaResponsitory.findByTenho(tenho);
	}

	@Override
	public List<Docgia> findByEmail(String email) {
		
		return docgiaResponsitory.findByEmail(email);
	}

	@Override
	public List<Docgia> findByLop(String lop) {
		
		return docgiaResponsitory.findByLop(lop);
	}

	@Override
	public void save(Docgia docgia) {
		docgiaResponsitory.save(docgia);
		
	}

	@Override
	public void delete(int madocgia) {
		docgiaResponsitory.deleteById(madocgia);
		
	}

	@Override
	public List<Docgia> findByMadocgia(int madocgia) {
		
		return docgiaResponsitory.findByMadocgia(madocgia);
	}

}
