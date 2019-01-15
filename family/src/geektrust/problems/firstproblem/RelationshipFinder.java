package geektrust.problems.firstproblem;

import java.util.ArrayList;
import java.util.List;

import com.sun.scenario.animation.shared.InfiniteClipEnvelope;

import geektrust.problems.constants.LengaburuConstants;
import geektrust.problems.entities.Individual;
import geektrust.problems.entities.RoyalFamily;

public class RelationshipFinder {
	private RoyalFamily royalFamily = RoyalFamily.getRoyalFamilyInstance();

	public List<Individual> getRelativeDetails(String name, String relationship) {

		Individual individual = royalFamily.getIndividualByName(name);

		List<Individual> relatives = new ArrayList<>();

		if(relationship.equalsIgnoreCase(LengaburuConstants.RELATIONSHIP_BROTHER_IN_LAW)) {
			relatives = getBrotherInLaw(individual);
		}
		else if(relationship.equalsIgnoreCase(LengaburuConstants.RELATIONSHIP_BROTHERS)) {
			relatives = getSiblings(individual, LengaburuConstants.GENDER_MALE);
		}
		else if(relationship.equalsIgnoreCase(LengaburuConstants.RELATIONSHIP_CHILDREN)) {
			relatives = getChildren(individual, null);
		}
		else if(relationship.equalsIgnoreCase(LengaburuConstants.RELATIONSHIP_COUSINS)) {
			relatives = getCousins(individual);
		}
		else if(relationship.equalsIgnoreCase(LengaburuConstants.RELATIONSHIP_DAUGHTER)) {
			relatives = getChildren(individual, LengaburuConstants.GENDER_FEMALE);
		}
		else if(relationship.equalsIgnoreCase(LengaburuConstants.RELATIONSHIP_FATHER)) {
			relatives = getFather(individual);
		}
		else if(relationship.equalsIgnoreCase(LengaburuConstants.RELATIONSHIP_GRAND_DAUGHTER)) {
			relatives = getGrandDaughter(individual);
		}
		else if(relationship.equalsIgnoreCase(LengaburuConstants.RELATIONSHIP_MATERNAL_AUNT)) {
			relatives = getMaternalAunt(individual);
		}
		else if(relationship.equalsIgnoreCase(LengaburuConstants.RELATIONSHIP_MATERNAL_UNCLE)) {
			relatives = getMaternalUncle(individual);
		}
		else if(relationship.equalsIgnoreCase(LengaburuConstants.RELATIONSHIP_MOTHER)) {
			relatives = getMother(individual);
		}
		else if(relationship.equalsIgnoreCase(LengaburuConstants.RELATIONSHIP_PARENTAL_AUNT)) {
			relatives = getPaternalAunt(individual);
		}
		else if(relationship.equalsIgnoreCase(LengaburuConstants.RELATIONSHIP_PARENTAL_UNCLE)) {
			relatives = getPaternalUncle(individual);
		}
		else if(relationship.equalsIgnoreCase(LengaburuConstants.RELATIONSHIP_SISTER_IN_LAW)) {
			relatives = getSisterInLaw(individual);
		}
		else if(relationship.equalsIgnoreCase(LengaburuConstants.RELATIONSHIP_SISTERS)) {
			relatives = getSiblings(individual, LengaburuConstants.GENDER_FEMALE);
		}
		else if(relationship.equalsIgnoreCase(LengaburuConstants.RELATIONSHIP_SON)) {
			relatives = getChildren(individual, LengaburuConstants.GENDER_MALE);
		}

		return relatives;

	}
	//Clean This Mess
	private List<Individual> getChildren(Individual individual, String gender) {
		List<Individual> childrenList = new ArrayList<>();

		if(individual.getGender().equalsIgnoreCase(LengaburuConstants.GENDER_FEMALE) && null!=individual.getSpouse()) {
			for (Individual member : royalFamily.familyTree().keySet()) {
				if(null==gender) {
					if(null!=member.getFather() 
							&& !(member.equals(individual))
							&& member.getFather().equals(individual.getSpouse())) {
						childrenList.add(member);
					}
				}
				else {
					if(null!=member.getFather() 
							&& !(member.equals(individual))
							&& member.getGender().equalsIgnoreCase(gender) 
							&& member.getFather().equals(individual.getSpouse())) {
						childrenList.add(member);
					}
				}
			}
		}
		else if(individual.getGender().equalsIgnoreCase(LengaburuConstants.GENDER_MALE)){
			for (Individual member : royalFamily.familyTree().keySet()) {
				if(null==gender) {
					if(null!=member.getFather() 
							&& !(member.equals(individual))
							&& member.getFather().equals(individual)) {
						childrenList.add(member);
					}
				}
				else {
					if(null!=member.getFather() 
							&& !(member.equals(individual))
							&& member.getGender().equalsIgnoreCase(gender) 
							&& member.getFather().equals(individual)) {
						childrenList.add(member);
					}
				}
			}
		}


		return childrenList;
	}

	private List<Individual> getFather(Individual individual) {
		List<Individual> fatherList = new ArrayList<>();
		if(null!=individual.getFather()) {
			fatherList.add(individual.getFather());
		}
		return fatherList;
	}

	private List<Individual> getGrandDaughter(Individual individual) {
		List<Individual> grandDaughtersList = new ArrayList<>();

		for (Individual individualsKids : getChildren(individual, null)) {
			grandDaughtersList.addAll(getChildren(individualsKids, LengaburuConstants.GENDER_FEMALE));
		}

		return grandDaughtersList;
	}

	private List<Individual> getMaternalAunt(Individual individual) {

		List<Individual> maternalAuntList = new ArrayList<>();
		if(!getFather(individual).isEmpty() && !getMother(individual).isEmpty()) {
			maternalAuntList.addAll(getSiblings(getMother(individual).get(0), LengaburuConstants.GENDER_FEMALE));
			maternalAuntList.addAll(getSisterInLaw(getMother(individual).get(0)));
			
		}
		return maternalAuntList;
	}

	private List<Individual> getMaternalUncle(Individual individual) {
		
		List<Individual> maternalUncleList = new ArrayList<>();
		if(!getFather(individual).isEmpty() && !getMother(individual).isEmpty()) {
			maternalUncleList.addAll(getSiblings(getMother(individual).get(0), LengaburuConstants.GENDER_MALE));
			maternalUncleList.addAll(getBrotherInLaw(getMother(individual).get(0)));			
		}
		return maternalUncleList;
	}

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

	private List<Individual> getPaternalAunt(Individual individual) {
		List<Individual> paternalAuntList = new ArrayList<>();
		if(!getFather(individual).isEmpty()) {
			paternalAuntList.addAll(getSiblings(getFather(individual).get(0), LengaburuConstants.GENDER_FEMALE));
			paternalAuntList.addAll(getSisterInLaw(getFather(individual).get(0)));
		}
		return paternalAuntList;
	}

	private List<Individual> getPaternalUncle(Individual individual) {
		List<Individual> paternalUncleList = new ArrayList<>();
		if(!getFather(individual).isEmpty()) {
			paternalUncleList.addAll(getSiblings(getFather(individual).get(0), LengaburuConstants.GENDER_MALE));
			paternalUncleList.addAll(getBrotherInLaw(getFather(individual).get(0)));
		}
		return paternalUncleList;
	}

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

	private List<Individual> getCousins(Individual individual) {
		List<Individual> cousinsList = new ArrayList<>();
		if(null!=individual.getFather()) {

		}

		return cousinsList;
	}

	private List<Individual> getSiblings(Individual individual, String gender) {
		List<Individual> siblingList = new ArrayList<>();
		if(null!=individual.getFather()) {
			for (Individual member : royalFamily.familyTree().keySet()) {
				if(null!=member.getFather() 
						&& !(member.equals(individual))

						&& member.getFather().equals(individual.getFather())) {
					if(null==gender){
						siblingList.add(member);	
					}
					else if(member.getGender().equalsIgnoreCase(gender)) {
						siblingList.add(member);
					}


				}
			}
		}


		return siblingList;
	}

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

}
