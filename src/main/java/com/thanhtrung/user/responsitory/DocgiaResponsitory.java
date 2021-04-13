package com.thanhtrung.user.responsitory;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.thanhtrung.user.model.Docgia;
import org.springframework.stereotype.Repository;

@Repository
public interface DocgiaResponsitory extends CrudRepository<Docgia, Integer>{

	List<Docgia> findByEmail(String email);
	List<Docgia> findByTenho(String tenho);
	List<Docgia> findByLop(String lop);
	List<Docgia> findByMadocgia(int madocgia);
}
