package com.thanhtrung.user.responsitory;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.thanhtrung.user.model.Sach;
import org.springframework.stereotype.Repository;

@Repository
public interface SachResponsitory extends CrudRepository<Sach, Integer>{

	List<Sach> findByMasach(int masach);
	List<Sach> findByTensach(String tensach);
	//List<Loaisach> findByListLoaisach(int masach);
	
}
