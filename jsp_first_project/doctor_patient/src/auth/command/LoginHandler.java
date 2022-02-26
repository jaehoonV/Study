package auth.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.LoginFailException;
import auth.service.LoginService;
import auth.service.User;
import mvc.command.CommandHandler;

public class LoginHandler implements CommandHandler {

	private static final String FORM_VIEW = "/WEB-INF/view/login/loginForm.jsp";
	private LoginService loginService = new LoginService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// 요청이 loginform에서 온 것이 아니면
		if (req.getMethod().equalsIgnoreCase("GET")) {
			// login form 경로 반환
			return processForm(req, res);
			// 요청이 login form에서 왔으므로 폼의 내용을 검사하고 이상 없으면 로그인 프로세스 진행(dao 호출)
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws NamingException, IOException {
		// 폼에서 넘어온 값 공백 제거하여 변수에 저장
		String docID = trim(req.getParameter("docID"));
		String docPW = trim(req.getParameter("docPW"));
		System.out.println("LoginHandler - 로그인 폼에서 넘어온 값 변수에 저장 ");
		// 에러 체크용 맵 생성하여 리퀘스트에 부착
		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);

		// 에러 체크하여 있으면 맵에 기록
		if (docID == null || docID.isEmpty()) //docID가 없을 때
			errors.put("docID", Boolean.TRUE);
		if (docPW == null || docPW.isEmpty()) //docPW가 없을 때
			errors.put("docPW", Boolean.TRUE);

		// 에러가 있으면 로그인 폼으로 되돌아감
		if (!errors.isEmpty()) {
			System.out.println("로그인 에러");
			return FORM_VIEW;
		}
		
		try {
			System.out.println("LoginHandler - 로그인 폼try ");
			// 폼 값이 제대로 들어오면 서비스로 넘겨서 로그인 작업 수행하고 결과 값으로 User 객체를 받음
			User user = loginService.login(docID, docPW);
			// 로그인 성공 - 세션에 속성 authUser와 속성값 회원정보를 붙여준다.
			req.getSession().setAttribute("authUser", user);
			// index.jsp 페이지로 돌아감
			res.sendRedirect(req.getContextPath() + "/index.jsp");
			return null;
		} catch (LoginFailException e) {
			errors.put("idOrPwNotMatch", Boolean.TRUE);
			return FORM_VIEW;
		}
	}

	private String trim(String str) {
		return str == null ? null : str.trim();
	}

}
