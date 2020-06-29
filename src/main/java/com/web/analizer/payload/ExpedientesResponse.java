package com.web.analizer.payload;

import java.util.List;
import com.web.analizer.model.Expediente;

public class ExpedientesResponse {

	private List<Expediente> expedientes;
	private String message;
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ExpedientesResponse() {

    }
	public ExpedientesResponse(List<Expediente> expedientes, String message) {
        this.expedientes = expedientes;
    }
	
	public List<Expediente> getExpedientes() {
		return expedientes;
	}
	public void setExpedientes(List<Expediente> expedientes) {
		this.expedientes = expedientes;
	}
}
