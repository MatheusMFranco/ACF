package br.com.alreadyhas.cf.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.com.alreadyhas.cf.contract.Model;
import lombok.Getter;
import lombok.Setter;

/**
 * <h2>Achievement</h2>
 * <hr />
 * <p>
 * This class represents the achievements.
 * </p>
 * <hr />
 * 
 * @author Matheus Franco
 * @category Model
 * @version 0.1
 *
 */
@Entity
public class Achievement extends Model {

	private static final long serialVersionUID = 3159229503562249969L;

	@Getter
	@Setter
	@Column(name = "ACHIEVEMENT_NAME", nullable = false)
	private String name;

	@Getter
	@Setter
	@Column(name = "ACHIEVEMENT_DESCRIPTION", nullable = false)
	private String description;

	@Getter
	@Setter
	@Column(name = "PHOTO", nullable = false)
	private byte[] photo;

	public Achievement() {/**/}

	public Achievement(Long id) {
		super(id);
	}

	public Achievement(String name, String description, byte[] photo) {
		this.name = name;
		this.description = description;
		this.photo = photo;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + Arrays.hashCode(photo);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Achievement other = (Achievement) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (!Arrays.equals(photo, other.photo))
			return false;
		return true;
	}

}
