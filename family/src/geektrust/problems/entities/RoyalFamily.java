package geektrust.problems.entities;

import java.util.LinkedHashMap;
import java.util.Map;

import geektrust.problems.constants.LengaburuConstants;

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

	private RoyalFamily() {
		formFamly();
		setSpouse();
	}
	
	public static RoyalFamily getRoyalFamilyInstance() {
		if(null==royalFamily) {
			royalFamily = new RoyalFamily();
		}
		return royalFamily;
	}


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


	public Individual getIndividualByName(String name){

		Individual familyMember = null;

		if(name.equalsIgnoreCase(shan.getName())) {
			familyMember = shan;
		}
		else if(name.equalsIgnoreCase(anga.getName())) {
			familyMember = anga;
		}
		else if(name.equalsIgnoreCase(ish.getName())) {
			familyMember = ish;
		}
		else if(name.equalsIgnoreCase(chit.getName())) {
			familyMember = chit;
		}
		else if(name.equalsIgnoreCase(vich.getName())) {
			familyMember = vich;
		}
		else if(name.equalsIgnoreCase(satya.getName())) {
			familyMember = satya;
		}
		else if(name.equalsIgnoreCase(ambi.getName())) {
			familyMember = ambi;
		}
		else if(name.equalsIgnoreCase(lika.getName())) {
			familyMember = lika;
		}
		else if(name.equalsIgnoreCase(vyan.getName())) {
			familyMember = vyan;
		}
		else if(name.equalsIgnoreCase(drita.getName())) {
			familyMember = drita;
		}
		else if(name.equalsIgnoreCase(vrita.getName())) {
			familyMember = vrita;
		}
		else if(name.equalsIgnoreCase(vila.getName())) {
			familyMember = vila;
		}
		else if(name.equalsIgnoreCase(chika.getName())) {
			familyMember = chika;
		}
		else if(name.equalsIgnoreCase(satvy.getName())) {
			familyMember = satvy;
		}
		else if(name.equalsIgnoreCase(savya.getName())) {
			familyMember = savya;
		}
		else if(name.equalsIgnoreCase(saayan.getName())) {
			familyMember = saayan;
		}
		else if(name.equalsIgnoreCase(jaya.getName())) {
			familyMember = jaya;
		}
		else if(name.equalsIgnoreCase(jnki.getName())) {
			familyMember = jnki;
		}
		else if(name.equalsIgnoreCase(kpila.getName())) {
			familyMember = kpila;
		}
		else if(name.equalsIgnoreCase(asva.getName())) {
			familyMember = asva;
		}
		else if(name.equalsIgnoreCase(krpi.getName())) {
			familyMember = krpi;
		}
		else if(name.equalsIgnoreCase(mina.getName())) {
			familyMember = mina;
		}
		else if(name.equalsIgnoreCase(jata.getName())) {
			familyMember = jata;
		}
		else if(name.equalsIgnoreCase(driya.getName())) {
			familyMember = driya;
		}
		else if(name.equalsIgnoreCase(lavnya.getName())) {
			familyMember = lavnya;
		}
		else if(name.equalsIgnoreCase(kriya.getName())) {
			familyMember = kriya;
		}
		else if(name.equalsIgnoreCase(misa.getName())) {
			familyMember = misa;
		}
		else if(name.equalsIgnoreCase(mnu.getName())) {
			familyMember = mnu;
		}
		else if(name.equalsIgnoreCase(gru.getName())) {
			familyMember = gru;
		}

		return familyMember;
	}

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
