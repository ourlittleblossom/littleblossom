package olbs.be.service;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;


import olbs.be.constants.Constants;
import olbs.be.data.MemCache;
import olbs.be.model.entities.Configuration;
import olbs.be.model.repositories.ConfigurationRepository;

@Component
public final class DbCacheReloadService extends MemCache implements ApplicationListener<ApplicationReadyEvent>{
	@Autowired
	private ConfigurationRepository configurationRepository;

	@Override
	public void onApplicationEvent(ApplicationReadyEvent arg0) {
		loadConfigurationMap();
		
	}
	
	public boolean reloadCache(String reloadType) {
		boolean result = true;
		if(Constants.RELOAD_TYPE_ALL.equalsIgnoreCase(reloadType)) {
			result =  loadConfigurationMap();
		}else if(Constants.RELOAD_TYPE_CONFIG.equalsIgnoreCase(reloadType)) {
			result = loadConfigurationMap();
		}
		return result;
	}
	
	public boolean loadConfigurationMap() {
		boolean result = false;
		Iterator<Configuration> configIterator = configurationRepository.findAll().iterator();
		while(configIterator.hasNext()) {
			result = true;
			Configuration configObj = configIterator.next();
			configurationMap.put(configObj.getParameter(), (String) configObj.getValue());
		}
		return result;
	}


	
}
