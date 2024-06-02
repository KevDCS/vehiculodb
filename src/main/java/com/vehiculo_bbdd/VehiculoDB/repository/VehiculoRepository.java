package com.vehiculo_bbdd.VehiculoDB.repository;

import com.vehiculo_bbdd.VehiculoDB.Entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Long> {

    @Query(value = "SELECT v.tipoVehiculo, ROUND(AVG(v.potencia), 0) as potencia FROM Vehiculo v GROUP BY v.tipoVehiculo", nativeQuery = true)
    List<Object[]> findAveragePotenciaByTipo(@Param("tipo") String tipo);

    @Query(value = "SELECT v.tipoVehiculo, MAX(v.potencia) FROM Vehiculo v GROUP BY v.tipoVehiculo", nativeQuery = true)
    List<Object[]>  findMaxPotenciaByTipo(@Param("tipo") String tipo);

}
