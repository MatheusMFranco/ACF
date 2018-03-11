package br.com.alreadyhas.cf.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import br.com.alreadyhas.cf.contract.Model;
import lombok.Getter;
import lombok.Setter;

/**
 * <h2>Friendship</h2>
 * <hr />
 * <p>
 * This class represents the friendship.
 * </p>
 * <hr />
 * 
 * @author Matheus Franco
 * @category Model
 * @version 0.1
 * @see br.com.alreadyhas.cf.model.UserChampion
 *
 */
@Entity
public class Friendship extends Model {

	private static final long serialVersionUID = 1893408591406642299L;

	/**
	 * @see br.com.alreadyhas.cf.model.UserChampion
	 */
	@Getter
	@Setter
	@Column(name = "FRIENDSHIP_USER", nullable = false)
	private Integer user;

	/**
	 * @see br.com.alreadyhas.cf.model.UserChampion
	 */
	@Getter
	@Setter
	@Column(name = "FRIEND", nullable = false)
	private Integer friend;

	@Getter
	@Setter
	@Column(name = "AMOUNT_BATTLE", nullable = false)
	private Integer amountBattle;

	public Friendship() {/**/}

	public Friendship(Long id) {
		super(id);
	}

	public Friendship(Integer user, Integer friend, Integer amountBattle) {
		this.user = user;
		this.friend = friend;
		this.amountBattle = amountBattle;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((amountBattle == null) ? 0 : amountBattle.hashCode());
		result = prime * result + ((friend == null) ? 0 : friend.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Friendship other = (Friendship) obj;
		if (amountBattle == null) {
			if (other.amountBattle != null)
				return false;
		} else if (!amountBattle.equals(other.amountBattle))
			return false;
		if (friend == null) {
			if (other.friend != null)
				return false;
		} else if (!friend.equals(other.friend))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

}
