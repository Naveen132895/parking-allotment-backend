package com.examly.parking.allotment.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.parking.allotment.dao.LocationRepository;
import com.examly.parking.allotment.dao.SlotRepository;
import com.examly.parking.allotment.dao.UserRepository;
import com.examly.parking.allotment.error.ResourceNotFoundException;
import com.examly.parking.allotment.model.Location;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/location")
public class LocationController {
	@Autowired
	private LocationRepository locationRepository;
	
	
	@GetMapping("/")
	public List<Location>getAllLocation(){
		return locationRepository.findAll();
	}
    
	
	@GetMapping("/{id}")
    public ResponseEntity<Location> getUserById(@PathVariable(value = "id") String id) 
        throws ResourceNotFoundException { //The @PathVariable annotation binds the URI template variables
        Location location = locationRepository.findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("No location in this id :: " + id));
        return ResponseEntity.ok().body(location);
    }
    
    @PostMapping("/")
    public Location addLocation(@Valid @RequestBody Location location) {
        return locationRepository.save(location);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Location> updateLocation(@PathVariable(value = "id") String id,
         @Valid @RequestBody Location location) throws ResourceNotFoundException {
    	Location newLocation = locationRepository.findById(id)
        		.orElseThrow(() -> new ResourceNotFoundException("No location in this id :: " + id));
    	
    	newLocation.setLocationName(location.getLocationName());
    	newLocation.setTotalSlot(location.getTotalSlot());
        newLocation.setChargePerSlot(location.getChargePerSlot());
    	
    	final Location updatedLocation = locationRepository.save(newLocation);
        return ResponseEntity.ok(updatedLocation);
    }

	@DeleteMapping("/{id}")
	public Map<String, Boolean> removeLocation(@PathVariable(value = "id") String id)
			throws ResourceNotFoundException {
		Location location = locationRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("No location in this id :: " + id));

		locationRepository.delete(location);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}
}
