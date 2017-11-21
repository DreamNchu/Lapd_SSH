package clockcatagory;

import java.util.Date;
import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for TRoom
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see clockcatagory.Room
 * @author MyEclipse Persistence Tools
 */
public class TRoomDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(TRoomDAO.class);
	// property constants
	public static final String NAME = "name";
	public static final String FLOOR = "floor";
	public static final String SIZE = "size";
	public static final String REMARK = "remark";

	public void save(Room transientInstance) {
		log.debug("saving TRoom instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Room persistentInstance) {
		log.debug("deleting TRoom instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Room findById(java.lang.Integer id) {
		log.debug("getting TRoom instance with id: " + id);
		try {
			Room instance = (Room) getSession().get("clockcatagory.TRoom", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Room> findByExample(Room instance) {
		log.debug("finding TRoom instance by example");
		try {
			List<Room> results = (List<Room>) getSession().createCriteria("clockcatagory.TRoom").add(create(instance))
					.list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TRoom instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from TRoom as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Room> findByName(Object name) {
		return findByProperty(NAME, name);
	}

	public List<Room> findByFloor(Object floor) {
		return findByProperty(FLOOR, floor);
	}

	public List<Room> findBySize(Object size) {
		return findByProperty(SIZE, size);
	}

	public List<Room> findByRemark(Object remark) {
		return findByProperty(REMARK, remark);
	}

	public List findAll() {
		log.debug("finding all TRoom instances");
		try {
			String queryString = "from TRoom";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Room merge(Room detachedInstance) {
		log.debug("merging TRoom instance");
		try {
			Room result = (Room) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Room instance) {
		log.debug("attaching dirty TRoom instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Room instance) {
		log.debug("attaching clean TRoom instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}