package radars;

import java.util.ArrayList;
import java.util.List;

import fr.paris10.miage.procs.exercice2.SystemeAmendes;

public class SystemeAmandesImpl implements SystemeAmendes{

	List<Voiture> lv = new ArrayList<Voiture>();
	List<Amende> la = new ArrayList<Amende>();
	
	@Override
	public void enregistrer(Voiture v) {
		lv.add(v);
		
	}

	@Override
	public int signaler(String immatriculation, String modele, int tarif) {
		
		int ok=0;
		int faute = 1;
		boolean boolFaute = true;
		
		for(int i=0;i<lv.size();i++)
		{
			
			ok=0;
			//test voiture existe
			if(lv.get(i).getImmatriculation().equals(immatriculation))
					{
						ok++;
					}
			
			if(lv.get(i).getModele().equals(modele))
					{
						ok++;
					}	
			
			//c�ration amende
			if(ok==2)
			{
				Amende a = new Amende(immatriculation,tarif);
				la.add(a);
				boolFaute = false;
			}
				
		}
		
		if(boolFaute == true)
		{
			faute = -1;
		}
		
		return faute;
	}

	@Override
	public List<Amende> lister(String immatriculation) {
		// TODO Auto-generated method stub
		return la;
	}

	@Override
	public void payer(int numero, String nom, int prenom) {
		// TODO Auto-generated method stub
		
	}



}
