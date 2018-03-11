package br.com.alreadyhas.cf.model;

import java.util.Arrays;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import br.com.alreadyhas.cf.contract.Model;
import lombok.Getter;
import lombok.Setter;

/**
 * <h2>History</h2>
 * <hr />
 * <p>
 * This class represents the battle history.
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
public class History extends Model {

	private static final long serialVersionUID = 7474562726184311149L;

	/**
	 * @see br.com.alreadyhas.cf.model.UserChampion
	 **/
	@Getter 
	@Setter
	@ManyToOne
	@JoinColumn(name = "USER_RED", nullable = false)
	private UserChampion userRed;

	/**
	 * @see br.com.alreadyhas.cf.model.UserChampion
	 **/
	@Getter 
	@Setter
	@ManyToOne
	@JoinColumn(name = "USER_BLUE", nullable = false)
	private UserChampion userBlue;

	@Getter 
	@Setter
	@Column(name = "MOVES", nullable = false)
	private byte[] moves;

	public History() {/**/}

	public History(Long id) {
		super(id);
	}

	public History(UserChampion userRed, UserChampion userBlue, byte[] moves) {
		this.userRed = userRed;
		this.userBlue = userBlue;
		this.moves = moves;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Arrays.hashCode(moves);
		result = prime * result + ((userBlue == null) ? 0 : userBlue.hashCode());
		result = prime * result + ((userRed == null) ? 0 : userRed.hashCode());
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
		History other = (History) obj;
		if (!Arrays.equals(moves, other.moves))
			return false;
		if (userBlue == null) {
			if (other.userBlue != null)
				return false;
		} else if (!userBlue.equals(other.userBlue))
			return false;
		if (userRed == null) {
			if (other.userRed != null)
				return false;
		} else if (!userRed.equals(other.userRed))
			return false;
		return true;
	}
}
