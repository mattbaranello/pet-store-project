package com.promineotech.pet.store.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.pet.store.controller.model.PetStoreData;
import com.promineotech.pet.store.service.PetStoreService;

import lombok.extern.slf4j.Slf4j;

//@RestController indicates that this class is a controller for handling RESTful API requests.
//@RequestMapping("/pet_store") specifies that the base URL for this controller is "/pet_store".
//@Slf4j is used for logging.
@RestController
@RequestMapping("/pet_store") 
@Slf4j
public class PetStoreController {
	
	@Autowired
	private PetStoreService petStoreService;
//	@PostMapping("/pet_store") indicates that this method handles HTTP POST requests to the "/pet_store" endpoint.
//	@ResponseStatus(code = HttpStatus.CREATED) sets the HTTP response status code to 201 (Created) for a successful request.
//	@RequestBody indicates that the PetStoreData object will be passed in the request body.
//	This method creates a new pet store by saving the provided petStoreData using the petStoreService, and returns the saved data.
	@PostMapping("/pet_store")
	@ResponseStatus(code = HttpStatus.CREATED)
	public PetStoreData createPetStore(@RequestBody PetStoreData petStoreData) {
		log.info("Saving pet store {}", petStoreData);
		return petStoreService.savePetStore(petStoreData);
	}
//	@PutMapping("/pet_store/{petStoreId}") indicates that this method handles HTTP PUT requests to the "/pet_store/{petStoreId}" endpoint.
//	@PathVariable Long petStoreId indicates that the petStoreId value will be extracted from the URL path.
//	This method updates an existing pet store with the specified ID by setting the ID on the provided petStoreData object and saving it using the petStoreService. 
//	The updated data is then returned.
	@PutMapping("/pet_store/{petStoreId}")
	public PetStoreData updatePetStore(@PathVariable Long petStoreId, 
			@RequestBody PetStoreData petStoreData) {
		log.info("Updating pet store with ID=" + petStoreId);
		petStoreData.setPetStoreId(petStoreId);
		
		return petStoreService.savePetStore(petStoreData);
	}
}
