package com.dev.DatabaseDashboardDemo.repositories;

import com.dev.DatabaseDashboardDemo.entity.Credentials;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
@Qualifier(value = "credentialsRepository")
public interface CredentialsRepository extends JpaRepository<Credentials, Long> {
}
