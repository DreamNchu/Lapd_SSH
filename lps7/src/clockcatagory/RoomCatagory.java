package clockcatagory;

import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * TRoomcatagory entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "t_roomcatagory", catalog = "lapd_test")
public class RoomCatagory extends AbstractTRoomcatagory implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public RoomCatagory() {
	}

	/** full constructor */
	public RoomCatagory(String roomcatagory, Set<Room> TRooms) {
		super(roomcatagory, TRooms);
	}

}
