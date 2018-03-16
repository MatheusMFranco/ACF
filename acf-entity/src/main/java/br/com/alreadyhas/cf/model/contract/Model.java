package br.com.alreadyhas.cf.model.contract;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.alreadyhas.cf.util.DateUtil;
import lombok.Data;

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
 *
 */
@Data
@MappedSuperclass
public abstract class Model implements Serializable{

	private static final long serialVersionUID = 7711505254065841534L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "KEY_ID", nullable = false)
	private Long id;

	@Temporal(TemporalType.DATE)
	@Column(name = "REGISTRATION_DATE", nullable = false)
	private Date registrationDate;

	public Model() {/**/}

	public Model(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format(" | Date: %s | Class: %s | ID: %d | ", DateUtil.getDefaultFormat(), getClass().getSimpleName(), id);
	}

}
