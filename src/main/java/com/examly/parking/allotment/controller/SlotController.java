package com.examly.parking.allotment.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.examly.parking.allotment.dao.LocationRepository;
import com.examly.parking.allotment.dao.SlotRepository;
import com.examly.parking.allotment.error.ResourceNotFoundException;
import com.examly.parking.allotment.model.Location;
import com.examly.parking.allotment.model.Slot;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/slot")
public class SlotController {
	
	@Autowired
	private SlotRepository slotRepository;
	@Autowired
	private LocationRepository locationRepository;
	
	@GetMapping("/{id}")
    public ResponseEntity<Slot> getUserById(@PathVariable(value = "id") String id) 
        throws ResourceNotFoundException { //The @PathVariable annotation binds the URI template variables
        Slot slot = slotRepository.findById(id)
          .orElseThrow(() -> new ResourceNotFoundException("No slot in this id :: " + id));
        return ResponseEntity.ok().body(slot);
    }
	
	@PostMapping("/{lid}")
	  public Slot addSlot(@PathVariable(value = "lid") String lid) {
		 Location location = locationRepository.findById(lid)
		          .orElseThrow(() -> new ResourceNotFoundException("No location in this id :: " + lid));
		Slot slot = new Slot();
		 slot.setid(location.getId());
		 slot.setLocation(location);
        return slotRepository.save(slot);
    }
	
	
    @PutMapping("/{id}")
    public ResponseEntity<Slot> updateLocation(@PathVariable(value = "id") String id,
         @Valid @RequestBody Slot slot) throws ResourceNotFoundException {
    	
    	Slot newSlot = slotRepository.findById(id)
        		.orElseThrow(() -> new ResourceNotFoundException("No Slot in this id :: " + id));


    	newSlot.setSlot1(slot.getSlot1());
    	newSlot.setSlot2(slot.getSlot2());
    	newSlot.setSlot3(slot.getSlot3());
    	newSlot.setSlot4(slot.getSlot4());
    	newSlot.setSlot5(slot.getSlot5());
    	newSlot.setSlot6(slot.getSlot6());
    	newSlot.setSlot7(slot.getSlot7());
    	newSlot.setSlot8(slot.getSlot8());
    	newSlot.setSlot9(slot.getSlot9());
    	newSlot.setSlot10(slot.getSlot10());

    	
    	final Slot updatedSlot = slotRepository.save(newSlot);
        return ResponseEntity.ok(updatedSlot);
    }
    
    

}
