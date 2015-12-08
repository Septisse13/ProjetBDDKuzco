package fr.esisar.panier.dao;

import java.util.List;

import fr.esisar.panier.metier.BDE;

public class DaoBDE implements LoDao<BDE>, LoDaoPersonne<BDE> {

	@Override
	public BDE getByMail(String mail) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BDE> find(String conditions) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean create(BDE newRecord) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(BDE updateRecord) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean remove(BDE removeRecord) {
		// TODO Auto-generated method stub
		return false;
	}

}
