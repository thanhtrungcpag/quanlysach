package com.thanhtrung.user.responsitory;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.thanhtrung.user.model.Phieumuon;
import org.springframework.stereotype.Repository;

@Repository
public interface PhieumuonResponsitory extends CrudRepository<Phieumuon, Integer> {

	List<Phieumuon> findByMaphieu(int maphieu);
	List<Phieumuon> findByTenphieu(String tenphieu);
	List<Phieumuon> findByLoai(String loai);
	
}
