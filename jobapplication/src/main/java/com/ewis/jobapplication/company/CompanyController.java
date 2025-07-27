package com.ewis.jobapplication.company;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    private CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping
    public List<Company> getAllCompanies(){
        return companyService.getAllCompanies();
    }

    @PutMapping ("/{id}")
    public ResponseEntity<String> updateCompany(@RequestBody Company company, @PathVariable Long id){
        companyService.updateCompany(company, id);
        return new ResponseEntity<>("Company Updated Successfully", HttpStatus.OK);
    }
}
