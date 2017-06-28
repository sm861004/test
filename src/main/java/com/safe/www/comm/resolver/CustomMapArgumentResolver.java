package com.safe.www.comm.resolver;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

public class CustomMapArgumentResolver implements HandlerMethodArgumentResolver {

	protected Log log = LogFactory.getLog(this.getClass());

	@Override
	public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
		Command command = new Command();

		HttpServletRequest request = (HttpServletRequest) webRequest.getNativeRequest();
		Enumeration<?> enumeration = request.getParameterNames();

		String key = null;
		String[] values = null;
		while(enumeration.hasMoreElements()) {
			key = (String) enumeration.nextElement();
			values = request.getParameterValues(key);
			if(values != null) {
				command.put(key, (values.length > 1 ? values : values[0]));
			}
		}
		log.debug("========================== params start ==========================");
		Iterator<String> iterator = command.getMap().keySet().iterator();
		while(iterator.hasNext()) {
			key = iterator.next();
			log.debug(key + " : " + command.getMap().get(key));
		}
		log.debug("========================== params end ==========================");
		return command;
	}

	@Override
	public boolean supportsParameter(MethodParameter parameter) {
		return Command.class.isAssignableFrom(parameter.getParameterType());
	}

}
