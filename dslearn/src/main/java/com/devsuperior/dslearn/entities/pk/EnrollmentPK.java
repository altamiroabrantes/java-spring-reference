package com.devsuperior.dslearn.entities.pk;

import java.io.Serializable;

import com.devsuperior.dslearn.entities.Offer;
import com.devsuperior.dslearn.entities.User;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@Embeddable
public class EnrollmentPK implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "offer_id")
	private Offer offer;
	
	
}
