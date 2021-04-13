package com.thanhtrung.user.responsitory;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.thanhtrung.user.model.Loaisach;
import org.springframework.stereotype.Repository;

@Repository
public interface LoaisachResponsitory extends CrudRepository<Loaisach, Integer> {

	List<Loaisach> findByTenloai(String tenloai);
	List<Loaisach> findByMaloai(int maloai);
}
