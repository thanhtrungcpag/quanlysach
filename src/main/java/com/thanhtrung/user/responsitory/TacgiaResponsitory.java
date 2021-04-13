package com.thanhtrung.user.responsitory;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.thanhtrung.user.model.Tacgia;
import org.springframework.stereotype.Repository;

@Repository
public interface TacgiaResponsitory extends CrudRepository<Tacgia, Integer>{
	List<Tacgia> findByTentacgia(String tenTacgia);
	List<Tacgia> findBymatacgia(int matacgia);
}
