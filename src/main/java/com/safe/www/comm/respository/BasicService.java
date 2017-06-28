package com.safe.www.comm.respository;

import java.util.HashMap;

import org.springframework.stereotype.Service;

@Service("basicService")
public interface BasicService {
	HashMap<String, Object> getMemberInfo(HashMap<String, Object> params);
}
