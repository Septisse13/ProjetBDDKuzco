package fr.esisar.panier.dao;

import java.util.List;

public interface LoDao<T> {
	public List<T> find(String conditions);
	public boolean create(T newRecord);
	public boolean update(T updateRecord);
	public boolean remove(T removeRecord);
}
