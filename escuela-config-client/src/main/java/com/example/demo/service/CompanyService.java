package com.example.demo.service;

import com.example.demo.dto.CompanyReducidoDTO;
import com.example.demo.entity.Company;
import com.example.demo.excepciones.ResourceNotFoundExecption;

public interface CompanyService {
	public Iterable<Company> obtenerCompany();
	
	public Company guardarCompany(Company company);


	public Company asociarCompany(Long id_company, Long id) throws ResourceNotFoundExecption;

	public Company actualizarCompany(Long id_company, CompanyReducidoDTO companyReducidoDTO) throws ResourceNotFoundExecption;

}

