package com.serbanscorteanu.classes;

import java.util.HashMap;
import java.util.Map;

public class Location {
	private final int locationId;
	private final String description;
	private final Map<String, Integer> exits;
	
	
	public Location(int locationId, String description) {
		this.locationId = locationId;
		this.description = description;
		this.exits = new HashMap<String, Integer>();
		this.exits.put("Q", 0);	// put the Q button in each map of exits instead of repeating code
		
	}

	public void addExit(String direction, int location) {
		exits.put(direction, location);
	}
	
	public int getLocationId() {
		return locationId;
	}

	public String getDescription() {
		return description;
	}

	public Map<String, Integer> getExits() {
		return new HashMap<String, Integer>(exits);	
		// although this is a shallow copy
			// it is really useful
				// because we keep the old mapping/references
					// so if we remove or add elements to the new map
						// the old map/reference "exits" will still point to all the old elements
	}
	
	
}
















