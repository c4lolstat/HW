package com.epam.training;

import java.util.Date;
import java.util.List;

public class Planet {

	private String name;

	private Date dateOfDiscovery;

	private List<Moon> moons;

	public Planet(String name, Date dateOfDiscovery, List<Moon> moons) {
		this.name = name;
		this.dateOfDiscovery = dateOfDiscovery;
		this.moons = moons;
	}

	public String getName() {
		return name;
	}

	public Date getDateOfDiscovery() {
		return dateOfDiscovery;
	}
	
	public List<Moon> getMoons() {
		return moons;
	}


}
