package com.example.gtics231lab520200334.repository;


import com.example.gtics231lab520200334.entity.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JobsRepository extends JpaRepository<Jobs,String> {


}
