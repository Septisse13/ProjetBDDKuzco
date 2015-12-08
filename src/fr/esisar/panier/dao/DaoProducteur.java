package fr.esisar.panier.dao;

import java.util.List;

import fr.esisar.panier.metier.Producteur;

public class DaoProducteur implements LoDaoPersonne<Producteur>, LoDao<Producteur> {

	@Override
	public List<Producteur> find(String conditions) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Producteur newRecord) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Producteur updateRecord) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Producteur removeRecord) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Producteur getByMail(String mail) {
		// TODO Auto-generated method stub
		return null;
	}

}
