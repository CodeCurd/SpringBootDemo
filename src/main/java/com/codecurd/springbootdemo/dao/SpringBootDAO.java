/** 
* @Title SpringBootDAO.java
* @Package com.codecurd.springbootdemo.dao
* @Description TODO
* @author codecurd@gmail.com
* @date 2019年1月31日 下午6:32:31
* @version V1.0.0
*/
package com.codecurd.springbootdemo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.codecurd.springbootdemo.po.SpringBootPO;

/**
 * @ClassName SpringBootDAO
 * @Description TODO
 * @author codecurd@gmail.com
 * @date 2019年1月31日 下午6:33:50
 */
public interface SpringBootDAO extends JpaRepository<SpringBootPO, Integer> {
    
    /*
     * DAO 层方法命名规约
     * 1） 获取单个对象的方法用 get 做前缀。 
     * 2） 获取多个对象的方法用 list 做前缀，复数形式结尾如：listObjects。 
     * 3） 获取统计值的方法用 count 做前缀。 
     * 4） 插入的方法用 save/insert 做前缀。 
     * 5） 删除的方法用 remove/delete 做前缀。
     * 6） 修改的方法用 update 做前缀。
     */

	/**
	 * @Title getByVersion
	 * @Description 在spring_boot_po表中,根据version查询记录
	 * @param version
	 * @return List<SpringBootPO>
	 * @throws
	 */
	public List<SpringBootPO> getByVersion(String version);
	    
}
