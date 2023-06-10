package com.promineotech.pet.store.service;

import java.util.NoSuchElementException;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.pet.store.controller.model.PetStoreData;
import com.promineotech.pet.store.dao.PetStoreDao;
import com.promineotech.pet.store.entity.PetStore;

@Service
public class PetStoreService {
	
//	Calls "PetStoreDao"
	@Autowired
	private PetStoreDao petStoreDao;
//  This method saves any new pet stpre that is entered through JSON
	public PetStoreData savePetStore(PetStoreData petStoreData) {
		Long petStoreId = petStoreData.getPetStoreId();
		PetStore petStore  = findOrCreatePetStore(petStoreId);
		
		copyPetStoreFields(petStore, petStoreData);
		return new PetStoreData(petStoreDao.save(petStore));
	}
	
//	This method copies the fields from the petStoreData object to the petStore object.
//	Each field of the petStore object is set with the corresponding field from the petStoreData object.
	private void copyPetStoreFields(PetStore petStore, PetStoreData petStoreData) {
		petStore.setPetStoreId(petStoreData.getPetStoreId());
		petStore.setPetStoreName(petStoreData.getPetStoreName());
		petStore.setPetStoreCity(petStoreData.getPetStoreCity());
		petStore.setPetStoreState(petStoreData.getPetStoreState());
		petStore.setPetStoreZip(petStoreData.getPetStoreZip());
		petStore.setPetStorePhone(petStoreData.getPetStorePhone());
	}
//	This method finds a pet store by its ID using the petStoreDao.
//	If a pet store with the given ID is found, it is returned.
//	If no pet store is found, it throws a NoSuchElementException with an error message.
	private PetStore findPetStoreById(Long petStoreId) {
		return petStoreDao.findById(petStoreId)
				.orElseThrow(() -> new NoSuchElementException("Pet store with ID=" + petStoreId + " was not found."));
	}
//	This method either finds an existing pet store by its ID using the findPetStoreById method, or creates a new PetStore object if the petStoreId is null.
//	If the petStoreId is null, it creates a new PetStore instance.
//	If the petStoreId is not null, it calls the findPetStoreById method to get the corresponding PetStore instance.
//	The method returns the obtained PetStore object.
	private PetStore findOrCreatePetStore(Long petStoreId) {
		PetStore petStore;
		
		if(Objects.isNull(petStoreId)) {
			petStore = new PetStore();
		}
		else {
			petStore = findPetStoreById(petStoreId);
		}
		return petStore;
	}
}
