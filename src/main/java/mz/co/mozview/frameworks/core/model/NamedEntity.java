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
public class NamedEntity extends CodedEntity
{
	private static final long serialVersionUID = 1L;
	
	@Column(name = "NAME", nullable = false)
	private String name;
	
	public String getName()
	{
		return this.name;
	}
	
	public void setName(final String name)
	{
		this.name = name;
	}
}
