package doctor.command;

import java.util.HashMap;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import doctor.service.exception.DuplicateIdException;
import doctor.service.JoinRequest;
import doctor.service.JoinService;
import mvc.command.CommandHandler;

//join.do를 통해 접근한 회원가입용 폼 입력값 검사 및 문제 없는 리퀘스트의 내용을 서비스로 전달하는 핸들러 클래스 
public class JoinHandler implements CommandHandler {
	
	//핸들러가 요청을 받아서 get방식으로 왔거나 에러가 있을 때 이동할 jsp페이지를 상수로 등록
	private static final String FORM_VIEW = "/WEB-INF/view/join/joinForm.jsp";
	
	//폼에서 넘어온 값 받아서 넘기기 위해 서비스 객체 생성
	private JoinService joinService = new JoinService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws NamingException {
		System.out.println("JoinHandler >> process");
		//index.jsp에서 회원가입 눌렀을 때 (get 방식으로 들어옴)
		if (req.getMethod().equalsIgnoreCase("GET")) {
			//아래 있는 processForm 메소드 실행하고 결과 반환
			return processForm(req, res);
		//joinForm.jsp에서 가입 버튼 눌렀을 때(post 방식으로 들어옴)
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			//아래 있는 processSubmit 메소드 실행하고 결과 반환
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}
	
	//index.jsp에서 회원가입 눌렀을 때 joinForm.jsp의 경로를 반환
	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("processForm");
		return FORM_VIEW ;
	}

	//joinForm.jsp에서 가입 버튼 눌렀을 때
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws NamingException {
		 System.out.println("processSubmit");
		//form에서 넘어온 값(request)의 error 체크 -> map을 만들어서 기록 -> 
		//에러가 있으면 에러 체크 결과(map)와 함게 다시 form으로 되돌려줌. 
		//JoinRequest 객체 생성하고 joinForm.jsp에서 넘겨준 request에 들어 있는 값을 넣어줌
		JoinRequest joinReq = new JoinRequest();
		joinReq.setDocID(req.getParameter("docID"));
		joinReq.setDocPW(req.getParameter("docPW"));
		joinReq.setConfirmPassword(req.getParameter("confirmPassword"));
		joinReq.setDocName(req.getParameter("docName"));
		joinReq.setMedicalDepartment(req.getParameter("medicalDepartment"));
		joinReq.setPhoneNum(req.getParameter("phoneNum"));
		
		
		//폼 입력값 검증의 결과를 담기 위한 맵 생성
		Map<String, Boolean> errors = new HashMap<>();
		/* jsp가 맵에서 값을 뽑을 수 있도록 request에 errors라는 이름으로 맵을 부착 */ 
		req.setAttribute("errors", errors);
		
		//회원가입 폼 null, docPW 불일치 검증: 검증 결과를 errors Map에 입력
		joinReq.validate(errors);
		
		//입력 폼의 어떤 항목에 값이 입력되지 않았거나, password가 불일치하면 입력 폼으로 다시 보낸다.
		if (!errors.isEmpty()) {
			System.out.println("입력 폼의 어떤 항목에 값이 입력되지 않았거나, password가 불일치하면 입력 폼으로 다시 보낸다");
			return FORM_VIEW;
		}
		
		//입력 폼 값에 문제가 없다.
		try {
			//폼 입력값을 joinReq 오브젝트로 만들어서 joinService 클래스의 join 메소드로 넘겨주고 실행
			joinService.join(joinReq);
			return "/WEB-INF/view/join/joinSuccess.jsp";
		} catch (DuplicateIdException e) {
			//join 메소드에서 id 중복체크에 걸리면 errors에 기록하고 가입 폼 반환
			errors.put("duplicateId", Boolean.TRUE);
			return FORM_VIEW;
		}
	}
}
