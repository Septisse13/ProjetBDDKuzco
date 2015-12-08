package fr.esisar.panier.dao;

public interface LoDaoPersonne<T> {
	public T getByMail(String mail);
}
