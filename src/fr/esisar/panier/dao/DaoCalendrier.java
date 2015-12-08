package fr.esisar.panier.dao;

import java.util.List;

import fr.esisar.panier.metier.Calendrier;
import fr.esisar.panier.metier.Ferie;
import fr.esisar.panier.metier.Livraison;

public class DaoCalendrier implements LoDao<Calendrier> {

	@Override
	public List<Calendrier> find(String conditions) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Calendrier newRecord) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Calendrier updateRecord) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Calendrier removeRecord) {
		// TODO Auto-generated method stub
		return false;
	}
	
	public Calendrier getByLivraison(Livraison livraison) {
		// TODO
		return null;
	}
	
	public Calendrier getByFerie(Ferie ferie) {
		// TODO
		return null;
	}

}
