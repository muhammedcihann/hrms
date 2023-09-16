package com.example.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hrms.business.abstracts.JobSeekerService;
import com.example.hrms.core.utilities.results.DataResult;
import com.example.hrms.core.utilities.results.ErrorResult;
import com.example.hrms.core.utilities.results.Result;
import com.example.hrms.core.utilities.results.SuccessDataResult;
import com.example.hrms.core.utilities.results.SuccessResult;
import com.example.hrms.core.utilities.verifications.EmailVerifyService;
import com.example.hrms.dataAccess.abstracts.JobSeekerDao;
import com.example.hrms.dataAccess.abstracts.UserDao;
import com.example.hrms.entities.concretes.JobSeeker;
import com.example.hrms.entities.concretes.User;


@Service
public class JobSeekerManager implements JobSeekerService{
	@Autowired
	private JobSeekerDao jobSeekerDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
    private EmailVerifyService emailVerifyService;
	
	
	@Override
	public Result register(JobSeeker jobSeeker) {
		User user = jobSeeker.getUser(); 
		
		
		if(user.getEmail().isEmpty() || user.getPassword().isEmpty() || user.getConfirm_password().isEmpty()||jobSeeker.getName().isEmpty() || jobSeeker.getSurname().isEmpty() || jobSeeker.getNationallyId().isEmpty() || jobSeeker.getBirthYear().isEmpty()) {
			
			return new ErrorResult("Boş Alan Bırakmayınız.");
		}
		
		 if (userDao.existsByEmail(user.getEmail())) {
		        return new ErrorResult("Bu e-posta adresi zaten kaydedilmiş.");
		    }
		 
		 else if (jobSeekerDao.existsByNationallyId(jobSeeker.getNationallyId())) {
			 
			 return new ErrorResult("Bu TC Kimlik No zaten kayıtlıdır.");
		 }
		 
		else {

			 if (user.getPassword().equals(user.getConfirm_password())) {
	                // Doğrulama kodu üretilip kullanıcıya atandı
	                String emailVerificationCode = emailVerifyService.generateVerificationCode();
	                
	                jobSeeker.getUser().setEmailVerificationCode(emailVerificationCode);

	                this.jobSeekerDao.save(jobSeeker);

	                Result emailVerifyResult = emailVerifyService.verify(user.getEmail());
	                if (!emailVerifyResult.isSuccess()) {
	                    return emailVerifyResult;
	                }
	                
	                return new SuccessResult("Kullanıcı Eklendi");

	            } 
			 	else {
				 
	                return new ErrorResult("Parolanız Eşleşmedi.");
			 	}
	        }
	    }


	@Override
	public DataResult<List<JobSeeker>> getAll() {
		
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "İş Arayanlar Listelendi!");
	}
	
	}
