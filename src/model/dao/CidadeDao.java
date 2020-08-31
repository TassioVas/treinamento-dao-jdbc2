package model.dao;

import java.util.List;

import model.entites.Cidade;
import model.entites.Estado;

public interface CidadeDao {
	
	void insert(Cidade obj);
	void update(Cidade obj);
	void deleteById(Integer id);
	Cidade findBySigla(String sigla);
	List<Cidade> findAll();
	List<Cidade> findByEstado(Estado estado);
	List<Cidade> findSP(String sigla);
	List<Cidade> findSPExists(String sigla);

}
