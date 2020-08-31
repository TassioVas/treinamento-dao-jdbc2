package application;

import java.util.Date;
import java.util.List;

import model.dao.CidadeDao;
import model.dao.DaoFactory;
import model.entites.Cidade;

public class Pogram {

	public static void main(String[] args) {

		System.out.println("==== teste1: ======");
		CidadeDao cidadeDao = DaoFactory.createCidadeDao();
		
		// Cidade cidade = cidadeDao.findBySigla("sp");
		
		
	
		
		
		System.out.println("==== 6 - Selecionar o nome das cidades de SP:\r\n" + 
				"	6.1 - usando o JOIN\r\n" + 
				"\r\n" + 
				"	6.2 - usando o EXISTS\r\n" + 
				" ======");
		
		
		//Select do excercicio 6
		
		List<Cidade> list = cidadeDao.findSP("sp");
			for (Cidade obj : list) {
				System.out.println(obj);
			}

		/* List<Cidade> list1 = cidadeDao.findSPExists("sp");
		for (Cidade obj : list1) {
		    System.out.println(obj);
		} */
	 //inserindo uma cidade nova
		 System.out.println("==== inserindo uma nova cidade ======");
		Cidade newCidade = new Cidade(27, "ituiutaba", 1, new Date(), null);
		cidadeDao.insert(newCidade);
		System.out.println("inserido a cidade: " + newCidade.getNome());
		
		
		
		/* System.out.println("==== update======");
		cidade.setNomeme()
		cidadeDao.update(Cidade);
		System.out.println("completo"); */
		
		
	
	}

}
