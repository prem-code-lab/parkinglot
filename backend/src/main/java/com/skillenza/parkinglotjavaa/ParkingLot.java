package com.skillenza.parkinglotjavaa;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "parkinglots")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"created_at", "updated_at"},
        allowGetters = true)
public class ParkingLot {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
	

	@Column
	@CreatedDate
    private Date created_at;
	
	@NotNull(message = "Please enter lot id")
	@Column
    private int lot;
	
	@Column
    private int parking_amount;
	
	@NotNull(message = "Please enter parking duration")
	@Column
    private int parking_duration;
	

	@Column
	@LastModifiedDate
    private Date updated_at;
	
	@NotNull(message = "Please enter vehicle number")
	@Column
    private int vehicle_number;
	
	public int getId() {
		return id;
	}
	public Date getCreated_at() {
		return new Date();
	}
	public int getLot() {
		return lot;
	}
	public int getParking_amount() {
		return parking_amount;
	}
	public int getParking_duration() {
		return parking_duration;
	}
	public Date getUpdated_at() {
		return updated_at;
	}
	public int getVehicle_number() {
		return vehicle_number;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}
	public void setLot(int lot) {
		this.lot = lot;
	}
	public void setParking_amount(int parking_amount) {
		this.parking_amount = parking_amount;
	}
	public void setParking_duration(int parking_duration) {
		this.parking_duration = parking_duration;
	}
	public void setUpdated_at(Date updated_at) {
		this.updated_at = updated_at;
	}
	public void setVehicle_number(int vehicle_number) {
		this.vehicle_number = vehicle_number;
	}
    
}
