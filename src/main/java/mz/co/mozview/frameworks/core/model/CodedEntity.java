/*
 * MozView Technologies, Lda. 2010 - 2016
 */
package mz.co.mozview.frameworks.core.model;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * @author Eudson Bambo
 * 		
 */
@MappedSuperclass
public class CodedEntity extends GenericEntity
{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "CODE", nullable = false, length = 255, unique = true)
	private String code;
	
	@Column(name = "DESCRIPTION", length = 255)
	private String description;
	
	public String getCode()
	{
		return this.code;
	}
	
	public void setCode(final String code)
	{
		this.code = code;
	}
	
	public String getDescription()
	{
		return this.description;
	}
	
	public void setDescription(final String description)
	{
		this.description = description;
	}
}
