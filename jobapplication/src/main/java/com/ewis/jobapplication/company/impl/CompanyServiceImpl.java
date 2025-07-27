package com.ewis.jobapplication.company.impl;

import com.ewis.jobapplication.company.Company;
import com.ewis.jobapplication.company.CompanyRepository;
import com.ewis.jobapplication.company.CompanyService;

import java.util.List;

public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<Company> getAllCompanies(){
        return companyRepository.findAll();
    }
}
