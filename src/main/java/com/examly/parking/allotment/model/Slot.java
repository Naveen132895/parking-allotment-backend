package com.examly.parking.allotment.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="slot")
public class Slot {
	
	private String id;
	private Long slot1;
	private Long slot2;
	private Long slot3;
	private Long slot4;
	private Long slot5;
	private Long slot6;
	private Long slot7;
	private Long slot8;
	private Long slot9;
	private Long slot10;
	private Location location;
	
	public Slot(String id, Long slot1, Long slot2, Long slot3, Long slot4, Long slot5, Long slot6,
			Long slot7, Long slot8, Long slot9, Long slot10, Location location) {
		super();
		this.id = id;
		this.slot1 = slot1;
		this.slot2 = slot2;
		this.slot3 = slot3;
		this.slot4 = slot4;
		this.slot5 = slot5;
		this.slot6 = slot6;
		this.slot7 = slot7;
		this.slot8 = slot8;
		this.slot9 = slot9;
		this.slot10 = slot10;
		this.location = location;
	}
	
	public Slot() {}

	@Id
	@Column(name="id")
	public String getid() {
		return id;
	}

	public void setid(String id) {
		this.id = id;
	}
	
	@Column(name="slot1", nullable=true)
	public Long getSlot1() {
		return slot1;
	}

	public void setSlot1(Long slot1) {
		this.slot1 = slot1;
	}

	@Column(name="slot2", nullable=true)
	public Long getSlot2() {
		return slot2;
	}

	public void setSlot2(Long slot2) {
		this.slot2 = slot2;
	}

	@Column(name="slot3", nullable=true)
	public Long getSlot3() {
		return slot3;
	}

	public void setSlot3(Long slot3) {
		this.slot3 = slot3;
	}

	@Column(name="slot4", nullable=true)
	public Long getSlot4() {
		return slot4;
	}

	public void setSlot4(Long slot4) {
		this.slot4 = slot4;
	}

	@Column(name="slot5", nullable=true)
	public Long getSlot5() {
		return slot5;
	}

	public void setSlot5(Long slot5) {
		this.slot5 = slot5;
	}

	@Column(name="slot6", nullable=true)
	public Long getSlot6() {
		return slot6;
	}

	public void setSlot6(Long slot6) {
		this.slot6 = slot6;
	}

	@Column(name="slot7", nullable=true)
	public Long getSlot7() {
		return slot7;
	}

	public void setSlot7(Long slot7) {
		this.slot7 = slot7;
	}

	@Column(name="slot8", nullable=true)
	public Long getSlot8() {
		return slot8;
	}

	public void setSlot8(Long slot8) {
		this.slot8 = slot8;
	}

	@Column(name="slot9", nullable=true)
	public Long getSlot9() {
		return slot9;
	}

	public void setSlot9(Long slot9) {
		this.slot9 = slot9;
	}

	@Column(name="slot10", nullable=true)
	public Long getSlot10() {
		return slot10;
	}

	public void setSlot10(Long slot10) {
		this.slot10 = slot10;
	}

	@OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="id", referencedColumnName = "id")
	public Location getLocation() {
		return location;
	}

	public void setLocation(Location location) {
		this.location = location;
	}

	@Override
	public String toString() {
		return "Slot [id=" + id + ", slot1=" + slot1 + ", slot2=" + slot2 + ", slot3=" + slot3 + ", slot4=" + slot4
				+ ", slot5=" + slot5 + ", slot6=" + slot6 + ", slot7=" + slot7 + ", slot8=" + slot8 + ", slot9=" + slot9
				+ ", slot10=" + slot10 + ", location=" + location + "]";
	}
	
	


	
}
