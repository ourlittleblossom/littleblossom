package olbs.be.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import olbs.be.bean.EventDetailsBean;
import olbs.be.bean.GalleryDetailsBean;
import olbs.be.constants.Constants;

import olbs.be.data.MemCache;
import olbs.be.model.entities.EventImages;

import olbs.be.model.repositories.GalleryDetailsRepository;

@Service
public class GalleryDetailsService {
	private static final Logger LOGGER = LoggerFactory.getLogger(GalleryDetailsService.class);

	@Autowired
	private GalleryDetailsRepository galleryRepository;

	public GalleryDetailsBean getGalleryDetails() {
		Iterator<EventImages> eventDetails = galleryRepository.findAll().iterator();
		GalleryDetailsBean galleryResponse = new GalleryDetailsBean();
		List<EventDetailsBean> eventList = new ArrayList<>();
		EventDetailsBean event = new EventDetailsBean();
		galleryResponse.setRespCode(Constants.MINUS_INT);
		galleryResponse.setRespMsg(Constants.FAILURE);
		int i = 0;

		while (eventDetails.hasNext()) {
			galleryResponse.setRespCode(Constants.ZERO_INT);
			galleryResponse.setRespMsg(Constants.SUCCESS);
			EventImages eventImage = eventDetails.next();
			event.setEventName(eventImage.getId().getEventName());
			event.setEventDate(eventImage.getId().getEventDate());
			event.setEventDescription(eventImage.getEventDescription());
			event.setImages(getImages(eventImage.getImageFolderPath()));
			eventList.add(i++, event);
			event = new EventDetailsBean();
		}
		galleryResponse.setEventDetails(eventList);
		return galleryResponse;
	}

	private List<String> getImages(String imageFolderPath) {
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
	
	private boolean isFileValid(String fileName) {
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
}
