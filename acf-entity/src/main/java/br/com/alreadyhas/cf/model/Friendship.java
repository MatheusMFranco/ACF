package br.com.alreadyhas.cf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.TableGenerator;

import br.com.alreadyhas.cf.model.contract.Model;
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
 * @see br.com.alreadyhas.cf.model.ProfileChampion
 *
 */
@Entity
@TableGenerator(name = "FRIENDSHIP")
public class Friendship extends Model {

	private static final long serialVersionUID = 1893408591406642299L;

	/**
	 * @see br.com.alreadyhas.cf.model.ProfileChampion
	 */
	@Getter
	@Setter
	@Column(name = "FRIENDSHIP_USER", nullable = false)
	private Long friendShipUser;

	/**
	 * @see br.com.alreadyhas.cf.model.ProfileChampion
	 */
	@Getter
	@Setter
	@Column(name = "FRIEND", nullable = false)
	private Long friend;

	@Getter
	@Setter
	@Column(name = "AMOUNT_BATTLE", nullable = false)
	private Integer amountBattle;

	public Friendship() {/**/}

	public Friendship(Long id) {
		super(id);
	}

	public Friendship(Long user, Long friend) {
		this.friendShipUser = user;
		this.friend = friend;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((friend == null) ? 0 : friend.hashCode());
		result = prime * result + ((friendShipUser == null) ? 0 : friendShipUser.hashCode());
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
		if (friend == null) {
			if (other.friend != null)
				return false;
		} else if (!friend.equals(other.friend))
			return false;
		if (friendShipUser == null) {
			if (other.friendShipUser != null)
				return false;
		} else if (!friendShipUser.equals(other.friendShipUser))
			return false;
		return true;
	}

}
