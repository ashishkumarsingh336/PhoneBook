package com.example.domain;

import lombok.Data;

/**
 * 
 * @author Ashish
 * @version 1.0
 * @since 22.12.2019
 *
 */

@Data
public class Contact {

	private Integer contactId;
	private String contactName;
	private String contactEmail;
	private Long phNo;
	private String activeSw;
}
