package com.example.demo.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.dto.CompanyDTO;
import com.example.demo.entity.Company;
import com.example.demo.service.CompanyService;

@RestController
public class CompanyController {
	@Autowired
	private CompanyService companyService;
	
	@RequestMapping("/company")
	public List<CompanyDTO> getCompany() {

//		List<CompanyDTO> response = new ArrayList<CompanyDTO>();
//		Iterable<Company> listado = companyService.obtenerCompany();
//		ModelMapper modelMapper = new ModelMapper();
//		listado.forEach(company -> {
//		CompanyDTO companyDTO = modelMapper.map(company, CompanyDTO.class);
//		response.add(companyDTO);
//	});
//	return response;
		
		ModelMapper modelMapper = new ModelMapper();
		return StreamSupport.stream(companyService.obtenerCompany().spliterator(), false)
				.map(c -> modelMapper.map(c, CompanyDTO.class)).collect(Collectors.toList());

	}
	
	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/company")
	public Company guardarCompany(@RequestBody Company company) {
		return companyService.guardarCompany(company);
	}

}
