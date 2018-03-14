package br.com.alreadyhas.cf.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.alreadyhas.cf.contract.Model;
import lombok.Getter;
import lombok.Setter;

/**
 * <h2>ProfileAchievement</h2>
 * <hr />
 * <p>This class represents the user's achievements.</p>
 * <hr />
 * 
 * @author Matheus Franco
 * @category Model
 * @version 0.1
 * @see br.com.alreadyhas.cf.model.ProfileChampion
 * @see br.com.alreadyhas.cf.model.Achievement
 *
 */
@Entity
public class ProfileAchievement extends Model {

	private static final long serialVersionUID = 6444495491738867386L;

	/**
	 * @see br.com.alreadyhas.cf.model.ProfileChampion
	 **/
	@Getter 
	@Setter
	@ManyToOne
	@JoinColumn(name = "USER_ACHIEVEMENT", nullable = false)
	private ProfileChampion userProfile;

	/**
	 * @see br.com.alreadyhas.cf.model.Achievement
	 **/
	@Getter 
	@Setter
	@ManyToOne
	@JoinColumn(name = "ACHIEVEMENT", nullable = false)
	private Achievement achievement;

	public ProfileAchievement() {/**/}

	public ProfileAchievement(Long id) {
		super(id);
	}

	public ProfileAchievement(ProfileChampion user, Achievement achievement) {
		this.userProfile = user;
		this.achievement = achievement;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((achievement == null) ? 0 : achievement.hashCode());
		result = prime * result + ((userProfile == null) ? 0 : userProfile.hashCode());
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
		ProfileAchievement other = (ProfileAchievement) obj;
		if (achievement == null) {
			if (other.achievement != null)
				return false;
		} else if (!achievement.equals(other.achievement))
			return false;
		if (userProfile == null) {
			if (other.userProfile != null)
				return false;
		} else if (!userProfile.equals(other.userProfile))
			return false;
		return true;
	}

}
