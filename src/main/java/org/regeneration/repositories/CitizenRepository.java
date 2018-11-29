package org.regeneration.repositories;


import org.regeneration.models.Citizen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CitizenRepository extends JpaRepository<Citizen, Long> {

    Citizen findByEmail(String email);
    Citizen findByPhone(String phone);
    Citizen findBySsn(String ssn);

}