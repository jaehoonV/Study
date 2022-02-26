package doctor.command;

import java.util.HashMap;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import doctor.service.DeleteDoctorRequest;
import doctor.service.DeleteDoctorService;
import doctor.service.exception.InvalidPasswordException;
import mvc.command.CommandHandler;

public class DeleteDoctorHandler implements CommandHandler {

	private static final String DELETE_VIEW = "/WEB-INF/view/delete/deleteForm.jsp";
	private DeleteDoctorService delDocService = new DeleteDoctorService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("DeleteDoctorHandler process");
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return DELETE_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws NamingException {
		// HttpServletRequest req에 담겨서 온 값들(docID,docName,docPW,...)로 객체 하나 생성
		DeleteDoctorRequest delDocReq = new DeleteDoctorRequest();
		delDocReq.setDocID(req.getParameter("docID"));
		delDocReq.setDocPW(req.getParameter("docPW"));
		
		System.out.println("DeleteDoctorHandler processSubmit");
		// 폼 입력값 검증의 결과를 담기 위한 맵 생성
		Map<String, Boolean> errors = new HashMap<>();

		// jsp가 맵에서 값을 뽑을 수 있도록 request에 errors라는 이름으로 맵을 부착
		req.setAttribute("errors", errors);

		// 회원가입 폼 null, docPW 불일치 검증: 검증 결과를 errors Map에 입력
		delDocReq.validate(errors);

		// 입력 폼의 어떤 항목에 값이 입력되지 않았거나, docPW가 불일치하면 입력 폼으로 다시 보낸다.
		if (!errors.isEmpty()) {
			System.out.println("DeleteDoctorHandler 에러");
			return DELETE_VIEW;
		}

		// 입력 폼 값에 문제가 없다.
		try {
			System.out.println("DeleteDoctorHandler >> processSubmit try");
			// 폼 입력값을 joinReq 오브젝트로 만들어서 joinService 클래스의 join 메소드로 넘겨주고 실행
			delDocService.deleteMember(delDocReq);
			return "/WEB-INF/view/delete/deleteSuccess.jsp";
		} catch (InvalidPasswordException e) {
			// join 메소드에서 id 중복체크에 걸리면 errors에 기록하고 가입 폼 반환
			errors.put("no", Boolean.TRUE);
			return DELETE_VIEW;
		}
	}

}
