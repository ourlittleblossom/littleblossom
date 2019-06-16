package olbs.be.utility;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import olbs.be.bean.EventDetailsBean;
import olbs.be.constants.Constants;
import olbs.be.data.MemCache;


public class CommonUtils {
	private static final Logger LOGGER = LoggerFactory.getLogger(CommonUtils.class);
	public static List<String> getImages(String imageFolderPath) {
		File directory = new File(MemCache.getConfigurationMap().get(Constants.SERVER_IMAGE_ABSOLUTE_PATH) + imageFolderPath);
		LOGGER.info("getting images from path:{}"
				,MemCache.getConfigurationMap().get(Constants.SERVER_IMAGE_ABSOLUTE_PATH) + imageFolderPath);
		List<String> images = new ArrayList<>();
		File[] fList = directory.listFiles();
		if (null != fList) {
			for (File file : fList) {
				if (file.isFile() && isFileValid(file.getName())) {
				
					LOGGER.debug("adding image:{}"
							, MemCache.getConfigurationMap().get(Constants.SERVER_IMAGE_PREFIX_PATH)+imageFolderPath + file.getName());
					images.add(MemCache.getConfigurationMap().get(Constants.SERVER_IMAGE_PREFIX_PATH)+imageFolderPath + file.getName());
				}
			}
		}
		return images;
	}
	
	private static boolean isFileValid(String fileName) {
		boolean result = false;
		int i = fileName.lastIndexOf('.');
		if (i > 0) {
		    String extension = fileName.substring(i+1);
		    if(Constants.ALLOWED_IMAGE_FORMAT.contains(extension)) {
		    	result = true;
		    }
		}
		return result;
	}
	
	public static List<String> getImageTitle(EventDetailsBean event) {
		List<String> imageTitle = new ArrayList<>();
		for(int i=0;i<event.getImages().size();i++) {
			imageTitle.add(event.getEventName().toUpperCase()+Constants.UNDERSCORE+String.valueOf(i));
		}
		return imageTitle;
	}
}
