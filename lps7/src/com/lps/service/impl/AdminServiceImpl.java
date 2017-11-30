package com.lps.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lps.dao.AdminDAO;
import com.lps.dao.impl.AdminDAOImpl;
import com.lps.model.Admin;
import com.lps.model.basic.BasicModel;
import com.lps.service.AdminService;
import com.lps.util.PageBean;

//@Component("adminServiceImpl")
//@Aspect
public class AdminServiceImpl implements AdminService {
	
	private AdminDAO adminDao ;
	
	private PageBean<Admin> pageAdminBean;

	public PageBean<Admin> getPageAdminBean() {
		return pageAdminBean;
	}

	public void setPageAdminBean(PageBean<Admin> pageAdminBean) {
		this.pageAdminBean = pageAdminBean;
	}

	public AdminDAO getAdminDao() {
		return adminDao;
	}

//	@Resource(name="adminDAOImpl")
	public void setAdminDao(AdminDAO adminDao) {
		this.adminDao = adminDao;
	}

	@Override
	public void save(Admin admin) {
		adminDao.save(admin);
	}

	@Override
	public void delete(Admin admin) {
		adminDao.delete(admin);
	}

	@Override
	public Admin findByUserName(String name) {
		return adminDao.getByUserName(name);
	}

	@Override
	public Admin findById(int id) {
		return adminDao.findById(id);
	}
	
	@Override
	public boolean isExists(Admin admin) {
		return adminDao.isExists(admin);
	}

	@Override
	public Date findRegisterTime(Admin admin) {
		return findById(admin.getId()).getRegisterTime();
	}

	@Override
	public String getAvatar(Admin admin) {
		return findById(admin.getId()).getAvatar();
	}
	@Override
	public List<Admin> findByProperty(String propertyName, Object value){
		return adminDao.findByProperty(propertyName, value);
	}
/*	
	@Override
	public List<Admin> findByRegisterTime(Timestamp value){
		return adminDao.getByRegisterTime(value);
	}*/

	@Override
	public List<Admin> findAll() {
		return adminDao.findAll();
	}

	@Override
	public long findAllCount() {
		return adminDao.findAllCount();
	}

	@Override
	public PageBean<Admin> findByPage(int page) {
		pageAdminBean.setPage(page);
        
        long totalCount= findAllCount();
        
        pageAdminBean.setAllCount(totalCount);
        
        long limit  = pageAdminBean.getLimit();
        
        long totalpage=(long)Math.ceil(totalCount/limit);
        
        pageAdminBean.setAllPage(totalpage);
        //ÿҳ��ʾ�����ݼ���
        long begin=(page-1) * limit;
        
        List<Admin> list = adminDao.findListByLimit(begin, limit);
        
        pageAdminBean.setList(list);
        
        return pageAdminBean;
	}

	@Override
	public void update(Admin t) {
		adminDao.update(t);
	}

	@Override
	public String findPasswordByUserName(String userName) {
		Admin admin =new  Admin.Builder()
				.setId(findIdByUserName(userName)).build();
		return findPassword(admin);
	}

	@Override
	public <T> String findPassword(BasicModel<T> admin) {
		Map<String, Class<?>> map = new HashMap<String, Class<?>>();
		map.put(AdminDAOImpl.PASSWORD, String.class);
		return adminDao.findFields(admin, map).getPassword();
	}

	@Override
	public int findIdByUserName(String name) {
		Map<String, Object> map = new HashMap<>();
		map.put(AdminDAOImpl.USER_NAME, name);
		return (int) adminDao.findIdByProperty(map).get(0);
	}

}
