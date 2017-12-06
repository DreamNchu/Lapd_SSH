package com.lps.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.lps.dao.ServerItemDAO;
import com.lps.dao.impl.PledgeDAOImpl;
import com.lps.dao.impl.ServerItemDAOImpl;
import com.lps.model.ServerItem;
import com.lps.model.ServerOrder;
import com.lps.model.basic.BasicModel;
import com.lps.service.ServerItemService;
import com.lps.util.PageBean;
import com.lps.util.PagePropertyNotInitException;

//@Component("adminServiceImpl")
//@Aspect
public class ServerItemServiceImpl implements ServerItemService {

	private ServerItemDAO dao;

	private PageBean<ServerItem> pageServerItemBean;
	
	public PageBean<ServerItem> getPageServerItemBean() {
		return pageServerItemBean;
	}

	public void setPageServerItemBean(PageBean<ServerItem> pageServerItemBean) {
		this.pageServerItemBean = pageServerItemBean;
	}

	private PageBean<ServerOrder> pageServerOrderByServerItemBean;

	public PageBean<ServerOrder> getPageServerOrderByServerItemBean() {
		return pageServerOrderByServerItemBean;
	}

	public void setPageServerOrderByServerItemBean(PageBean<ServerOrder> pageServerOrderByServerItemBean) {
		this.pageServerOrderByServerItemBean = pageServerOrderByServerItemBean;
	}

	@Override
	public void delete(ServerItem serverItem) {
		dao.delete(serverItem);
	}

	@Override
	public List<ServerItem> findAll() {
		return dao.findAll();
	}

	@Override
	public long findAllCount() {
		return dao.findAllCount();
	}

	@Override
	public ServerItem findById(int id) {
		return dao.findById(id);
	}

	@Override
	public List<ServerItem> findByProperty(String propertyName, Object value) {
		return dao.findByProperty(propertyName, value);
	}

	@Override
	public List<ServerItem> findByServerItem(Object roomCategory) {
		return dao.findByServerItem(roomCategory);
	}

	public ServerItemDAO getServerItemDao() {
		return dao;
	}

	@Override
	public void save(ServerItem serverItem) {
		dao.save(serverItem);
	}

	public void setServerItemDao(ServerItemDAO roomCategoryDao) {
		this.dao = roomCategoryDao;
	}

	@Override
	public boolean isExists(ServerItem user) {
		return dao.isExists(user);
	}

	@Override
	public PageBean<ServerItem> findByPage(int page) throws PagePropertyNotInitException {
		long begin = pageServerItemBean.init(findAllCount(), page);

		List<ServerItem> list = dao.findListByLimit(begin, pageServerItemBean.getLimit());

		pageServerItemBean.setList(list);

		return pageServerItemBean;
	}

	@Override
	public void update(ServerItem t) {
		dao.update(t);
	}

	@Override
	public String findServerItem(ServerItem serverItem) {
		Map<String, Class<?>> map = new HashMap<>();
		map.put(ServerItemDAOImpl.ROOM_CATEGORY, String.class);
		return dao.findFields(serverItem, map).getServerItem();
	}

	@Override
	public int findIdByServerItem(String roomCategoryProperty) {
		Map<String, Object> map = new HashMap<>();
		map.put(PledgeDAOImpl.PLEDGE, roomCategoryProperty);
		List<Integer> list = dao.findIdByProperty(map);
		if(list != null && list.size() > 0)
			return list.get(0);
		return NOT_EXISTS;
	}

	@Override
	public <K> ServerItem findFields(BasicModel<K> t, Map<String, Class<?>> fields) {
		return dao.findFields(t, fields);
	}

	@Override
	public <K> List<K> findIdByProperty(Map<String, Object> map) {
		return dao.findIdByProperty(map);
	}

}
