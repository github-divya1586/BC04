package com.configurations;

import com.dao.DAO;
import com.model.KycModel;
import com.service.UploadKycService;

public class AppConfig {
	
	public static KycModel getKycmodel() {
		return new KycModel();
	}
	
	public static DAO getDao() {
	   return new DAO();
	}
	
	public static UploadKycService getuploadKycService() {
		return new UploadKycService();
	}
	

}
