package com.api.security.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name="tbl_user")
@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class User implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(nullable=false, updatable=false)
	private long id ;
	
	private String userId;
	private String firstName;
	private String lastName;
	private String username;
	private String password;
	private String email;
	private String profileImageUrl;
	private Date lastLoginDate;
	private Date lastLoginDateDisplay;
	private Date joinDate;
	private String[] roles; // ROLES_USER {create, delete, update} ROLES_ADMIN{delete}
	private String[] authorities;
	private boolean isActive;
	private boolean isNotLocked;
	
	
	
	
}
