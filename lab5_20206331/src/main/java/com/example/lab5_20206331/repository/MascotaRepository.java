package com.example.lab5_20206331.repository;

import com.example.lab5_20206331.entity.Mascota;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Integer> {


    @Transactional
    @Modifying
    @Query(nativeQuery = true, value = "UPDATE mascotas SET nombre_mascota = ?1,Vacunado=?2,Desparasitado=?3 WHERE ShipperID = ?2")
    void actualizarMascota(String nombre, String vacunado, String desparasitado);
}
