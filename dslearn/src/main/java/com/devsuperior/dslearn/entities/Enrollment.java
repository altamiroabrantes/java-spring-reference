package com.devsuperior.dslearn.entities;

import java.time.Instant;

import com.devsuperior.dslearn.entities.pk.EnrollmentPK;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_enrollment")
public class Enrollment {
	
	@EmbeddedId
	private EnrollmentPK id = new EnrollmentPK();
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant enrollMoment;
	
	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant refundMoment;
	
	private boolean available;
	private boolean onlyUpdate;
	
	public Enrollment() {}
	
	public Enrollment(User user, Offer offer, Instant enrollMoment, Instant refundMoment, boolean available,
			boolean onlyUpdate) {
		super();
		this.id.setUser(user);
		this.id.setOffer(offer);
		this.enrollMoment = enrollMoment;
		this.refundMoment = refundMoment;
		this.available = available;
		this.onlyUpdate = onlyUpdate;
	}
	
	public User getStudent() {
		return this.id.getUser();
	}
	
	public void setStudent(User user) {
		this.id.setUser(user);
	}
	
	public Offer getOffer() {
		return this.id.getOffer();
	}
	
	public void setOffer(Offer offer) {
		this.id.setOffer(offer);
	}

}
