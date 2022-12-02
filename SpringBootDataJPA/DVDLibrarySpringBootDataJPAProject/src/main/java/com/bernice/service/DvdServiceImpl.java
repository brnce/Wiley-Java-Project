package com.bernice.service;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bernice.entity.DVD;
import com.bernice.persistence.DvdDao;

@Service("service")
public class DvdServiceImpl implements DvdService{
	
	@Autowired
	private DvdDao dvdDao;

	@Override
	public Collection<DVD> getAllDVDs() {
		return dvdDao.findAll();
	}

	@Override
	public DVD searchDVDbyID(int id) {
		return dvdDao.findById(id).orElse(null);
	}
	
	@Override
	public boolean addDVD(DVD dvd) {
		if (searchDVDbyID(dvd.getDvdID()) == null) {
			// save means : save and update
			dvdDao.save(dvd);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteDVD(int id) {
		if (searchDVDbyID(id) != null) {
			dvdDao.deleteById(id);
			return true;
		}
		return false;
	}

	@Override
	public boolean editDVD(DVD dvd) {
		// TODO Auto-generated method stub
		return false;
	}

	
	

}
