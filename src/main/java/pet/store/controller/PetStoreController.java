package pet.store.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pet.store.controller.model.PetStoreData;
import pet.store.controller.model.PetStoreData.PetStoreEmployee;
import pet.store.service.PetStoreService;

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
	
	//This method handles HTTP POST requests to the "employee" endpoint.
	//@PathVariable Long petStoreId indicates that the petStoreId value will be extracted from the URL path.
	//The method add an employee to an existing pet store with the specified ID provided.
	@PostMapping("/pet_store/{petStoreId}/employee")
	public PetStoreEmployee addEmployee(@PathVariable Long petStoreId, 
			@RequestBody PetStoreEmployee petStoreEmployee) {
		log.info("Employee added to pet store with ID=" + petStoreId);
		return petStoreService.saveEmployee(petStoreId, petStoreEmployee);
	
	}
	
	@GetMapping("/pet_store")
	public List<PetStoreData> retrieveAllPetStores() {
		return petStoreService.retrieveAllPetStores();
	}
	
	@GetMapping("/pet_store/{petStoreId}")
	public PetStoreData retrievePetStoreById(@PathVariable Long petStoreId) {
		log.info("Retrieving pet store with ID={}", petStoreId);
		
		return petStoreService.retrievePetStoreById(petStoreId);
	}
	
	@DeleteMapping("/pet_store/{petStoreId}")
    public Map<String, String> deletePetStoreById(@PathVariable Long petStoreId) {
		log.info("Deleting pet store with ID{}", petStoreId);
		
		petStoreService.deletePetStoreById(petStoreId);
		
		return Map.of("message", "Deletion of pet store with ID=" + petStoreId + " was successful.");
    }
}
