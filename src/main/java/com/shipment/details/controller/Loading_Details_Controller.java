package com.shipment.details.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.shipment.details.model.Loading_Details;
import com.shipment.details.service.Loading_Details_Service;

@RestController
public class Loading_Details_Controller {

	@Autowired
	public Loading_Details_Service loading_service;
	
	@PostMapping("/load")
	public ResponseEntity<?> saveData(@RequestBody Loading_Details loading_details){
	Loading_Details returnData = loading_service.saveData(loading_details);
	if(returnData!=null) {
		return ResponseEntity.ok("loads details added successfully");

	}
	else {
		return ResponseEntity.badRequest().body("Something went wrong");
	}
	}
	
	@GetMapping("/load")
	public Loading_Details findByShipperId(@RequestParam String shipperId) {
		return loading_service.findByShipperId(shipperId);
	}
	
	@GetMapping("/load/{loadId}")
	public Loading_Details findByLoadId(@PathVariable int loadId) {
		return loading_service.findByLoadId(loadId);
	}
	
	@PutMapping("/load/{loadId}")
	public ResponseEntity<?> updateByLoadId(@PathVariable int loadId,@RequestBody Loading_Details loading_Details) {
		 loading_service.updateByLoadId(loadId,loading_Details);
			return ResponseEntity.ok("loads details updated successfully");

	}
	
	@DeleteMapping("/load/{loadId}")
	public ResponseEntity<?> deleteByLoadId(@PathVariable int loadId) {
		 loading_service.deleteData(loadId);
			return ResponseEntity.ok("loads details deleted successfully");

	}
}
