package negocio;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.JDBCETypeDAO;
import modelo.EType;

@Service
public class ETypeBL {
	
	@Autowired
	JDBCETypeDAO dao;
	
	public void createEmoji(EType t){
		dao.createEType(t);
	}
	
	public List<EType> listEType(){
		return dao.listEType();
	}
}
