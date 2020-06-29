package com.web.analizer.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
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

//Request Response imports
import com.web.analizer.payload.ApiResponse;
import com.web.analizer.payload.ExpedienteRequest;
import com.web.analizer.payload.ExpedientesRequest;
import com.web.analizer.payload.ExpedientesResponse;
import com.web.analizer.payload.StatsResponse;

@RestController
@RequestMapping("/")
public class MutacionController {
	
	@Autowired
    ExpedienteRepository expedienteRepository;
	
	@Autowired
    Mutation mutationService;

    @PostMapping("/mutation")
    public ResponseEntity<?> registerHuman(@RequestBody ExpedienteRequest expedienteRequest) {
    // Creating new Expediente
	
    ApiResponse response = new ApiResponse(false,"");
    
    //Mutation mutation = new Mutation(expedienteRequest.getAdn());
    //Boolean result = mutation.GetResult();
    Boolean result = mutationService.GetResult(expedienteRequest.getAdn());
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
    
    @GetMapping("/mutation")
    public ResponseEntity<?> getExpedientes() {
    	List<Expediente> expedientes;
    	
    	expedientes = expedienteRepository.findAll();
    	
    	ExpedientesResponse response = new ExpedientesResponse(expedientes,"message");
    	
        return ResponseEntity.ok(response);
    	}
    @PostMapping("/mutationby")
    public ResponseEntity<?> getExpedientes(@RequestBody ExpedientesRequest expedientesRequest) {
    	List<Expediente> expedientes;
    	
    	if(expedientesRequest.getHasMutation() != null) {
    		Boolean hasMutation = expedientesRequest.getHasMutation();
        	expedientes = expedienteRepository.findByResult(hasMutation);
        	
        	ExpedientesResponse response = new ExpedientesResponse(expedientes,"message");
        	
            return ResponseEntity.ok(response);
        }
        else {
        	return ResponseEntity.ok(new ApiResponse(false,"error"));
        }
    	
    }
    @GetMapping("/stats")
    public ResponseEntity<?> getStats() {
    	int has = mutationService.getCountHas();
    	int hasnt = mutationService.getCountHasnt();
    	//int total = mutationService.getCountAll();
    	int ratio = has / hasnt;
    	
    	StatsResponse response = new StatsResponse(has,hasnt,ratio,"success");
    	
    	return ResponseEntity.ok(response);
    }
    
}