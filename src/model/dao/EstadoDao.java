package model.dao;

import java.util.List;

import model.entites.Cidade;
import model.entites.Estado;

public interface EstadoDao {
	
	void insert(Estado obj);
	void update(Estado obj);
	void deleteById(Integer id);
	Estado findBySigla(String sigla);
	List<Estado> findAll();
	
}
