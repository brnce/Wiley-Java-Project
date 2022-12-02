package com.bernice.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.bernice.entity.DVD;

@Repository
public interface DvdDao extends JpaRepository<DVD, Integer> {

}