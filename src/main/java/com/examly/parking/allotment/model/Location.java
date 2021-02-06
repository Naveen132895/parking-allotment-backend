package com.examly.parking.allotment.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="location")
public class Location {
	
	private String id;
	private String locationName;
	private int totalSlot;
	private int chargePerSlot;
	
	public Location(String id, String locationName, int totalSlot, int chargePerSlot) {
		super();
		this.id = id;
		this.locationName = locationName;
		this.totalSlot = totalSlot;
		this.chargePerSlot = chargePerSlot;
		
	}

	public Location() {}
	
	@Id
	@Column(name="id", nullable=false)
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Column(name="locationName", nullable=false)
	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	@Column(name="totalSlot", nullable=false)
	public int getTotalSlot() {
		return totalSlot;
	}

	public void setTotalSlot(int totalSlot) {
		this.totalSlot = totalSlot;
	}
	
	@Column(name="amount", nullable=false)
	public int getChargePerSlot() {
		return chargePerSlot;
	}

	public void setChargePerSlot(int chargePerSlot) {
		this.chargePerSlot = chargePerSlot;
	}
	

	@Override
	public String toString() {
		return "Location [id=" + id + ", locationName=" + locationName + ", totalSlot=" + totalSlot + ", chargePerSlot="
				+ chargePerSlot + "]";
	}


		
}
