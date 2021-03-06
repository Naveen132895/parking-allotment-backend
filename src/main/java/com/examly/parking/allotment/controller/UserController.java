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

import com.examly.parking.allotment.dao.UserRepository;
import com.examly.parking.allotment.error.ResourceNotFoundException;
import com.examly.parking.allotment.model.User;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {

		@Autowired
		private UserRepository userRepository;
		
		@GetMapping("/")
		public List<User>getAllUser(){
			return userRepository.findAll();
		}
        
		
		@GetMapping("/{id}")
	    public User getUserById(@PathVariable(value = "id") String userId) 
	        throws ResourceNotFoundException { //The @PathVariable annotation binds the URI template variables
	        User user = userRepository.findById(userId)
	          .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
	        return user;
	    }
		
	    
	    @PostMapping("/")
	    public User addUser(@Valid @RequestBody User user) {
	        return userRepository.save(user);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<User> updateUser(@PathVariable(value = "id") String userId,
	         @Valid @RequestBody User newUser) throws ResourceNotFoundException {
	        User user = userRepository.findById(userId)
	        		.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

	        user.setEmail(newUser.getEmail());
	        user.setFirstName(newUser.getFirstName());
	        user.setLastName(newUser.getLastName());
	        user.setPassword(newUser.getPassword());
	        user.setRole(newUser.getRole());
	        
	        final User updatedUser = userRepository.save(user);
	        return ResponseEntity.ok(updatedUser);
	    }

		@DeleteMapping("/{id}")
		public Map<String, Boolean> removeUser(@PathVariable(value = "id") String userId)
				throws ResourceNotFoundException {
			User user = userRepository.findById(userId)
					.orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));

			userRepository.delete(user);
			Map<String, Boolean> response = new HashMap<>();
			response.put("deleted", Boolean.TRUE);
			return response;
		}
	
}
