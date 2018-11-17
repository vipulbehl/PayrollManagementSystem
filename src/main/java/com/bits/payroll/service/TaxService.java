package com.bits.payroll.service; 
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bits.payroll.model.Employee;
import com.bits.payroll.model.Salary;
import com.bits.payroll.repository.EmployeeRepository;
import com.bits.payroll.repository.SalaryRepository;
@Service
public class TaxService {
	
	
	@Autowired
	SalaryRepository repository;
	@Autowired
	EmployeeRepository empRepository;

	public List<Salary> getYearlySalary(Employee employee, int year) {
		return  repository.getYearlySalary(employee,year);
		
	}
	
	/*public float getTax(List<Salary> salary, int year)
	{
		
		Employee employee = service.getEmployeeById((Long)model.get("employeeId"));
		salary=getSalaryByYear() 
		
		float annualSalary = 0,tax=0;
		for(Salary e : salary)
		{		
			annualSalary+= (e.getBasic() + e.getDa() +e.getHra() + e.getTa() - e.getPf());
		}
		System.out.println("Annaul salary "+annualSalary);
		 
		for(int i =0;i<=)
		
		
	}*/

	public Employee getEmployeeById(Long id) {
		return empRepository.getEmployeeById(id);
	}
	
}
