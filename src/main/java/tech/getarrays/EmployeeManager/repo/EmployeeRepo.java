package tech.getarrays.EmployeeManager.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tech.getarrays.EmployeeManager.EmployeeModel.Employee;

public interface EmployeeRepo extends JpaRepository<Employee,Long>{

    void deleteEmployeeById(Long id);

    Optional<Employee> findEmployeeById(Long id);

}
