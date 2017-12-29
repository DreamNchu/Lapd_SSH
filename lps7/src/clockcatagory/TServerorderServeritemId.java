package clockcatagory;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * TServerorderServeritemId entity. @author MyEclipse Persistence Tools
 */
@Embeddable

public class TServerorderServeritemId implements java.io.Serializable {

	// Fields

	private String TServerorderId;
	private Integer TServerItemId;

	// Constructors

	/** default constructor */
	public TServerorderServeritemId() {
	}

	/** full constructor */
	public TServerorderServeritemId(String TServerorderId, Integer TServerItemId) {
		this.TServerorderId = TServerorderId;
		this.TServerItemId = TServerItemId;
	}

	// Property accessors

	@Column(name = "t_serverorder_id", nullable = false, length = 45)

	public String getTServerorderId() {
		return this.TServerorderId;
	}

	public void setTServerorderId(String TServerorderId) {
		this.TServerorderId = TServerorderId;
	}

	@Column(name = "t_serverItem_id", nullable = false)

	public Integer getTServerItemId() {
		return this.TServerItemId;
	}

	public void setTServerItemId(Integer TServerItemId) {
		this.TServerItemId = TServerItemId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TServerorderServeritemId))
			return false;
		TServerorderServeritemId castOther = (TServerorderServeritemId) other;

		return ((this.getTServerorderId() == castOther.getTServerorderId())
				|| (this.getTServerorderId() != null && castOther.getTServerorderId() != null
						&& this.getTServerorderId().equals(castOther.getTServerorderId())))
				&& ((this.getTServerItemId() == castOther.getTServerItemId())
						|| (this.getTServerItemId() != null && castOther.getTServerItemId() != null
								&& this.getTServerItemId().equals(castOther.getTServerItemId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (getTServerorderId() == null ? 0 : this.getTServerorderId().hashCode());
		result = 37 * result + (getTServerItemId() == null ? 0 : this.getTServerItemId().hashCode());
		return result;
	}

}