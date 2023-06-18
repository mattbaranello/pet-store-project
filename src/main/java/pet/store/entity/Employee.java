package pet.store.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

//The code defines a Java class named "PetStore" with the annotation "@Entity",
//indicating that it is a persistent entity in a database.

//The class uses the "@Data" annotation, which generates boilerplate code for
//getters, setters, equals, hashCode, and toString methods.
@Entity
@Data
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long employeeId;
	
	private String employeeFirstName;
	private String employeeLastName;
	private String employeePhone;
	private String employeeJobTitle;
	
	// The code snippet defines a field named "petStore" in a class, which represents
	// a single pet store associated with an entity.

	// The field is annotated with "@ManyToOne", indicating a many-to-one relationship
	// with the "PetStore" entity.

	// The "cascade = CascadeType.ALL" configuration specifies that any changes made to the
	// associated pet store should be cascaded to this entity.

	// The "@JoinColumn" annotation specifies the mapping of the foreign key column between
	// this entity and the "PetStore" entity. The column is named "pet_store_id".
	@EqualsAndHashCode.Exclude
	@ToString.Exclude
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "pet_store_id")
	private PetStore petStore;
	
	
}
