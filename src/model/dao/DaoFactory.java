package model.dao;

import db.DB;
import model.dao.impl.CidadeDaoJDBC;

public class DaoFactory {
	
	
	public static CidadeDao createCidadeDao() {
		return new CidadeDaoJDBC(DB.getConnection());
		
	}

}
