/**
 * 
 */
package geektrust.problems.entities;

import java.util.List;

/**
 * This 
 * 
 * @author Neeraj Suthar
 *
 */
public class Individual {

	private String name;
	private String gender;
	private Individual spouse;
	private Individual father;
	private String details;

	public Individual() {
		// TODO Auto-generated constructor stub
	}

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
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Individual getSpouse() {
		return spouse;
	}
	public void setSpouse(Individual spouse) {
		this.spouse = spouse;
	}
	public Individual getFather() {
		return father;
	}
	public void setFather(Individual father) {
		this.father = father;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}

}
