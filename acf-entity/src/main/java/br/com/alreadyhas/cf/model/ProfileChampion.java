package br.com.alreadyhas.cf.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.TableGenerator;

import br.com.alreadyhas.cf.model.contract.Model;
import br.com.alreadyhas.cf.preset.UserStatusEnum;
import br.com.alreadyhas.cf.warn.PresetException;
import lombok.Getter;
import lombok.Setter;

/**
 * <h2>ProfileChampion</h2>
 * <hr />
 * <p>This class represents the user.</p>
 * <hr />
 * 
 * @author Matheus Franco
 * @category Model
 * @version 0.1
 * @see br.com.alreadyhas.cf.preset.UserStatusEnum
 *
 */
@Entity(name = "PROFILE_CHAMPION")
@TableGenerator(name = "PROFILE_CHAMPION")
public class ProfileChampion extends Model {

	private static final long serialVersionUID = -7479431558785699752L;

	@Getter 
	@Setter
	@Column(name = "USER_NAME", nullable = false)
	private String name;

	@Getter 
	@Setter
	@Column(name = "PHOTO")
	private byte[] photo;
	

	@Getter 
	@Setter
	@Column(name = "PASSWORD", nullable = false)
	private String password;

	@Getter 
	@Setter
	@Column(name = "ENCRIPTED")
	private Boolean encripted;

	@Getter 
	@Setter
	@Column(name = "EMAILS", nullable = false)
	private String email;

	@Getter 
	@Setter
	@Column(name = "FACTION", nullable = false)
	private Integer faction;

	@Getter 
	@Setter
	@Column(name = "COIN")
	private Integer coin;

	@Getter 
	@Setter
	@Column(name = "CASH")
	private Integer cash;

	@Getter 
	@Setter
	@Column(name = "LEVEL")
	private Integer level;

	@Getter 
	@Setter
	@Column(name = "EXPERIENCE")
	private Double experience;

	@Getter 
	@Setter
	@Column(name = "DESCRIPTION")
	private String description;

	@Getter 
	@Setter
	@Column(name = "USER_LOGIN", nullable = false)
	private String login;

	/**
	 * @see br.com.alreadyhas.cf.preset.UserStatusEnum
	 */
	@Getter 
	@Column(name = "USER_STATUS")
	private Integer status;

	public ProfileChampion() {/**/}

	public ProfileChampion(Long id) {
		super(id);
	}

	public ProfileChampion(String name, String email, String login) {
		this.name = name;
		this.email = email;
		this.login = login;
	}

	public void setStatus(Integer status){
		try {
			this.status = UserStatusEnum.fromId(status).getCode();
		} catch (PresetException e) {
			PresetException.printSetMethod(e, getClass(), "Status", status);
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((login == null) ? 0 : login.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		ProfileChampion other = (ProfileChampion) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (login == null) {
			if (other.login != null)
				return false;
		} else if (!login.equals(other.login))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
}
