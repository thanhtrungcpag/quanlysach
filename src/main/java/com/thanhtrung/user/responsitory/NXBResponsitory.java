package com.thanhtrung.user.responsitory;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.thanhtrung.user.model.Nhaxuatban;
import org.springframework.stereotype.Repository;

@Repository
public interface NXBResponsitory extends CrudRepository<Nhaxuatban, Integer> {
	
	List<Nhaxuatban> findByTennxb(String tennxb);
	List<Nhaxuatban> findByManxb(int manxb);
}
