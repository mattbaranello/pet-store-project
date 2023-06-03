package com.promineotech.pet.store.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

//The code defines a Java class named "PetStore" with the annotation "@Entity",
//indicating that it is a persistent entity in a database.

//The class uses the "@Data" annotation, which generates boilerplate code for
//getters, setters, equals, hashCode, and toString methods.
@Entity
@Data
public class Customer {
	
	// The class has a private field named "customerId" of type Long, which represents
	// the unique identifier for the customer.
	
	// The field "customerId" is annotated with "@Id", indicating that it is the primary key
	// for the entity.

	// The field "customerId" is also annotated with "@GeneratedValue", specifying that
	// the value of the identifier will be generated automatically.
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	
	//These private fields represent different columns that will be
	//added to the "customer" table with their respected data types.
	private String customerFirstName;
	private String customerLastName;
	private String customerEmail;
	
	// The code snippet defines a field named "petStores" in a class, which represents
	// the set of pet stores associated with an entity.

	// The field is annotated with "@ManyToMany", indicating a many-to-many relationship
	// with the "PetStore" entity.

	// The annotation "@mappedBy = "customers"" specifies that the "customers" field in
	// the "PetStore" entity is the owning side of the relationship.

	// The "cascade = CascadeType.PERSIST" configuration specifies that when a new pet store
	// is added to the set, it should be persisted in the database.
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToMany(mappedBy = "customers", cascade = CascadeType.PERSIST)
	private Set<PetStore> petStores = new HashSet<>();
}
