package com.safe.www.comm.basic;

import java.util.HashMap;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.safe.www.comm.resolver.Command;
import com.safe.www.comm.respository.BasicService;

/**
 *
 * @author Bang Seok Min 
 * @file BasicController.java
 * @date 2017. 6. 15.
 */
@Controller
public class BasicController {
	
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	// 프로퍼티 사용 가능 
	@Autowired
	Properties prop;
	
	@Autowired
	BasicService basicService;
	
	/**
	 * 설명 : 인덱스 페이지 이동 <br />
	 * 작성자 : Bang Seok Min <br />
	 * 작성일자 : 2017. 6. 15.<br />
	 * @param request
	 * @param response
	 * @param session
	 * @param command
	 * @param model
	 * @return String
	 */	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index(HttpServletRequest request
			, HttpServletResponse response
			, HttpSession session
			, Command command
			, Model model) {
		HashMap<String, Object> params = command.getMap();
		logger.info("------------------진입");
		model.addAttribute("db", basicService.getMemberInfo(params));
		logger.info(basicService.getMemberInfo(params).toString());
		return "com.safe.www.index";
	}
}
