package geektrust.problems.entities;

import java.util.LinkedHashMap;
import java.util.Map;

import geektrust.problems.constants.LengaburuConstants;

/**
 * This is a Singleton Class to generate Lengaburu's Royal Family. This class contains all the details of
 * the Royal Family, which were present in {@link Individual} class.
 * 
 * @author Neeraj Suthar
 *
 */
public class RoyalFamily {
	//King and Queen
	private Individual shan;
	private Individual anga;

	//Kids of King
	private Individual ish;
	private Individual chit;
	private Individual vich;
	private Individual satya;

	//Spouse of King's Kids
	private Individual ambi;
	private Individual lika;
	private Individual vyan;

	//Grandchildren of King
	private Individual drita;
	private Individual vrita;
	private Individual vila;
	private Individual chika;
	private Individual satvy;
	private Individual savya;
	private Individual saayan;

	//Spouse of Grandchildren of King
	private Individual jaya;
	private Individual jnki;
	private Individual kpila;
	private Individual asva;
	private Individual krpi;
	private Individual mina;

	//Great-Grandchildren of King
	private Individual jata;
	private Individual driya;
	private Individual lavnya;
	private Individual kriya;
	private Individual misa;

	//Spouse of Great-Grandchildren of King
	private Individual mnu;
	private Individual gru;
	private static RoyalFamily royalFamily;

	/**
	 * private constructor to reduce the no. of instances to one. 
	 * whenever the instance is created, 2 methods are called : 
	 * <li>formFamily()</li> * To set the details of the family members
	 * <li>setSpouse()</li> * To set the details of spouse of some family members
	 * 
	 * This is to load the details at the time of instantiation so that the user doesn't
	 * have to call them externally.
	 */
	private RoyalFamily() {
		formFamly();
		setSpouse();
	}

	/**
	 * This method creates a singleton instance of {@link RoyalFamily} class if not present.
	 * 
	 * @return {@link RoyalFamily}
	 */
	public static RoyalFamily getRoyalFamilyInstance() {
		if(null==royalFamily) {
			royalFamily = new RoyalFamily();
		}
		return royalFamily;
	}

	/**
	 * This method sets the attributes to the members of the royal family.
	 */
	public void formFamly() {

		shan = new Individual("Shan", 
				LengaburuConstants.GENDER_MALE, 
				anga, 
				null, 
				"King of Lengaburu from 350 years");

		anga = new Individual("Anga", 
				LengaburuConstants.GENDER_FEMALE, 
				shan, 
				null, 
				"Queen of Lengaburu, Wife of King Shan");

		//Kids of King

		ish = new Individual("Ish", 
				LengaburuConstants.GENDER_MALE, 
				null, 
				shan, 
				"First Kid of King Shan, Forever Alone");

		chit = new Individual("Chit", 
				LengaburuConstants.GENDER_MALE,  
				ambi, 
				shan, 
				"Second Kid of King Shan");

		vich = new Individual("Vich", 
				LengaburuConstants.GENDER_MALE, 
				lika, 
				shan, 
				"Third kid of Shan");

		satya = new Individual("Satya", 
				LengaburuConstants.GENDER_FEMALE, 
				vyan, 
				shan, 
				"Fourth kid and the only daughter of Shan");

		ambi = new Individual("Ambi", 
				LengaburuConstants.GENDER_FEMALE, 
				chit, 
				null, 
				"Wife of Prince Chit");

		lika = new Individual("Lika", 
				LengaburuConstants.GENDER_FEMALE, 
				vich, 
				null, 
				"Wife of Prince vich");
		vyan = new Individual("Vyan", 
				LengaburuConstants.GENDER_MALE, 
				satya, 
				null, 
				"Husband of Princess Satya");

		//Grandkids of King

		drita = new Individual("Drita", 
				LengaburuConstants.GENDER_MALE, 
				jaya, 
				chit, 
				"First Kid of Chit");

		vrita = new Individual("Vrita", 
				LengaburuConstants.GENDER_MALE, 
				null, 
				chit, 
				"Second Kid of Chit");

		vila = new Individual("Vila", 
				LengaburuConstants.GENDER_MALE, 
				jnki, 
				vich, 
				"Son of Vich");

		chika = new Individual("Chika", 
				LengaburuConstants.GENDER_FEMALE, 
				kpila, 
				vich, 
				"Daughter of Vich");

		satvy = new Individual("Satvy", 
				LengaburuConstants.GENDER_FEMALE, 
				asva, 
				vyan, 
				"Daughter of Princess Satya");

		savya = new Individual("Savya", 
				LengaburuConstants.GENDER_MALE, 
				krpi, 
				vyan, 
				"First son of Princess Satya");

		saayan = new Individual("Saayan", 
				LengaburuConstants.GENDER_MALE, 
				mina, 
				vyan, 
				"First son of Princess Satya");

		jaya = new Individual("Jaya", 
				LengaburuConstants.GENDER_FEMALE, 
				drita, 
				null, 
				"Wife of Drita");

		jnki = new Individual("Jnki", 
				LengaburuConstants.GENDER_FEMALE, 
				vila, 
				null, 
				"Wife of Vila");

		kpila = new Individual("Kpila", 
				LengaburuConstants.GENDER_MALE, 
				chika, 
				null, 
				"Husband of Chika");

		asva = new Individual("Asva", 
				LengaburuConstants.GENDER_MALE, 
				satvy, 
				null, 
				"Husband of Satvi");

		krpi = new Individual("Krpi", 
				LengaburuConstants.GENDER_FEMALE, 
				savya, 
				null, 
				"Wife of Savya");

		mina = new Individual("Mina", 
				LengaburuConstants.GENDER_FEMALE, 
				saayan, 
				null, 
				"Wife of Saayan");

		//Grandkids of Prince-Princess

		jata = new Individual("Jata", 
				LengaburuConstants.GENDER_MALE, 
				null, 
				drita, 
				"First Kid of Drita");

		driya = new Individual("Driya", 
				LengaburuConstants.GENDER_FEMALE, 
				mnu, 
				drita, 
				"Second kid of Drita");

		lavnya = new Individual("Lavnya", 
				LengaburuConstants.GENDER_FEMALE, 
				gru, 
				vila, 
				"Daughter of Vila");

		kriya = new Individual("Kriya", 
				LengaburuConstants.GENDER_MALE, 
				null, 
				savya, 
				"Son of Savya");

		misa = new Individual("Misa", 
				LengaburuConstants.GENDER_MALE, 
				null, 
				saayan, 
				"Son of Saayan");

		mnu = new Individual("Mnu", 
				LengaburuConstants.GENDER_MALE, 
				driya, 
				null, 
				"Husband of Driya");
		gru = new Individual("Gru", 
				LengaburuConstants.GENDER_MALE, 
				lavnya, 
				null, 
				"Husband of Lavnya");

	}

	/**
	 * This method sets the spouse details of members of the royal family
	 */
	private void setSpouse() {

		shan.setSpouse(anga);

		chit.setSpouse(ambi);
		vich.setSpouse(lika);
		satya.setSpouse(vyan);

		drita.setSpouse(jaya);
		vila.setSpouse(jnki);
		chika.setSpouse(kpila);
		satvy.setSpouse(asva);
		savya.setSpouse(krpi);
		saayan.setSpouse(mina);

		driya.setSpouse(mnu);
		lavnya.setSpouse(gru);		
	}

	/**
	 * This method accepts a String name of a member of Royal Family and returns the record of the member.
	 * 
	 * @param memberName
	 * @return {@link Individual}
	 */
	public Individual getIndividualByName(String memberName){

		Individual familyMember = null;

		if(memberName.equalsIgnoreCase(shan.getName())) {
			familyMember = shan;
		}
		else if(memberName.equalsIgnoreCase(anga.getName())) {
			familyMember = anga;
		}
		else if(memberName.equalsIgnoreCase(ish.getName())) {
			familyMember = ish;
		}
		else if(memberName.equalsIgnoreCase(chit.getName())) {
			familyMember = chit;
		}
		else if(memberName.equalsIgnoreCase(vich.getName())) {
			familyMember = vich;
		}
		else if(memberName.equalsIgnoreCase(satya.getName())) {
			familyMember = satya;
		}
		else if(memberName.equalsIgnoreCase(ambi.getName())) {
			familyMember = ambi;
		}
		else if(memberName.equalsIgnoreCase(lika.getName())) {
			familyMember = lika;
		}
		else if(memberName.equalsIgnoreCase(vyan.getName())) {
			familyMember = vyan;
		}
		else if(memberName.equalsIgnoreCase(drita.getName())) {
			familyMember = drita;
		}
		else if(memberName.equalsIgnoreCase(vrita.getName())) {
			familyMember = vrita;
		}
		else if(memberName.equalsIgnoreCase(vila.getName())) {
			familyMember = vila;
		}
		else if(memberName.equalsIgnoreCase(chika.getName())) {
			familyMember = chika;
		}
		else if(memberName.equalsIgnoreCase(satvy.getName())) {
			familyMember = satvy;
		}
		else if(memberName.equalsIgnoreCase(savya.getName())) {
			familyMember = savya;
		}
		else if(memberName.equalsIgnoreCase(saayan.getName())) {
			familyMember = saayan;
		}
		else if(memberName.equalsIgnoreCase(jaya.getName())) {
			familyMember = jaya;
		}
		else if(memberName.equalsIgnoreCase(jnki.getName())) {
			familyMember = jnki;
		}
		else if(memberName.equalsIgnoreCase(kpila.getName())) {
			familyMember = kpila;
		}
		else if(memberName.equalsIgnoreCase(asva.getName())) {
			familyMember = asva;
		}
		else if(memberName.equalsIgnoreCase(krpi.getName())) {
			familyMember = krpi;
		}
		else if(memberName.equalsIgnoreCase(mina.getName())) {
			familyMember = mina;
		}
		else if(memberName.equalsIgnoreCase(jata.getName())) {
			familyMember = jata;
		}
		else if(memberName.equalsIgnoreCase(driya.getName())) {
			familyMember = driya;
		}
		else if(memberName.equalsIgnoreCase(lavnya.getName())) {
			familyMember = lavnya;
		}
		else if(memberName.equalsIgnoreCase(kriya.getName())) {
			familyMember = kriya;
		}
		else if(memberName.equalsIgnoreCase(misa.getName())) {
			familyMember = misa;
		}
		else if(memberName.equalsIgnoreCase(mnu.getName())) {
			familyMember = mnu;
		}
		else if(memberName.equalsIgnoreCase(gru.getName())) {
			familyMember = gru;
		}

		return familyMember;
	}

	/**
	 * This method generates and returns the Family Tree as a {@link Map} of Individual 
	 * mapped to its level in the family. 
	 * For eg. The King Shan is the root of the family, hence its level is 1. 
	 * 
	 * @return {@link LinkedHashMap}
	 */
	public Map<Individual,Integer>  familyTree(){

		Map<Individual,Integer> familyTree = new LinkedHashMap<Individual,Integer>();

		familyTree.put(shan, 1);
		familyTree.put(anga, 1);

		familyTree.put(ish, 2);
		familyTree.put(chit, 2);
		familyTree.put(ambi, 2);
		familyTree.put(vich, 2);
		familyTree.put(lika, 2);
		familyTree.put(satya, 2);
		familyTree.put(vyan, 2);

		familyTree.put(drita, 3);
		familyTree.put(jaya, 3);
		familyTree.put(vrita, 3);
		familyTree.put(vila, 3);
		familyTree.put(jnki, 3);
		familyTree.put(chika, 3);
		familyTree.put(kpila, 3);
		familyTree.put(satvy, 3);
		familyTree.put(asva, 3);
		familyTree.put(savya, 3);
		familyTree.put(krpi, 3);
		familyTree.put(saayan, 3);
		familyTree.put(mina, 3);

		familyTree.put(jata, 4);
		familyTree.put(driya, 4);
		familyTree.put(mnu, 4);
		familyTree.put(lavnya, 4);
		familyTree.put(gru, 4);
		familyTree.put(kriya, 4);
		familyTree.put(misa, 4);

		return familyTree;
	}	
}
