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

import com.codecurd.springbootdemo.pojo.SpringBootPojo;
import com.codecurd.springbootdemo.dao.SpringBootDao;

//import com.codecurd.springbootstudy.pojo.SpringBootPojo;

/**
 * @author codecurd
 *
 */
@RestController // @Controller 和 @ResponseBody 的组合注解
public class SpringBootController {

//	绑定 application 配置文件的属性值
/*	@Value("${id}")
	private Integer id;
	@Value("${remark}")
	private String remark;
	@Value("${version}")
	private String version; */
	
	@Autowired
	private SpringBootDao springBootDao; 
	
	/**
	 * 查询 springboot 表的所有数据
	 * @return
	 */
	@GetMapping(value = "/springboot") // @RequestMapping 和 GET 方法的组合注解
//	@RequestMapping(value = "/springboot", method =  RequestMethod.GET) // 建议使用 @GetMapping 注解
	public List<SpringBootPojo> springbootpojoList(){
		return springBootDao.findAll();
	}
	
	/**
	 * 添加 springboot 表的一行数据
	 * @param version
	 * @param remark
	 * @return
	 */
	@PostMapping(value = "/springboot")
	public SpringBootPojo springbootpojoAdd(@RequestParam("version") String version,
																		 @RequestParam("remark") String remark) {
		
		SpringBootPojo springbootpojo = new SpringBootPojo();
		springbootpojo.setVersion(version);
		springbootpojo.setRemark(remark);
		
		return springBootDao.save(springbootpojo);		
	}
	
	/**
	 * 通过 id 查询 springboot 表的数据
	 * @param id
	 * @return
	 */
	@GetMapping(value = "/springboot/{id}") 
	public Optional<SpringBootPojo> springbootpojoFindOne(@PathVariable("id") Integer id){
		return springBootDao.findById(id);
	}
	
	/**
	 * 通过 id 修改 springboot 表的数据
	 * @param id
	 * @param version
	 * @param remark
	 * @return
	 */
	@PutMapping(value = "/springboot/{id}")
	public SpringBootPojo springbootpojoUpdate(@PathVariable("id") Integer id,
															 @RequestParam("version") String version,
															 @RequestParam("remark") String remark) {
		
		SpringBootPojo springbootpojo = new SpringBootPojo();
		springbootpojo.setId(id);
		springbootpojo.setVersion(version);
		springbootpojo.setRemark(remark);
		
		return springBootDao.save(springbootpojo);		
	}
	
	/**
	 * 通过 id 删除 springboot 表的数据
	 * @param id
	 * @return
	 */
	@DeleteMapping(value = "/springboot/{id}")
	public void springbootpojoDelete(@PathVariable("id") Integer id) {
		springBootDao.deleteById(id);
	}
	
	/**
	 * 通过 version 查询 springboot 表的数据
	 * @param version
	 * @return
	 */
	@GetMapping(value = "/springboot/version/{version}") 
	public List<SpringBootPojo> springbootpojoListByVersion(@PathVariable("version") String version){
		return springBootDao.findByVersion(version);
	}
}