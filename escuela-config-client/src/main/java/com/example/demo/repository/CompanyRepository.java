package com.example.demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.CompanyReducidoDTO;
import com.example.demo.entity.Company;

@Repository
public interface CompanyRepository extends CrudRepository<Company, Long>{

	CompanyReducidoDTO save(CompanyReducidoDTO company);


}
