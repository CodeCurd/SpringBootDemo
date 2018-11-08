package com.codecurd.springbootdemo.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

/*import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;*/

/*@Component // 获取绑定 application 配置文件的属性.
@ConfigurationProperties(prefix =  "srpingboot") // 获取绑定 application 配置文件中指定前缀名的属性值.*/

@Entity // Hibernate 创建数据库实体的注释.
/*@Table(name = "spring_boot_pojo") // 声明该类与数据库表的映射关系,非必须.*/
public class SpringBootPojo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // @GeneratedValue 默认使用 Oracle 实现自增,在 mysql-5.7.24 中需要追加 (strategy = GenerationType.IDENTITY) , 否则会生成 hibernate_sequence 表.
	/*@Column(name = "id" length=11) // 声明该属性与数据库字段的映射关系,非必须.*/
	private Integer id;
	
	private String version;
	
	private String remark;

	// 无参构造方法
	/*public SpringBootPojo() {
		
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

}
