package pl.cudlax.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.cudlax.dao.ConsignmentDAO;
import pl.cudlax.domain.Consignment;
import pl.cudlax.service.ConsignmentService;
@Service
public class ConsignmentServiceImpl implements ConsignmentService{
	@Autowired
	ConsignmentDAO dao;

	@Override
	public List<Consignment> getConsigmnentList() {
		return dao.getConsigmnentList();
	}

	@Override
	public Consignment getConsignment(Long consignmentID) {
		return dao.getConsignment(consignmentID);
	}

	@Override
	public List<Consignment> getConsingments(boolean isActive) {
		return dao.getConsingments(isActive);
	}

	@Override
	public void updateConsignment(Consignment c) {
		dao.updateConsignment(c);
	}

	@Override
	public void createConsignment(Consignment c) {
		dao.createConsignment(c);
	}

	@Override
	public void removeConsignment(Consignment c) {
		dao.removeConsignment(c);
	}
}
