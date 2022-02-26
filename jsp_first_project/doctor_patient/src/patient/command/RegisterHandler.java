package patient.command;

import java.util.HashMap;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import doctor.service.exception.DuplicateIdException;
import mvc.command.CommandHandler;
import patient.service.RegisterRequest;
import patient.service.RegisterService;

public class RegisterHandler implements CommandHandler {

	// 핸들러가 요청을 받아서 get방식으로 왔거나 에러가 있을 때 이동할 jsp페이지를 상수로 등록
	private static final String FORM_VIEW = "/WEB-INF/view/patients/register.jsp";

	// 폼에서 넘어온 값 받아서 넘기기 위해 서비스 객체 생성
	private RegisterService registerService = new RegisterService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("RegisterHandler >> process");

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
		System.out.println("processForm");
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws NamingException {
		System.out.println("RegisterHandler >> processSubmit");

		RegisterRequest registerReq = new RegisterRequest();
		registerReq.setPatientID(req.getParameter("patientID"));
		registerReq.setPatientName(req.getParameter("patientName"));

		// 폼 입력값 검증의 결과를 담기 위한 맵 생성
		Map<String, Boolean> errors = new HashMap<>();
		/* jsp가 맵에서 값을 뽑을 수 있도록 request에 errors라는 이름으로 맵을 부착 */
		req.setAttribute("errors", errors);

		registerReq.validate(errors);

		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}

		// 입력 폼 값에 문제가 없다.
		try {
			// 폼 입력값을 joinReq 오브젝트로 만들어서 joinService 클래스의 join 메소드로 넘겨주고 실행
			registerService.register(registerReq);
			return "/WEB-INF/view/patients/registerSuccess.jsp";
		} catch (DuplicateIdException e) {
			// id 중복체크에 걸리면 errors에 기록하고 가입 폼 반환
			errors.put("duplicateId", Boolean.TRUE);
			return FORM_VIEW;
		}
	}

}
