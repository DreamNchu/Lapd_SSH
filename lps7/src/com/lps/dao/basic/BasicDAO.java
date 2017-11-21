package com.lps.dao.basic;

import java.util.List;

import com.lps.model.User;

public interface BasicDAO<T> {
	
	public void save(T t);
	/**
	 * ���ݶ����Idɾ��
	 * @param admin
	 */
	public void delete(T t);
	
	public T findById(int id);

	/**
	 * ���ݶ����id�ж��Ƿ����
	 * @param admin
	 * @return
	 */
	public boolean isExists(T t);
	
	public List<T> findByProperty(String propertyName, Object value) ;
	
	public  List<T> findAll();
	
	public long findAllCount();
	
	/**
	 * ���ݿ�ʼ���±�begin���Լ��ôӸ��±꿪ʼ��limit����
	 * @param begin ��ʼֵ���±�
	 * @param limit �Ӹ��±꿪ʼ��limit����
	 * @return ���ظ÷�Χ�ڵ�list
	 */
	List<T> findListByLimit(long begin, long limit);

}
