package br.com.alreadyhas.cf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.TableGenerator;

import br.com.alreadyhas.cf.model.contract.Model;
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
@TableGenerator(name = "ACHIEVEMENT")
public class Achievement extends Model {

	private static final long serialVersionUID = 3159229503562249969L;

	@Getter
	@Setter
	@Column(name = "ACHIEVEMENT_NAME", nullable = false)
	private String achievementName;

	@Getter
	@Setter
	@Column(name = "ACHIEVEMENT_DESCRIPTION", nullable = false)
	private String achievementDescription;

	@Getter
	@Setter
	@Lob
	@Column(name = "PHOTO", nullable = false, columnDefinition = "BLOB")
	private byte[] achievementPhoto;

	public Achievement() {/**/}

	public Achievement(Long id) {
		super(id);
	}

	public Achievement(String name, String description) {
		this.achievementName = name;
		this.achievementDescription = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((achievementDescription == null) ? 0 : achievementDescription.hashCode());
		result = prime * result + ((achievementName == null) ? 0 : achievementName.hashCode());
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
		if (achievementDescription == null) {
			if (other.achievementDescription != null)
				return false;
		} else if (!achievementDescription.equals(other.achievementDescription))
			return false;
		if (achievementName == null) {
			if (other.achievementName != null)
				return false;
		} else if (!achievementName.equals(other.achievementName))
			return false;
		return true;
	}

}
