package com.vehiculo_bbdd.VehiculoDB.controller;


import com.vehiculo_bbdd.VehiculoDB.Entity.Vehiculo;
import com.vehiculo_bbdd.VehiculoDB.repository.VehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/vehiculo")
public class VehiculoController {

    @Autowired
    private VehiculoRepository vehiculoRepository;


    // GET Ver todos los registros de la tabla vehiculo
    @GetMapping("/findAll")
    public List<Vehiculo> findAll() {
        return vehiculoRepository.findAll();
    }

    // POST Salvar un nuevo registro de la tabla vehiculo
    @PostMapping("/save")
    public String save(@RequestBody Vehiculo vehiculo) {
        vehiculoRepository.save(vehiculo);
        return "Vehiculo guardado";
    }

    // PUT Actualizar un registro de la tabla vehiculo
    @PutMapping("/update/{id}")
    public String update(@RequestBody Vehiculo vehiculo, @PathVariable Long id) {
        Vehiculo updateVehiculo = vehiculoRepository.findById(id).get();
        updateVehiculo.setTipo(vehiculo.getTipo());
        updateVehiculo.setMarca(vehiculo.getMarca());
        updateVehiculo.setPotencia(vehiculo.getPotencia());
        updateVehiculo.setFechaCompra(vehiculo.getFechaCompra());
        vehiculoRepository.save(updateVehiculo);
        return "Vehiculo actualizado";
    }

    // DELETE Eliminar un registro de la tabla vehiculo
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        Vehiculo deleteVehiculo = vehiculoRepository.findById(id).get();
        vehiculoRepository.delete(deleteVehiculo);
        return "Vehiculo eliminado";
    }

    // GET Obtener la potencia media según el tipo de vehículo.
    @GetMapping("/potencia-avg")
    public List<Object[]>  findAveragePotenciaByTipo(@RequestParam String tipo) {
        return vehiculoRepository.findAveragePotenciaByTipo(tipo);
    }

    // GET Obtener la potencia máxima según el tipo de vehículo.
    @GetMapping("/potencia-max")
    public List<Object[]>  findMaxPotenciaByTipoVehiculo(@RequestParam String tipo) {
        return vehiculoRepository.findMaxPotenciaByTipo(tipo);
    }

}
