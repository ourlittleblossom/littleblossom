package olbs.be.service;


import org.springframework.stereotype.Service;


import olbs.be.data.MemCache;

@Service
public class ConfigurationService {

	public String getConfiguration(String requestType) {
		return MemCache.getConfigurationMap().get(requestType);
	}
	
}
