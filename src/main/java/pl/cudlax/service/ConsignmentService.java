package pl.cudlax.service;

import java.util.List;

import pl.cudlax.domain.Consignment;

public interface ConsignmentService {
	List<Consignment> getConsigmnentList();
	
	Consignment getConsignment(Long consignmentID);
	
	List<Consignment> getConsingments(boolean isActive);
	
	void updateConsignment(Consignment c);
	
	void createConsignment(Consignment c);
	
	void removeConsignment(Consignment c);
}
