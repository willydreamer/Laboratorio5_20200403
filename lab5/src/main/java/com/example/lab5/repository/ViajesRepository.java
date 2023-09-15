package com.example.lab5.repository;

import com.example.lab5.entity.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViajesRepository extends JpaRepository<Viaje,Integer> {

}
