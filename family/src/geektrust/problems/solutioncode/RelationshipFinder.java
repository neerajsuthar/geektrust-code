package geektrust.problems.solutioncode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import geektrust.problems.constants.LengaburuConstants;
import geektrust.problems.entities.Individual;
import geektrust.problems.entities.RoyalFamily;
import geektrust.problems.exception.LengaburuException;

/**
 * This class contains the actual business logic for the problem "FAMILY".
 * 
 * @author Neeraj Suthar
 *
 */
public class RelationshipFinder {

	private RoyalFamily royalFamily = RoyalFamily.getRoyalFamilyInstance();

	/**
	 * This method redirects the request according to the relationship info passed by the caller method.
	 * 
	 * @param memberName
	 * @param relationship
	 * @return {@link ArrayList} of relatives
	 */
	public List<Individual> getRelativeDetails(String memberName, String relationship) {

		Individual individual = royalFamily.getIndividualByName(memberName);

		List<Individual> relatives = new ArrayList<>();

		switch (relationship) {

		case LengaburuConstants.RELATIONSHIP_BROTHER_IN_LAW: 
			relatives = getBrotherInLaw(individual);
			break;

		case LengaburuConstants.RELATIONSHIP_BROTHERS: 
			relatives = getSiblings(individual, LengaburuConstants.GENDER_MALE);
			break;

		case LengaburuConstants.RELATIONSHIP_CHILDREN: 
			relatives = getChildren(individual, null);
			break;


		case LengaburuConstants.RELATIONSHIP_COUSINS: 
			relatives = getCousins(individual);
			break;


		case LengaburuConstants.RELATIONSHIP_DAUGHTER: 
			relatives = getChildren(individual, LengaburuConstants.GENDER_FEMALE);
			break;


		case LengaburuConstants.RELATIONSHIP_FATHER: 
			relatives = getFather(individual);
			break;


		case LengaburuConstants.RELATIONSHIP_GRAND_DAUGHTER: 
			relatives = getGrandDaughter(individual);
			break;


		case LengaburuConstants.RELATIONSHIP_MATERNAL_AUNT: 
			relatives = getMaternalAunt(individual);
			break;

		case LengaburuConstants.RELATIONSHIP_MATERNAL_UNCLE: 
			relatives = getMaternalAunt(individual);
			break;

		case LengaburuConstants.RELATIONSHIP_MOTHER: 
			relatives = getMother(individual);
			break;

		case LengaburuConstants.RELATIONSHIP_PARENTAL_AUNT: 
			relatives = getPaternalAunt(individual);
			break;

		case LengaburuConstants.RELATIONSHIP_PARENTAL_UNCLE: 
			relatives = getPaternalUncle(individual);
			break;

		case LengaburuConstants.RELATIONSHIP_SISTER_IN_LAW: 
			relatives = getSisterInLaw(individual);
			break;

		case LengaburuConstants.RELATIONSHIP_SISTERS: 
			relatives = getSiblings(individual, LengaburuConstants.GENDER_FEMALE);
			break;

		case LengaburuConstants.RELATIONSHIP_SON: 
			relatives = getChildren(individual, LengaburuConstants.GENDER_MALE);
			break;

		default:
			break;
		}

		return relatives;

	}

	/**
	 * This method returns the list of Children of the individual passed on the following conditions:
	 * <li>if gender is MALE : <i>List of Sons is returned</i></li>
	 * <li>if gender is FEMALE : <i>List of Daughters is returned.</i></li>
	 * <li>if gender is {@link null} : <i>List of all children is returned.</i></li>
	 * 
	 * @param individual
	 * @param gender
	 * @return List of children
	 */
	private List<Individual> getChildren(Individual individual, String gender) {
		List<Individual> childrenList = new ArrayList<>();

		childrenList=familyStream()
				.filter(e->null!=e.getFather()
				&& e.getFather()
				.getName()
				.equalsIgnoreCase(individual.getName()))
				.collect(Collectors.toList());

		if(null!=gender) {
			childrenList = childrenList.stream().filter(e-> e.getGender().equalsIgnoreCase(gender)).collect(Collectors.toList());
		}

		return childrenList;
	}

	/**
	 * This method returns the List of Father, but it has only one element
	 * 
	 * @param individual
	 * @return List of Father
	 */
	private List<Individual> getFather(Individual individual) {
		List<Individual> fatherList = new ArrayList<>();
		if(null!=individual.getFather()) {
			fatherList.add(individual.getFather());
		}
		return fatherList;
	}

	/**
	 * This method returns the List of Grand-Daughters
	 * 
	 * @param individual
	 * @return List of Grand-Daughters
	 */
	private List<Individual> getGrandDaughter(Individual individual) {
		List<Individual> grandDaughtersList = new ArrayList<>();

		for (Individual individualsKids : getChildren(individual, null)) {
			grandDaughtersList.addAll(getChildren(individualsKids, LengaburuConstants.GENDER_FEMALE));
		}

		return grandDaughtersList;
	}

	/**
	 * This method returns the List of Maternal Aunts on the following conditions:
	 * <li>Mother's Sister is a Maternal-Aunt</li>
	 * <li>Mother's Sister-In-Law is a Maternal-Aunt</li>
	 * 
	 * @param individual
	 * @return List of Maternal-Aunt
	 */
	private List<Individual> getMaternalAunt(Individual individual) {

		List<Individual> maternalAuntList = new ArrayList<>();
		if(!getFather(individual).isEmpty() && !getMother(individual).isEmpty()) {
			maternalAuntList.addAll(getSiblings(getMother(individual).get(0), LengaburuConstants.GENDER_FEMALE));
			maternalAuntList.addAll(getSisterInLaw(getMother(individual).get(0)));

		}
		return maternalAuntList;
	}

	/**
	 * This method returns the List of Maternal Uncle on the following conditions:
	 * <li>Mother's Brother is a Maternal-Uncle</li>
	 * <li>Mother's Brother-In-Law is a Maternal-Uncle</li>
	 * 
	 * @param individual
	 * @return List of Maternal-Uncle
	 */
	private List<Individual> getMaternalUncle(Individual individual) {

		List<Individual> maternalUncleList = new ArrayList<>();
		if(!getFather(individual).isEmpty() && !getMother(individual).isEmpty()) {
			maternalUncleList.addAll(getSiblings(getMother(individual).get(0), LengaburuConstants.GENDER_MALE));
			maternalUncleList.addAll(getBrotherInLaw(getMother(individual).get(0)));			
		}
		return maternalUncleList;
	}

	/**
	 * This method returns the List of Mother, but has only one element.
	 * 
	 * @param individual
	 * @return List of Mother
	 */
	private List<Individual> getMother(Individual individual) {

		List<Individual> motherList = new ArrayList<>();

		if(!getFather(individual).isEmpty()) {
			Individual mother = getFather(individual).get(0).getSpouse();
			if(null!=mother) {
				motherList.add(mother);
			}
		}
		return motherList;
	}

	/**
	 * This method returns the List of Paternal Aunts on the following conditions:
	 * <li>Father's Sister is a Paternal-Aunt</li>
	 * <li>Father's Sister-In-Law is a Paternal-Aunt</li>
	 * 
	 * @param individual
	 * @return List of Paternal-Aunt
	 */
	private List<Individual> getPaternalAunt(Individual individual) {
		List<Individual> paternalAuntList = new ArrayList<>();
		if(!getFather(individual).isEmpty()) {
			paternalAuntList.addAll(getSiblings(getFather(individual).get(0), LengaburuConstants.GENDER_FEMALE));
			paternalAuntList.addAll(getSisterInLaw(getFather(individual).get(0)));
		}
		return paternalAuntList;
	}

	/**
	 * This method returns the List of Paternal Uncles on the following conditions:
	 * <li>Father's Brother is a Paternal-Uncle</li>
	 * <li>Father's Brother-In-Law is a Paternal-Uncle</li>
	 * 
	 * @param individual
	 * @return List of Paternal-Uncle
	 */
	private List<Individual> getPaternalUncle(Individual individual) {
		List<Individual> paternalUncleList = new ArrayList<>();
		if(!getFather(individual).isEmpty()) {
			paternalUncleList.addAll(getSiblings(getFather(individual).get(0), LengaburuConstants.GENDER_MALE));
			paternalUncleList.addAll(getBrotherInLaw(getFather(individual).get(0)));
		}
		return paternalUncleList;
	}

	/**
	 * This method returns the List of Sister-In-Law on the following conditions:
	 * <li>Spouse's Sister is a Sister-In-Law</li>
	 * <li>Brother's Spouse is a Sister-In-Law</li>
	 * 
	 * @param individual
	 * @return List of Sister-In-Law
	 */
	private List<Individual> getSisterInLaw(Individual individual) {

		List<Individual> sisterInLawList = new ArrayList<>();

		if(null!=individual.getSpouse()) {
			sisterInLawList.addAll(getSiblings(individual.getSpouse(), LengaburuConstants.GENDER_FEMALE));
		}
		for (Individual brother : getSiblings(individual, LengaburuConstants.GENDER_MALE)) {
			if(null!=brother.getSpouse()) {
				sisterInLawList.add(brother.getSpouse());
			}
		}

		return sisterInLawList;
	}

	/**
	 * This method returns the List of Cousins on the following conditions:
	 * <li>All the children of Parent's Siblings</li>
	 * 
	 * @param individual
	 * @return List of Cousins
	 */
	private List<Individual> getCousins(Individual individual) {

		List<Individual> cousinsList = new ArrayList<>();

		if(null!=individual.getFather()) {
			for (Individual fathersSibling : getSiblings(individual.getFather(), null)) {
				cousinsList.addAll(getChildren(fathersSibling, null));
			}
		}

		return cousinsList;
	}

	/**
	 * This method returns the List of Siblings on the following conditions:
	 * <li>if gender is MALE : <i>List of Brothers is returned</i></li>
	 * <li>if gender is FEMALE : <i>List of Sisters is returned.</i></li>
	 * <li>if gender is {@link null} : <i>List of all the Siblings is returned.</i></li>
	 * 
	 * @param individual
	 * @param gender
	 * @return List of Siblings
	 */
	private List<Individual> getSiblings(Individual individual, String gender) {
		List<Individual> siblingList = new ArrayList<>();
		if(null!=individual.getFather()) {

			siblingList = familyStream().filter(e->null!=e.getFather()
					&& e.getFather().getName().equalsIgnoreCase(individual.getFather().getName())
					).collect(Collectors.toList());
			if(null!=gender) {
				siblingList = siblingList.stream().filter(e->e.getGender().equalsIgnoreCase(gender)).collect(Collectors.toList());
			}

		}
		return siblingList;
	}

	/**
	 * This method returns the List of Brother-In-Law on the following conditions:
	 * <li>Spouse's Brother is a Brother-In-Law</li>
	 * <li>Sister's Spouse is a Brother-In-Law</li>
	 * 
	 * @param individual
	 * @return List of Brother-In-Law
	 */
	private List<Individual> getBrotherInLaw(Individual individual) {
		List<Individual> brotherInLawList = new ArrayList<>();

		if(null!=individual.getSpouse()) {
			brotherInLawList.addAll(getSiblings(individual.getSpouse(), LengaburuConstants.GENDER_MALE));
		}
		for (Individual sister : getSiblings(individual, LengaburuConstants.GENDER_FEMALE)) {
			if(null!=sister.getSpouse()) {
				brotherInLawList.add(sister.getSpouse());
			}
		}

		return brotherInLawList;
	}

	/**
	 * This method is used to add an individual to the Lengaburu's Family Tree
	 * 
	 * @param newBorn
	 * @throws LengaburuException 
	 */
	public void addNewFamilyMember(Individual newBorn) throws LengaburuException {
		Map<Individual, Integer> familyTree = royalFamily.familyTree();

		int fathersLevel = 0;
		if(null!=newBorn.getFather()) {
			try {
				fathersLevel = familyTree.get(newBorn.getFather());
			}
			catch (Exception e) {
				throw new LengaburuException("Father Details not present in the Family Tree");
			}
		}
		//Adding newBorn to the family
		familyTree.put(newBorn, fathersLevel+1);
	}

	/**
	 * This method accepts a String name of a member of Royal Family and returns the record of the member.
	 * 
	 * @param memberName
	 * @return {@link Individual}
	 */
	public Individual findIndividualByName(String memberName) {
		return royalFamily.getIndividualByName(memberName);
	}

	private Stream<Individual> familyStream(){
		return royalFamily.familyTree().keySet().stream();
	}

}
