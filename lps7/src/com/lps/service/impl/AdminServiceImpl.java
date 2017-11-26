package com.lps.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.lps.dao.AdminDAO;
import com.lps.model.Admin;
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
	public Admin getByUserName(String name) {
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
	public Date getRegisterTime(Admin admin) {
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
		// TODO Auto-generated method stub
		adminDao.update(t);
	}


}
