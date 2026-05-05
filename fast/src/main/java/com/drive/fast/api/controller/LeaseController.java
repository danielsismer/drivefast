package com.drive.fast.api.controller;

import com.drive.fast.api.handler.dto.request.lease.CreateLeaseRequest;
import com.drive.fast.api.handler.dto.request.lease.UpdateLeaseRequest;
import com.drive.fast.api.handler.dto.response.lease.LeaseResponse;
import com.drive.fast.application.facade.lease.command.LeaseCommandFacade;
import com.drive.fast.application.facade.lease.query.LeaseQueryFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/lease")
public class LeaseController {

    private final LeaseCommandFacade command;
    private final LeaseQueryFacade query;

    @PostMapping
    public ResponseEntity<LeaseResponse> save(@RequestBody @Valid CreateLeaseRequest request){
        return ResponseEntity
                .status(201)
                .body(command.save(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeaseResponse> update(@PathVariable("id") Long id, @RequestBody UpdateLeaseRequest request){
        return ResponseEntity
                .status(200)
                .body(command.update(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<LeaseResponse> delete(@PathVariable("id") Long id){
        return ResponseEntity
                .status(200)
                .body(command.delete(id));
    }

    @GetMapping
    public ResponseEntity<List<LeaseResponse>> findAll(){
        return ResponseEntity
                .status(200)
                .body(query.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeaseResponse> findById(@PathVariable("id") Long id){
        return ResponseEntity
                .status(200)
                .body(query.findById(id));
    }
}
