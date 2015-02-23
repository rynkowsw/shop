package pl.cudlax.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.cudlax.dao.ReturnDAO;
import pl.cudlax.domain.Return;
import pl.cudlax.service.ReturnService;
@Service
public class ReturnServiceImpl implements ReturnService {
	@Autowired
	ReturnDAO dao;
	@Override
	public List<Return> getReturns() {
		return dao.getReturns();
	}

	@Override
	public Return getReturn(Long returnID) {
		return dao.getReturn(returnID);
	}

	@Override
	public void createReturn(Return r) {
		dao.createReturn(r);
	}

	@Override
	public void updateReturn(Return r) {
		dao.updateReturn(r);
	}

	@Override
	public void removeReturn(Return r) {
		dao.removeReturn(r);
	}

}
