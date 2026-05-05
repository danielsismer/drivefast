package com.drive.fast.api.controller;

import com.drive.fast.api.handler.dto.request.vehicle.CreateVehicleRequest;
import com.drive.fast.api.handler.dto.request.vehicle.UpdateVehicleRequest;
import com.drive.fast.api.handler.dto.response.vehicle.VehicleResponse;
import com.drive.fast.application.facade.vehicle.command.VehicleCommandFacade;
import com.drive.fast.application.facade.vehicle.query.VehicleQueryFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/vehicles")
public class VehicleController {

    private final VehicleCommandFacade command;
    private final VehicleQueryFacade query;

    @PostMapping
    public ResponseEntity<VehicleResponse> create(@RequestBody @Valid CreateVehicleRequest createVehicleRequest) {
        return ResponseEntity
                .status(201)
                .body(command.create(createVehicleRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<VehicleResponse> update(@PathVariable("id") Long id, @RequestBody @Valid UpdateVehicleRequest updateVehicleRequest) {
        return ResponseEntity
                .status(200)
                .body(command.update(id, updateVehicleRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<VehicleResponse> delete(@PathVariable("id") Long id) {
        return ResponseEntity
                .status(200)
                .body(command.delete(id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VehicleResponse> findById(@PathVariable("id") Long id){
        return ResponseEntity
                .status(200)
                .body(query.findById(id));
    }

    @GetMapping
    public ResponseEntity<List<VehicleResponse>> findAll(){
        return ResponseEntity
                .status(200)
                .body(query.findAll());
    }


}
