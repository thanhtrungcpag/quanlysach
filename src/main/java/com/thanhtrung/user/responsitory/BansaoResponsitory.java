package com.thanhtrung.user.responsitory;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.thanhtrung.user.model.Bansao;
import com.thanhtrung.user.model.Sach;
import org.springframework.stereotype.Repository;

@Repository
public interface BansaoResponsitory extends CrudRepository<Bansao, Integer> {

	List<Bansao> findBySach(Sach sach);
	List<Bansao> findByMabansao(int mabansao);
}
