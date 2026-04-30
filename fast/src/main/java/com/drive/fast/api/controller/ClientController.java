package com.drive.fast.api.controller;

import com.drive.fast.api.dto.request.CreateClientRequest;
import com.drive.fast.api.dto.request.UpdateClientRequest;
import com.drive.fast.api.dto.response.ClientResponse;
import com.drive.fast.application.facade.client.command.ClientCommandFacade;

import com.drive.fast.application.facade.client.query.ClientQueryFacade;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/clients")
@RequiredArgsConstructor
public class ClientController {

    private final ClientQueryFacade query;
    private final ClientCommandFacade command;

    @PostMapping
    public ResponseEntity<ClientResponse> save(@RequestBody @Valid CreateClientRequest clientRequest){
        return ResponseEntity
                .status(201)
                .body(command.create(clientRequest));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClientResponse> update(@PathVariable("id") Long id, @RequestBody @Valid UpdateClientRequest updateClientRequest){
        return ResponseEntity
                .status(200)
                .body(command.update(id, updateClientRequest));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ClientResponse> delete(@PathVariable("id") Long id){
        return ResponseEntity
                .status(200)
                .body(command.delete(id));
    }

    @GetMapping
    public ResponseEntity<List<ClientResponse>> findAll(){
        return ResponseEntity
                .status(200)
                .body(query.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClientResponse> findById(@PathVariable("id") Long id){
        return ResponseEntity
                .status(200)
                .body(query.getById(id));
    }

}
