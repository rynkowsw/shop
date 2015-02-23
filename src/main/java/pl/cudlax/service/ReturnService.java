package pl.cudlax.service;

import java.util.List;

import pl.cudlax.domain.Return;

public interface ReturnService {
	List<Return> getReturns();
	
	Return getReturn(Long returnID);
	
	void createReturn(Return r);
	
	void updateReturn(Return r);
	
	void removeReturn(Return r);
}
