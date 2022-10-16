package com.shipment.details.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.shipment.details.model.Loading_Details;

@Repository
public interface Loading_Details_Repository extends JpaRepository<Loading_Details,Integer>{

	@Query(value="select * from loading_details where shipper_id=?1",nativeQuery=true)
	public Loading_Details findByShipperId(String shipperId);
	
	@Query(value="select * from loading_details where load_id=?1",nativeQuery=true)
	public Loading_Details findByLoadId(int loadId);
	
	@Query(value="update loading_details set loading_point=?1,unloading_point=?2,product_type=?3,truck_type=?4,no_of_trucks=?5,weight=?6,comment=?7,date=?8 where load_id=?9",nativeQuery=true)
	@Modifying
	@Transactional
	public void updateData(String loadingPoint,String unloadingPoint,String productType,String truckType,String nooftrucks,String weight,String comment,String date,int loadId);

	@Query(value="delete from loading_details where load_id=?1",nativeQuery=true)
	@Modifying
	@Transactional
	public void deleteData(int loadId);
}
