package olbs.be.bean;

import java.time.LocalDate;
import java.util.List;

public class EventDetailsBean {
	private String eventName;
	protected LocalDate eventDate;
	private String eventDescription;

	private List<String> images; 
	private List<String> titles;
	private Integer index;
	private boolean isOpen;
	private String mainSrc;
	private Integer remainingImages;
	
	public String getEventName() {
		return eventName;
	}
	public void setEventName(String eventName) {
		this.eventName = eventName;
	}
	public LocalDate getEventDate() {
		return eventDate;
	}
	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}
	public String getEventDescription() {
		return eventDescription;
	}
	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	public List<String> getImages() {
		return images;
	}
	public void setImages(List<String> images) {
		this.images = images;
	}
	public List<String> getTitles() {
		return titles;
	}
	public void setTitles(List<String> titles) {
		this.titles = titles;
	}
	public Integer getIndex() {
		return index;
	}
	public void setIndex(Integer index) {
		this.index = index;
	}
	public boolean isOpen() {
		return isOpen;
	}
	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}
	public String getMainSrc() {
		return mainSrc;
	}
	public void setMainSrc(String mainSrc) {
		this.mainSrc = mainSrc;
	}
	public Integer getRemainingImages() {
		return remainingImages;
	}
	public void setRemainingImages(Integer remainingImages) {
		this.remainingImages = remainingImages;
	}
	
}
