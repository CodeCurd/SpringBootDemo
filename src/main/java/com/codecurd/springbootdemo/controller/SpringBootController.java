/** 
 * @Title SpringBootController.java
 * @Package com.codecurd.springbootdemo.controller
 * @Description TODO
 * @author codecurd@gmail.com
 * @date 2019年1月31日 下午6:14:59
 * @version V1.0.0
 */
package com.codecurd.springbootdemo.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codecurd.springbootdemo.po.SpringBootPO;
import com.codecurd.springbootdemo.dao.SpringBootDAO;

// import com.codecurd.springbootstudy.pojo.SpringBootPojo;


/**
 * @ClassName SpringBootController
 * @Description TODO
 * @author codecurd@gmail.com
 * @date 2019年1月31日 下午6:20:15
 */
@RestController // @Controller 和 @ResponseBody 的组合注解
public class SpringBootController {

    // 绑定 application 配置文件的属性值
//    @Value("${id}")
//	private Integer id;
//	@Value("${remark}")
//	private String remark;
//	@Value("${version}")
//	private String version;
	
	
	/**
	 * @Fields springBootDao: TODO
	 */
	@Autowired
	private SpringBootDAO springBootDao; 
	

	/**
	 * @Title listSpringBootPO
	 * @Description 在spring_boot_po表中查询所有记录
	 * @return List<SpringBootPO>
	 * @throws
	 */
	@GetMapping(value = "/springboot") // @RequestMapping 和 GET 方法的组合注解
//	@RequestMapping(value = "/springboot", method =  RequestMethod.GET) // 建议使用 @GetMapping 注解
	public List<SpringBootPO> listSpringBootPO(){
		return springBootDao.findAll();
	}
		
	/**
	 * @Title insertSpringBootPO
	 * @Description 在spring_boot_po表中插入一行记录
	 * @param version
	 * @param remark
	 * @return SpringBootPO
	 * @throws
	 */
	@PostMapping(value = "/springboot")
	public SpringBootPO insertSpringBootPO(@RequestParam("version") String version,
	        @RequestParam("remark") String remark) {
		
		SpringBootPO springBootPO = new SpringBootPO();
		springBootPO.setVersion(version);
		springBootPO.setRemark(remark);
		
		return springBootDao.save(springBootPO);		
	}
	
	/**
	 * @Title getSpringBootPO
	 * @Description 在spring_boot_po表中,根据id查询记录
	 * @param id
	 * @return Optional<SpringBootPO>
	 * @throws
	 */
	@GetMapping(value = "/springboot/{id}") 
	public Optional<SpringBootPO> getSpringBootPO(@PathVariable("id") Integer id){
		return springBootDao.findById(id);
	}
	
	/**
	 * @Title updateSpringBootPO
	 * @Description 在spring_boot_po表中,根据id更新记录
	 * @param id
	 * @param version
	 * @param remark
	 * @return SpringBootPO
	 * @throws
	 */
	@PutMapping(value = "/springboot/{id}")
	public SpringBootPO updateSpringBootPO(@PathVariable("id") Integer id,
															 @RequestParam("version") String version,
															 @RequestParam("remark") String remark) {
		
		SpringBootPO springBootPO = new SpringBootPO();
		springBootPO.setId(id);
		springBootPO.setVersion(version);
		springBootPO.setRemark(remark);
		
		return springBootDao.save(springBootPO);
	}
	
	/**
	 * @Title deleteSpringBootPO
	 * @Description 在spring_boot_po表中,根据id删除记录
	 * @param id void
	 * @throws
	 */
	@DeleteMapping(value = "/springboot/{id}")
	public void deleteSpringBootPO(@PathVariable("id") Integer id) {
		springBootDao.deleteById(id);
	}

	/**
	 * @Title listByVersionSpringBootPO
	 * @Description 在spring_boot_po表中,根据version查询记录
	 * @param version
	 * @return List<SpringBootPO>
	 * @throws
	 */
	@GetMapping(value = "/springboot/version/{version}") 
	public List<SpringBootPO> listByVersionSpringBootPO(@PathVariable("version") String version){
		return springBootDao.getByVersion(version);
	}
}