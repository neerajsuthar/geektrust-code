/**
 * 
 */
package geektrust.problems;

import java.util.List;
import java.util.Scanner;

import geektrust.problems.entities.Individual;
import geektrust.problems.exception.LengaburuException;
import geektrust.problems.firstproblem.RelationshipFinder;

/**
 * 
 * @author Neeraj Suthar
 *
 */
public class FamilyDetails {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		try {
			char ans = 'y';

			while(ans=='y'||ans=='Y') {
				System.out.println("***---WELCOME TO ROYAL FAMILY OF LENGABURU---***\n\\n");
				System.out.println("Enter '1' to see the relative information.");
				System.out.println("Enter '2' to add new member to the family.");
				System.out.println("Enter '3' to see the mother of maximum girl child.");
				System.out.println("Enter '4' to find the relaion between 2 people.");
				System.out.println("Enter '9' to Exit.");

				System.out.println("\nEnter Your Choice : ");
				int choice = input.nextInt();

				switch (choice) {
				case 1: solutionToProblem1(input);
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

	@SuppressWarnings("resource")
	private static void solutionToProblem1(Scanner input) throws LengaburuException {
		String relationships = "";

		try{
			System.out.println("Enter Name of the person : ");

			String name = input.next();
			System.out.println("Enter Relation : ");
			String relation = input.next();

			RelationshipFinder relationshipFinder = new RelationshipFinder();

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

}
