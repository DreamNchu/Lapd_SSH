package clockcatagory;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * TServerorderServeritem entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_serverorder_serveritem", catalog = "lapd_test")
public class TServerorderServeritem extends AbstractTServerorderServeritem implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public TServerorderServeritem() {
	}

	/** full constructor */
	public TServerorderServeritem(TServerorderServeritemId id, TServerorder TServerorder, TServeritem TServeritem) {
		super(id, TServerorder, TServeritem);
	}

}
