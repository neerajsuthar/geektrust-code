/**
 * 
 */
package geektrust.problems.entities;

/**
 * This is POJO and can act as the DAO class if Hibernate is plugedin to the code.
 * 
 * @author Neeraj Suthar
 *
 */
public class Individual {

	//Attributes of the Individual
	private String name;
	private String gender;
	private Individual spouse;
	private Individual father;
	private String details;

	public Individual() {
		// Unused as of now.
	}

	/**
	 * Parameterised constructor with Individual's attributes
	 * 
	 * @param name
	 * @param gender
	 * @param spouse
	 * @param father
	 * @param details
	 */
	public Individual(String name, String gender, Individual spouse, Individual father, String details) {
		super();
		this.name = name;
		this.gender = gender;
		this.spouse = spouse;
		this.father = father;
		this.details = details;
	}
	
	public String getName() {
		return name;
	}

	public String getGender() {
		return gender;
	}

	public Individual getSpouse() {
		return spouse;
	}

	public Individual getFather() {
		return father;
	}

	public String getDetails() {
		return details;
	}

	public void setSpouse(Individual spouse) {
		this.spouse = spouse;
	}
}
