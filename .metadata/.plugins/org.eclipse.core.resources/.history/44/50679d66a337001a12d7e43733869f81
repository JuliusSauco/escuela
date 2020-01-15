package com.example.demo.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Company;
import com.example.demo.repository.CompanyRepository;
import com.example.demo.service.CompanyService;

@Transactional(readOnly = true)
@Service
public class CompanyServiceimpl implements CompanyService {

	@Autowired
	private CompanyRepository companyRepository;
	
	@Override
	public Iterable<Company> obtenerCompany() {
		// TODO Auto-generated method stub
		return companyRepository.findAll();
	}

	@Transactional(readOnly = false)
	@Override
	public Company guardarCompany(Company company) {
		// TODO Auto-generated method stub
		return companyRepository.save(company);
	}

}
