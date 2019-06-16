package olbs.be.service;

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
import olbs.be.utility.CommonUtils;

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
		galleryResponse.setRespCode(Constants.MINUS_ONE_INT);
		galleryResponse.setRespMsg(Constants.FAILURE);
		int i = 0;

		while (eventDetails.hasNext()) {
			galleryResponse.setRespCode(Constants.ZERO_INT);
			galleryResponse.setRespMsg(Constants.SUCCESS);
			EventImages eventImage = eventDetails.next();
			if (!Constants.HOME_IMAGE_REQUEST_TYPE.equalsIgnoreCase(eventImage.getId().getEventName())) {
				LOGGER.info("Filling image details for:{}",eventImage.getId().getEventName());
				event.setEventName(eventImage.getId().getEventName().toUpperCase());
				event.setEventDate(eventImage.getId().getEventDate());
				event.setEventDescription(eventImage.getEventDescription());
				event.setImages(CommonUtils.getImages(eventImage.getImageFolderPath()));
				event.setMainSrc(event.getImages().get(0));
				event.setTitles(CommonUtils.getImageTitle(event));
				event.setRemainingImages(event.getImages().size()-Constants.ONE_INT);
				event.setOpen(Constants.BOOLEAN_FALSE);
				event.setIndex(Constants.ZERO_INT);
				eventList.add(i++, event);
			}
			event = new EventDetailsBean();
		}
		galleryResponse.setClickOutsideToClose(Boolean.parseBoolean(MemCache.getConfigurationMap().get(Constants.CLICK_OUTSIDE_TO_CLOSE)));
		galleryResponse.setDiscourageDownloads(Boolean.parseBoolean(MemCache.getConfigurationMap().get(Constants.DISCOURAGE_DOWNLOADS)));
		galleryResponse.setEventDetails(eventList);
		return galleryResponse;
	}

}
