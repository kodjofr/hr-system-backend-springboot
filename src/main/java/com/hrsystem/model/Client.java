package com.hrsystem.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="client")
public class Client {
	
	public enum Clients {
		VIRCADE,
		V_ART,
		VIRTUAL_BUSINESS,
		V_BOOKS,
		ONLINE_OASIS,
		VIRTUE_MART,
		DIGITAL_DINERS,
		VIRTUAL_VISION,
		VIRTUAL_SPA

	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private Clients name;
	
	private String country;
	private int networth;
	

}

