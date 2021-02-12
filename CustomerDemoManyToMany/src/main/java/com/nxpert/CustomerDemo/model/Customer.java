package com.nxpert.CustomerDemo.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "customer")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id",scope = Customer.class)
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id", unique = true)
	Integer id;

	@Column(name = "name")
	String name;
	
	@ManyToMany 
	@JoinTable(name = "customer_consultants", 
				joinColumns = {
								@JoinColumn(name = "customer_id") 
							  }, inverseJoinColumns = { @JoinColumn(name = "consultants_id") }
			  )
	Set<Consultant> consultants = new HashSet<Consultant>();
	
	
	public Set<Consultant> getConsultants() {
		return consultants;
	}

	public void setConsultants(Set<Consultant> consultants) {
		this.consultants = consultants;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
