package com.dev.DatabaseDashboardDemo.repositories;

import com.dev.DatabaseDashboardDemo.entity.CompanyRevenue;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier(value = "companyRevenueRepository")
public interface CompanyRevenueRepository extends JpaRepository<CompanyRevenue, Long> {

}
