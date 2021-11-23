package com.j2ee.tdspring.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {
	
	 	@Id
	    @Column(name="Username")
	    private String username;

	    @Column(name="firstname", length=30, nullable=false)
	    private String firstname;

	    
	    @Column(name="lastname", length=30, nullable=false)
	    private String lastname;

	    @Column(name="telephone")
	    private int telephone;

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getFirstname() {
			return firstname;
		}

		public void setFirstname(String firstname) {
			this.firstname = firstname;
		}

		public String getLastname() {
			return lastname;
		}

		public void setLastname(String lastname) {
			this.lastname = lastname;
		}

		public int getTelephone() {
			return telephone;
		}

		public void setTelephone(int telephone) {
			this.telephone = telephone;
		}

}
