package fr.esisar.panier.dao;

import java.util.List;

import fr.esisar.panier.metier.Consommateur;

public class DaoConsommateur implements LoDao<Consommateur>, LoDaoPersonne<Consommateur> {

	@Override
	public Consommateur getByMail(String mail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Consommateur> find(String conditions) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(Consommateur newRecord) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(Consommateur updateRecord) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(Consommateur removeRecord) {
		// TODO Auto-generated method stub
		return false;
	}

}
