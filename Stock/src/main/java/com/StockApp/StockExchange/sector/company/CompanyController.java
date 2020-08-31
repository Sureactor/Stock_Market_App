package com.StockApp.StockExchange.sector.company;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CompanyController {
	@Autowired
	CompanyService service = new CompanyService();
	
	@PostMapping("/admin/company/add")
	public void addCompany(@RequestBody Company company) {
		service.companyAdder(company);
	}	
	
	@GetMapping("/user/company/get/{companyId}") 
	public Company getCompanyById(@PathVariable Integer companyId){
		return service.CompanyByIdGetter(companyId);
	}
	
<<<<<<< HEAD
	@PutMapping("/admin/company/update")
	public void updateCompany(@RequestBody Company company) {
		service.companyAdder(company);
	}
	
	@DeleteMapping("/admin/company/delete/{companyId}")
	public void deleteCompany(@PathVariable Integer companyId) {
		service.companyDeleter(companyId);
	}
	
		@GetMapping("/user/company/getbysector/{sectorId}") 
	public List<Company> getCompanyBySector(@PathVariable Integer sectorId){
		return service.CompanyBySectorGetter(sectorId);
	}	


=======
	@GetMapping("/admin/company/get") 
	public List<Company> getCompany(){
		List<Company> list=service.CompanyGetter();
		return list;
	}
>>>>>>> 7bd8b8d... Changes by Ajay 30 Aug 2020 on stockexchange & company
}
