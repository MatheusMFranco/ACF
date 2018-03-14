package br.com.alreadyhas.cf.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.alreadyhas.cf.contract.Model;
import lombok.Getter;
import lombok.Setter;

/**
 * <h2>ProfileSkill</h2>
 * <hr />
 * <p>This class represents the user's skills.</p>
 * <hr />
 * 
 * @author Matheus Franco
 * @category Model
 * @version 0.1
 * @see br.com.alreadyhas.cf.model.ProfileChampion
 * @see br.com.alreadyhas.cf.model.Skill
 *
 */
@Entity
public class ProfileSkill extends Model {

	private static final long serialVersionUID = -2532446241101559140L;

	/**
	 * @see br.com.alreadyhas.cf.model.ProfileChampion
	 **/
	@Getter 
	@Setter
	@ManyToOne
	@JoinColumn(name = "USER_SKILL", nullable = false)
	private ProfileChampion userSkill;

	/**
	 * @see br.com.alreadyhas.cf.model.Skill
	 **/
	@Getter 
	@Setter
	@ManyToOne
	@JoinColumn(name = "SKILL", nullable = false)
	private Skill skill;

	public ProfileSkill() {/**/}

	public ProfileSkill(Long id) {
		super(id);
	}

	public ProfileSkill(ProfileChampion user, Skill skill) {
		this.userSkill = user;
		this.skill = skill;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((skill == null) ? 0 : skill.hashCode());
		result = prime * result + ((userSkill == null) ? 0 : userSkill.hashCode());
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
		ProfileSkill other = (ProfileSkill) obj;
		if (skill == null) {
			if (other.skill != null)
				return false;
		} else if (!skill.equals(other.skill))
			return false;
		if (userSkill == null) {
			if (other.userSkill != null)
				return false;
		} else if (!userSkill.equals(other.userSkill))
			return false;
		return true;
	}

}
