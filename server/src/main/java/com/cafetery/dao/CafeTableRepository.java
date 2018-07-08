package com.cafetery.dao;

import com.cafetery.domain.CafeTable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CafeTableRepository extends CrudRepository<CafeTable, Long> {
    List<CafeTable> findAll();
}
