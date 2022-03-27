package com.dev.DatabaseDashboardDemo.repositories;

import com.dev.DatabaseDashboardDemo.entity.EmployeeInformation;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier(value = "employeeInformationRepository")
public interface EmployeeInformationRepository extends JpaRepository<EmployeeInformation, Long> {

    //So Jpa repository methods require the format findBy%columnName%, below automatically creates the query
    //logic for the database
    EmployeeInformation findByPk(String pk);
}
