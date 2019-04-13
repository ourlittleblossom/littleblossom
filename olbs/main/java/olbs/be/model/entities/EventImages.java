package olbs.be.model.entities;
// Generated 13-Apr-2019, 9:07:50 PM by Hibernate Tools 5.2.12.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * EventImages generated by hbm2java
 */
@Entity
@Table(name = "event_images", catalog = "olbs")
public class EventImages implements java.io.Serializable {

	private EventImagesId id;
	private String eventDescription;
	private String imageFolderPath;

	public EventImages() {
	}

	public EventImages(EventImagesId id) {
		this.id = id;
	}

	public EventImages(EventImagesId id, String eventDescription, String imageFolderPath) {
		this.id = id;
		this.eventDescription = eventDescription;
		this.imageFolderPath = imageFolderPath;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "eventName", column = @Column(name = "event_name", nullable = false, length = 50)),
			@AttributeOverride(name = "eventDate", column = @Column(name = "event_date", nullable = false, length = 0)) })
	public EventImagesId getId() {
		return this.id;
	}

	public void setId(EventImagesId id) {
		this.id = id;
	}

	@Column(name = "event_description", length = 65535)
	public String getEventDescription() {
		return this.eventDescription;
	}

	public void setEventDescription(String eventDescription) {
		this.eventDescription = eventDescription;
	}

	@Column(name = "image_folder_path", length = 100)
	public String getImageFolderPath() {
		return this.imageFolderPath;
	}

	public void setImageFolderPath(String imageFolderPath) {
		this.imageFolderPath = imageFolderPath;
	}

}
