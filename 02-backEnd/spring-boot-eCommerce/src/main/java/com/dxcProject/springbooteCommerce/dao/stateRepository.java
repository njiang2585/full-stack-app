package com.dxcProject.springbooteCommerce.dao;

import com.dxcProject.springbooteCommerce.entity.state;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin("http://localhost:4200")
@RepositoryRestResource
public interface stateRepository extends JpaRepository<state, Integer> {

    List<state> findByCountryCode(@Param("code") String code);

}