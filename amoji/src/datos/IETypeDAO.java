package datos;

import java.util.List;

import modelo.EType;


public interface IETypeDAO {
	void createEType(EType t);
	List<EType> listEType();
}
