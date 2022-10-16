package com.shipment.details.service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shipment.details.model.Loading_Details;
import com.shipment.details.repository.Loading_Details_Repository;

@Service
public class Loading_Details_Service {

	@Autowired
	public Loading_Details_Repository loading_repo;
	
	public Loading_Details saveData(Loading_Details loading_details) {
		loading_details.setShipperId(UUID.randomUUID().toString());
		return loading_repo.save(loading_details);
	}
	
	public Loading_Details findByShipperId(String shipperId) {
		
		return loading_repo.findByShipperId(shipperId);
	}
	
	public Loading_Details findByLoadId(int loadId) {
		
		return loading_repo.findByLoadId(loadId);
	}
	
		public void updateByLoadId(int loadId,Loading_Details loading_Details) {
		
		loading_repo.updateData(loading_Details.getLoadingPoint(),loading_Details.getUnloadingPoint(),loading_Details.getProductType(),loading_Details.getTruckType(),loading_Details.getNoOfTrucks(),loading_Details.getWeight(),loading_Details.getComment(),loading_Details.getDate(),loadId);
			
	}
		
	public void deleteData(int loadId) {
		loading_repo.deleteData(loadId);
	}
}
