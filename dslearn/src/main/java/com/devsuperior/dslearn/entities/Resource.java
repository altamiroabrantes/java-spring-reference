 package com.devsuperior.dslearn.entities;

import java.io.Serializable;
import java.util.Objects;

import com.devsuperior.dslearn.entities.enums.ResourceType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_resource")
public class Resource implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@SuppressWarnings("unused")
	private String title;
	@SuppressWarnings("unused")
	private String description;
	@SuppressWarnings("unused")
	private Integer position;
	@SuppressWarnings("unused")
	private String imgUri;
	@SuppressWarnings("unused")
	private ResourceType type;
	
	@ManyToOne
	@JoinColumn(name = "offer_id")
	private Offer offer;

	public Resource() {}

	public Resource(Long id, String title, String description, Integer position, String imgUri,
			ResourceType type, Offer offer) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.position = position;
		this.imgUri = imgUri;
		this.type = type;
		this.offer = offer;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Resource other = (Resource) obj;
		return Objects.equals(id, other.id);
	}
	 
}
