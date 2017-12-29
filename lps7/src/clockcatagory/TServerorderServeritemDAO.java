package clockcatagory;

import java.util.List;
import org.hibernate.LockOptions;
import org.hibernate.Query;
import static org.hibernate.criterion.Example.create;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * A data access object (DAO) providing persistence and search support for
 * TServerorderServeritem entities. Transaction control of the save(), update()
 * and delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see clockcatagory.TServerorderServeritem
 * @author MyEclipse Persistence Tools
 */
public class TServerorderServeritemDAO extends BaseHibernateDAO {
	private static final Logger log = LoggerFactory.getLogger(TServerorderServeritemDAO.class);
	// property constants

	public void save(TServerorderServeritem transientInstance) {
		log.debug("saving TServerorderServeritem instance");
		try {
			getSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(TServerorderServeritem persistentInstance) {
		log.debug("deleting TServerorderServeritem instance");
		try {
			getSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public TServerorderServeritem findById(clockcatagory.TServerorderServeritemId id) {
		log.debug("getting TServerorderServeritem instance with id: " + id);
		try {
			TServerorderServeritem instance = (TServerorderServeritem) getSession()
					.get("clockcatagory.TServerorderServeritem", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<TServerorderServeritem> findByExample(TServerorderServeritem instance) {
		log.debug("finding TServerorderServeritem instance by example");
		try {
			List<TServerorderServeritem> results = (List<TServerorderServeritem>) getSession()
					.createCriteria("clockcatagory.TServerorderServeritem").add(create(instance)).list();
			log.debug("find by example successful, result size: " + results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding TServerorderServeritem instance with property: " + propertyName + ", value: " + value);
		try {
			String queryString = "from TServerorderServeritem as model where model." + propertyName + "= ?";
			Query queryObject = getSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findAll() {
		log.debug("finding all TServerorderServeritem instances");
		try {
			String queryString = "from TServerorderServeritem";
			Query queryObject = getSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public TServerorderServeritem merge(TServerorderServeritem detachedInstance) {
		log.debug("merging TServerorderServeritem instance");
		try {
			TServerorderServeritem result = (TServerorderServeritem) getSession().merge(detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(TServerorderServeritem instance) {
		log.debug("attaching dirty TServerorderServeritem instance");
		try {
			getSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(TServerorderServeritem instance) {
		log.debug("attaching clean TServerorderServeritem instance");
		try {
			getSession().buildLockRequest(LockOptions.NONE).lock(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}
}