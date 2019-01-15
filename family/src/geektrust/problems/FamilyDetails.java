/**
 * 
 */
package geektrust.problems;

import java.util.List;
import java.util.Scanner;

import geektrust.problems.entities.Individual;
import geektrust.problems.exception.LengaburuException;
import geektrust.problems.solutioncode.RelationshipFinder;

/**
 * This is the Runner Class of Lengaburu's Family Portal
 * 
 * @author Neeraj Suthar
 *
 */
public class FamilyDetails {

	private static RelationshipFinder relationshipFinder = new RelationshipFinder();

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		if(args.length==0) {
			runProjectWithScanner();
		}
		else {
			//Use "args" for command line arguments
			System.out.println("This Feature is not implemented, "
					+ "\nPlease pass console input (without comand line arguments). \nThank You.");
		}
	}

	/**
	 * Method to run project as Console Project
	 */
	private static void runProjectWithScanner() {
		Scanner input = new Scanner(System.in);
		try {
			char ans = 'y';

			while(ans=='y'||ans=='Y') {
				System.out.println("***---WELCOME TO ROYAL FAMILY OF LENGABURU---***\n\n");
				System.out.println("Enter '1' to see the relative information.");
				System.out.println("Enter '2' to add new member to the family.");
				System.out.println("Enter '3' to see the mother of maximum girl child.");
				System.out.println("Enter '4' to find the relaion between 2 people.");
				System.out.println("Enter '9' to Exit.");
				System.out.println("\n(Please refer to 'Read.Me' before proceeding)");

				System.out.println("\nEnter Your Choice : ");
				int choice = input.nextInt();

				switch (choice) {
				case 1: getFamilyInfo(input);
				break;

				case 2: addNewFamilyMember(input);
				break;

				case 3: getMotherOfMaximumDaughters(input);
				break;

				case 4: getRelationshipBetweenTwoIndividuals(input);
				break;

				case 9: System.exit(0);
				break;

				default: System.out.println("Feature Not Available");
				break;
				}

				System.out.println("Press 'y' to Continue, 'n' to Exit...");
				ans = input.next().toCharArray()[0];
			}

		}catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Solution to Problem 4 : Method to get the relationship between two Individuals.
	 * 
	 * @param input
	 */
	private static void getRelationshipBetweenTwoIndividuals(Scanner input) {
		System.out.println("Feature not implemented yet...!!");

	}

	/**
	 * Solution to Problem 3 : Method to get the Mother of maximum Daughters out of the list passed.
	 * 
	 * @param input
	 */
	private static void getMotherOfMaximumDaughters(Scanner input) {
		System.out.println("Feature not implemented yet...!!");

	}

	/**
	 * Solution to Problem 1 : Method to get the relatives information.
	 * 
	 * @param input
	 * @throws LengaburuException
	 */
	private static void getFamilyInfo(Scanner input) throws LengaburuException {
		String relationships = "";

		try{
			System.out.println("Enter Name of the person : ");

			String name = input.next();
			System.out.println("Enter Relation : ");
			String relation = input.next();


			List<Individual> list = relationshipFinder.getRelativeDetails(name, relation);



			if (list.isEmpty()) {
				relationships = "Relative Information Not Present";
			}
			else {
				for (Individual individual : list) {
					relationships += ", " + individual.getName();
				}
				relationships = relationships.substring(1);
			}
		}catch (Exception e) {
			throw new LengaburuException(e);
		}
		finally {
			System.out.println(relationships);
		}
	}
	/**
	 * Solution to Problem 2 : Method to add new member to the family.
	 * 
	 * @param input
	 */
	private static void addNewFamilyMember(Scanner input) throws LengaburuException {

		System.out.println("Add Feature is under implementation...!!");

		/*
		try {
			System.out.println("Enter Name: ");
			String name = input.next();
			System.out.println("Enter Gender : ");
			String gender = input.next();
			System.out.println("Enter Spouse's Name : ");
			String spouseName = input.next();
			System.out.println("Enter Father's Name : ");
			String fathersName = input.next();
			String details = "New Born in Family";

			Individual spouse = null;
			if(!spouseName.equalsIgnoreCase("null")) {
				spouse = relationshipFinder.findIndividualByName(spouseName);
			}

			Individual father = null;
			if(!spouseName.equalsIgnoreCase("null")) {
				father = relationshipFinder.findIndividualByName(fathersName);
			}

			Individual newBorn = new Individual(name, gender, spouse, father, details);

			relationshipFinder.addNewFamilyMember(newBorn);

		}catch (Exception e) {
			throw new LengaburuException(e);
		}
		 */
	}
}
