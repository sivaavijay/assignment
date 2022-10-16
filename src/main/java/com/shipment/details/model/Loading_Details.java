package com.shipment.details.model;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Data
public class Loading_Details {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int loadId;
	
	public String loadingPoint;
	
	public String unloadingPoint;
	
	public String productType;
	
	public String truckType;
	
	public String noOfTrucks;
	
	public String weight;
	
	public String comment;
	
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "org.hibernate.id.UUIDGenerator")
	public String shipperId;
	
	public String Date;
	
}
