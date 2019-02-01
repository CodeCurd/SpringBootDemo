/** 
* @Title SpringBootPO.java
* @Package com.codecurd.springbootdemo.po
* @Description TODO
* @author codecurd@gmail.com
* @date 2019年1月31日 下午6:34:58
* @version V1.0.0
*/
package com.codecurd.springbootdemo.po;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/*import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;*/

/*@Component // 获取绑定 application 配置文件的属性.
@ConfigurationProperties(prefix =  "srpingboot") // 获取绑定 application 配置文件中指定前缀名的属性值.*/

/**
 * @ClassName SpringBootPO
 * @Description TODO
 * @author codecurd@gmail.com
 * @date 2019年1月31日 下午6:35:46
 */
@Entity // Hibernate 创建数据库实体的注释.
@Table(name = "spring_boot_po") // 声明该类与数据库表的映射关系,非必须. 但不声明,po层类名如SpringBootPO时，数据库会默认生成spring_bootpo表;po层类名如SpringBootPo时,数据库才会生成spring_boot_po表.
public class SpringBootPO {
	
	/**
	 * @Fields id: TODO
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // @GeneratedValue 默认使用 Oracle 实现自增,在 mysql-5.7.X 中需要追加 (strategy = GenerationType.IDENTITY) , 否则会生成 hibernate_sequence 表.
	/*@Column(name = "id" length=11) // 声明该属性与数据库字段的映射关系,非必须.*/
	private Integer id;
	
	/**
	 * @Fields version: TODO
	 */
	private String version;
	
	/**
	 * @Fields remark: TODO
	 */
	private String remark;

	// 无参构造方法
	/*public SpringBootPO() {
		
	}*/
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

    /* (non-Javadoc)
     * <p>Title toString</p>
     * <p>Description POJO类必须写 toString方法. 在方法执行抛出异常时, 可以直接调用 POJO的 toString()方法打印其属性值, 便于排查问题.</p>
     * @return 
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "SpringBootPO [id=" + id + ", version=" + version + ", remark=" + remark + "]";
    }

}
