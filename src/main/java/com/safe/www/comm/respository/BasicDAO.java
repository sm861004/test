package com.safe.www.comm.respository;

import java.util.HashMap;
import java.util.List;

/**
 * @author Bang Seok Min<br />
 * 기본 BasicDAO 
 ****************************
 *     코드 수정 히스토리<br />
 *  날짜          작업자         태그<br />
 *2017. 6. 15.  Bang Seok Min  <br />
 ****************************
 */
public interface BasicDAO {
	/**
	 * 설명 : DB 리스트 조회<br />
	 * 작성자 : Bang Seok Min <br />
	 * 작성일자 : 2017. 6. 15. 오후 9:49:22 <br />
	 * @param sqlNm
	 * @param obj
	 * @return
	 * List<HashMap<String,Object>>
	 */
	public List<HashMap<String, Object>> getHashList(String sqlNm, Object obj);
	/**
	 * 설명 : DB 단건 조회 <br />
	 * 작성자 : Bang Seok Min <br />
	 * 작성일자 : 2017. 6. 15. 오후 9:49:44 <br />
	 * @param sqlNm
	 * @param obj
	 * @return
	 * HashMap<String,Object>
	 */
	public HashMap<String, Object> getHashOne(String sqlNm, Object obj);
	
	/**
	 * 설명 : <br>
	 * 작성자 : Bang Seok Min <br>
	 * 작성일자 : 2017. 6. 15. <br>
	 * @param sqlNm
	 * @param obj
	 * @return Object
	 */
	public Object pakageProcDml(String sqlNm, Object obj);  // 패키지 프로시저/프로시저 DAO (DML관련 처리)
}
