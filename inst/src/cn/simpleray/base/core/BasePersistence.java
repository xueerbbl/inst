package cn.simpleray.base.core;

/**
 * @author Alan Zhang
 */
public interface BasePersistence<T> {
	/**
	 * 添加对象
	 * 
	 * @param model
	 * @return
	 */
	public long insert(T model);

	/**
	 * 更新对象
	 * 
	 * @param model
	 */
	public void update(T model);

	/**
	 * 根据primaryKey删除对象
	 * 
	 * @param primaryKey
	 */
	public void delete(long primaryKey);

	/**
	 * 根据primaryKey加载对象
	 * 
	 * @param primaryKey
	 * @return
	 */
	public T findByPrimaryKey(long primaryKey);

}