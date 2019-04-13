package olbs.be.data;

import java.util.HashMap;
import java.util.Map;

public class MemCache {
	
	protected static Map<String,String> configurationMap = new HashMap<>();

	public static Map<String, String> getConfigurationMap() {
		return configurationMap;
	}

	public static void setConfigurationMap(Map<String, String> configurationMap) {
		MemCache.configurationMap = configurationMap;
	}

}
