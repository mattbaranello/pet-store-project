package com.promineotech.pet.store.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

//The code defines a Java class named "PetStore" with the annotation "@Entity",
//indicating that it is a persistent entity in a database.

//The class uses the "@Data" annotation, which generates boilerplate code for
//getters, setters, equals, hashCode, and toString methods.
@Entity
@Data
public class PetStore {
	// The class has a private field named "petStoreId" of type Long, which represents
	// the unique identifier for the pet store.
	
	// The field "petStoreId" is annotated with "@Id", indicating that it is the primary key
	// for the entity.

	// The field "petStoreId" is also annotated with "@GeneratedValue", specifying that
	// the value of the identifier will be generated automatically.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long petStoreId;
	
	//These private fields represent different columns that will be
	//added to the "pet_store" table with their respected data types.
	private String petStoreName;
	private String petStoreCity;
	private String petStoreState;
	private String petStoreZip;
	private String petStorePhone;
	
	// The class has a field named "customers" of type Set<Customer>, representing the
	// customers associated with the pet store.

	// The field "customers" is annotated with "@ManyToMany", indicating a many-to-many
	// relationship with the "Customer" entity.

	// The annotation "@JoinTable" specifies the join table name and the columns used for
	// joining the "PetStore" and "Customer" entities.
	
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "pet_store_customer", joinColumns = @JoinColumn(name = "pet_store_id"), 
	inverseJoinColumns = @JoinColumn(name = "customer_id"))
	private Set<Customer> customers = new HashSet<>();
	
	// The "employees" field is configured with "cascade = CascadeType.ALL", meaning that
	// any changes made to the pet store entity will be cascaded to the associated employees.
	
	// The "employees" field is configured with "orphanRemoval = true", indicating that
	// any employees removed from the set will be deleted from the database.
	
	// The class has a field named "employees" of type Set<Employee>, representing the
	// employees working at the pet store.
	
	// The field "employees" is annotated with "@OneToMany", indicating a one-to-many
	// relationship with the "Employee" entity.
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@OneToMany(mappedBy = "petStore", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Employee> employees = new HashSet<>();
}
