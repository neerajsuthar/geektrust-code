package geektrust.problems.first;

import java.util.ArrayList;
import java.util.List;

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
			relatives = getBrothers(individual);
		}
		else if(relationship.equalsIgnoreCase(LengaburuConstants.RELATIONSHIP_CHILDREN)) {
			relatives = getChildren(individual);
		}
		else if(relationship.equalsIgnoreCase(LengaburuConstants.RELATIONSHIP_COUSINS)) {
			relatives = getCousins(individual);
		}
		else if(relationship.equalsIgnoreCase(LengaburuConstants.RELATIONSHIP_DAUGHTER)) {
			relatives = getDaughters(individual);
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
			relatives = getSisters(individual);
		}
		else if(relationship.equalsIgnoreCase(LengaburuConstants.RELATIONSHIP_SON)) {
			relatives = getSon(individual);
		}
		
		return relatives;
			
	}

	private List<Individual> getDaughters(Individual individual) {
		// TODO Auto-generated method stub
		return null;
	}

	private List<Individual> getFather(Individual individual) {
		List<Individual> fatherList = new ArrayList<>();
		if(null!=individual.getFather()) {
			fatherList.add(individual.getFather());
		}
		return fatherList;
	}

	private List<Individual> getGrandDaughter(Individual individual) {
		// TODO Auto-generated method stub
		return null;
	}

	private List<Individual> getMaternalAunt(Individual individual) {
		// TODO Auto-generated method stub
		return null;
	}

	private List<Individual> getMaternalUncle(Individual individual) {
		// TODO Auto-generated method stub
		return null;
	}

	private List<Individual> getMother(Individual individual) {
		// TODO Auto-generated method stub
		return null;
	}

	private List<Individual> getPaternalAunt(Individual individual) {
		// TODO Auto-generated method stub
		return null;
	}

	private List<Individual> getPaternalUncle(Individual individual) {
		// TODO Auto-generated method stub
		return null;
	}

	private List<Individual> getSisterInLaw(Individual individual) {
		// TODO Auto-generated method stub
		return null;
	}

	private List<Individual> getSisters(Individual individual) {
		// TODO Auto-generated method stub
		return null;
	}

	private List<Individual> getSon(Individual individual) {
		// TODO Auto-generated method stub
		return null;
	}

	private List<Individual> getChildren(Individual individual) {
		// TODO Auto-generated method stub
		return null;
	}

	private List<Individual> getCousins(Individual individual) {
		// TODO Auto-generated method stub
		return null;
	}

	private List<Individual> getBrothers(Individual individual) {
		// TODO Auto-generated method stub
		return null;
	}

	private List<Individual> getBrotherInLaw(Individual individual) {
		// TODO Auto-generated method stub
		return null;
	}

}
