package olbs.be.service;

import java.util.Iterator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import olbs.be.bean.HomeBean;
import olbs.be.constants.Constants;

import olbs.be.model.entities.EventImages;

import olbs.be.model.repositories.GalleryDetailsRepository;
import olbs.be.utility.CommonUtils;

@Service
public class HomeService {
	private static final Logger LOGGER = LoggerFactory.getLogger(HomeService.class);

	@Autowired
	private GalleryDetailsRepository galleryRepository;

	public HomeBean getHomeDetails() {
		Iterator<EventImages> eventDetails = galleryRepository.findAll().iterator();
		HomeBean homeResponse = new HomeBean();
		homeResponse.setRespCode(Constants.MINUS_ONE_INT);
		homeResponse.setRespMsg(Constants.FAILURE);
		while (eventDetails.hasNext()) {
			EventImages eventImage = eventDetails.next();
			if (Constants.HOME_IMAGE_REQUEST_TYPE.equalsIgnoreCase(eventImage.getId().getEventName())) {
				homeResponse.setRespCode(Constants.ZERO_INT);
				homeResponse.setRespMsg(Constants.SUCCESS);
				LOGGER.info("Filling image details for:{}", eventImage.getId().getEventName());
				homeResponse.setImages(CommonUtils.getImages(eventImage.getImageFolderPath()));
			}
		}
		return homeResponse;
	}
}
