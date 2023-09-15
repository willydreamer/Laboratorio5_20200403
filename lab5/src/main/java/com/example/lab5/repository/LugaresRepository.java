package com.example.lab5.repository;

import com.example.lab5.entity.Lugar;
import com.example.lab5.entity.Mascota;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LugaresRepository extends JpaRepository<Lugar,Integer> {

}
