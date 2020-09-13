package com.StockApp.StockExchange.sector.company;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.StockApp.exception.StockException;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class CompanyController {
	@Autowired
	CompanyService service = new CompanyService();
	
	void checkValidity(Company c,BindingResult bind) throws StockException{
		StringBuilder sb = new StringBuilder();
		if(bind.hasErrors()) {
			System.out.println("here babay");
			bind.getAllErrors().forEach(s->sb.append(s.getDefaultMessage()+", "));
			throw new StockException(sb.toString());
		}
	}
	
	@PostMapping("/admin/company/add")
	public void addCompany(@Valid @RequestBody Company company,BindingResult bind) throws StockException {
		checkValidity(company,bind);
		service.companyAdder(company);
		throw new StockException("Company Addedd!!");
	}	
	
	@GetMapping("/user/company/get/{companyId}") 
	public Company getCompanyById(@PathVariable Integer companyId){
		return service.CompanyByIdGetter(companyId);
	}
		
	@GetMapping("/user/company/getAll")
	public List<Company> getAllCompany(){
		return service.AllCompanyGetter();
	}
	@PutMapping("/admin/company/update")
	public void updateCompany(@Valid @RequestBody Company company,BindingResult bind) throws StockException {
		checkValidity(company,bind);
		service.companyUpdater(company);
		throw new StockException("Fields updated");
	}
	
	@DeleteMapping("/admin/company/delete/{companyId}")
	public void deleteCompany(@PathVariable Integer companyId) {
		service.companyDeleter(companyId);
		throw new StockException("Deleted Successfully");
	}
	
		@GetMapping("/user/company/getbysector/{sectorId}") 
	public List<Company> getCompanyBySector(@PathVariable Integer sectorId){
		return service.CompanyBySectorGetter(sectorId);
	}	
		@GetMapping("/user/company/getbysectorexchange/{sectorId}/{exchangeId}") 
		public List<Company> getCompanyBySectorExchange(@PathVariable Integer sectorId,@PathVariable Integer exchangeId){
			return service.CompanyBySectorExchangeGetter(sectorId,exchangeId);
		}	

		@GetMapping("/user/company/getIdbysector/{sectorId}") 
		public List<Integer> getCompanyIdBySector(@PathVariable Integer sectorId){
			return service.CompanyIdBySectorGetter(sectorId);
		}	
    
		@GetMapping("/user/company/get") 
		public List<Company> getCompanyList(){
			List<Company> list=service.CompanyGetter();
			return list;
		}
		
	@GetMapping("/admin/company/get") 
	public List<Company> getCompany(){
		List<Company> list=service.CompanyGetter();
		return list;
	}
	
	@GetMapping("/user/company/getName")
	public List<String> getCompanyName(){
		return service.companyNameGetter();
	}
	
	@GetMapping("admin/company/getNameId")
	public List<String> getNameAndId(){
		List<Company> list=service.CompanyGetter();
		List<String> sub = new ArrayList<>();
		for(Company com:list) {
			sub.add(com.name+" --> "+Integer.toString(com.companyId));
		}
		return sub;
	}
	

}
