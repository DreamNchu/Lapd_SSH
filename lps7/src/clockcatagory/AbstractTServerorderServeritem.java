package clockcatagory;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * AbstractTServerorderServeritem entity provides the base persistence
 * definition of the TServerorderServeritem entity. @author MyEclipse
 * Persistence Tools
 */
@MappedSuperclass

public abstract class AbstractTServerorderServeritem implements java.io.Serializable {

	// Fields

	private TServerorderServeritemId id;
	private TServerorder TServerorder;
	private TServeritem TServeritem;

	// Constructors

	/** default constructor */
	public AbstractTServerorderServeritem() {
	}

	/** full constructor */
	public AbstractTServerorderServeritem(TServerorderServeritemId id, TServerorder TServerorder,
			TServeritem TServeritem) {
		this.id = id;
		this.TServerorder = TServerorder;
		this.TServeritem = TServeritem;
	}

	// Property accessors
	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "TServerorderId", column = @Column(name = "t_serverorder_id", nullable = false, length = 45)),
			@AttributeOverride(name = "TServerItemId", column = @Column(name = "t_serverItem_id", nullable = false)) })

	public TServerorderServeritemId getId() {
		return this.id;
	}

	public void setId(TServerorderServeritemId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "t_serverorder_id", nullable = false, insertable = false, updatable = false)

	public TServerorder getTServerorder() {
		return this.TServerorder;
	}

	public void setTServerorder(TServerorder TServerorder) {
		this.TServerorder = TServerorder;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "t_serverItem_id", nullable = false, insertable = false, updatable = false)

	public TServeritem getTServeritem() {
		return this.TServeritem;
	}

	public void setTServeritem(TServeritem TServeritem) {
		this.TServeritem = TServeritem;
	}

}