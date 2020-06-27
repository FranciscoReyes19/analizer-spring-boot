package com.web.analizer.controller;

import java.net.URI;
import java.sql.SQLException;
import java.util.Collections;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.analizer.exception.AppException;
import com.web.analizer.model.Expediente;
import com.web.analizer.repository.ExpedienteRepository;
import com.web.analizer.repository.UserRepository;

//import java.util.List;
//import java.util.Arrays;
import com.web.analizer.service.Mutation;

import com.web.analizer.payload.ApiResponse;
import com.web.analizer.payload.ExpedienteRequest;

@RestController
@RequestMapping("/")
public class MutacionController {
	
	@Autowired
    ExpedienteRepository expedienteRepository;

    @PostMapping("/mutation")
    public ResponseEntity<?> registerHuman(@RequestBody ExpedienteRequest expedienteRequest) {
    // Creating new Expediente
	/*
    	if(expedienteRepository.findByName(expedienteRequest.getName())) {
        return new ResponseEntity(new ApiResponse(false, "Name is already taken!"),
                HttpStatus.BAD_REQUEST);
    }*/
    ApiResponse response = new ApiResponse(false,"");
    Mutation mutation = new Mutation(expedienteRequest.getAdn());
    
    Boolean result = mutation.GetResult();
	String r = "";
    if(result) {
		r = "Has mutation";
	}
    else {
    	r= "Hasn´t mutation";
    }
    Expediente expediente = new Expediente(expedienteRequest.getName(), expedienteRequest.getAdn(),result);

	try {
		expedienteRepository.save(expediente);
		response.setMessage(r);
		response.setSuccess(true);
		}
		catch(Exception e) {
		  response.setMessage(e.toString()+"");
		  response.setSuccess(false);
		}
		
    
    
    return ResponseEntity.ok(response);
    }
}