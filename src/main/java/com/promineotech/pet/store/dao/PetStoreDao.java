package com.promineotech.pet.store.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.promineotech.pet.store.entity.PetStore;

public interface PetStoreDao extends JpaRepository<PetStore, Long> {

}
