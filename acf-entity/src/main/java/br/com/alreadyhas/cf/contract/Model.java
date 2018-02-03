package br.com.alreadyhas.cf.contract;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;

/**
 * <h2>Model</h2>
 * <hr />
 * <p>This class serves as the basis for other entities. 
 * At first all entities need the ID and date of registration.</p>
 * <hr />
 * 
 * @author Matheus Franco
 * @category Base
 * @version 0.1
 * @see br.com.alreadyhas.cf.model.*
 *
 */
public abstract class Model implements Serializable{

	private static final long serialVersionUID = 7711505254065841534L;

	@Id
	@Column(name = "KEY", nullable = false)
	private Long id;

	@Column(name = "REGISTRATION_DATE", nullable = false)
	private Date registrationDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Model other = (Model) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format(" | Class: %s | ID: %d | ", getClass().getSimpleName(), id);
	}
}
