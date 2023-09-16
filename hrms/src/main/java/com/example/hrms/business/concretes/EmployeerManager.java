package com.example.hrms.business.concretes;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.EmployeerService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.core.utilities.validators.EmailFormatValidator;
import com.example.hrms.dataAccess.abstracts.EmployeerDao;
import com.example.hrms.dataAccess.abstracts.UserDao;
import com.example.hrms.entities.concretes.Employeer;
import com.example.hrms.entities.concretes.User;

@Service
public class EmployeerManager implements EmployeerService{
	@Autowired
	EmployeerDao employeerDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private EmailFormatValidator emailFormatValidator;
	
	
	@Override
	public Result register(Employeer employeer) {
		User user = employeer.getUser();
		
		if(user.getEmail().isEmpty() || user.getPassword().isEmpty() || user.getConfirm_password().isEmpty() 
				|| employeer.getCompanyName().isEmpty() || employeer.getPhoneNumber().isEmpty() || 
					employeer.getWebsite().isEmpty()) {
			
			return new ErrorResult("Lütfen Boş Alan Bırakmayınız");
			
		}
		else  if (!emailFormatValidator.checkEmailFormat(user.getEmail(), employeer.getWebsite())) {
	        return new ErrorResult("Bu domain şirketiniz email adresiyle uyumlu değildir!");
	    }
		
		else  if (userDao.existsByEmail(user.getEmail())) {
	        return new ErrorResult("Bu e-posta adresi zaten kaydedilmiş.");
	    }
		
		else {
			
			this.employeerDao.save(employeer);
			return new SuccessResult("Şirket Eklendi!");
		}
		
	}


	@Override
	public DataResult<List<Employeer>> getAll() {
		
		return new SuccessDataResult<List<Employeer>>(this.employeerDao.findAll(), "İş Verenler Listelendi!");
	}

}
