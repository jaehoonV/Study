package doctor.command;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.service.User;
import doctor.service.ChangePasswordService;
import doctor.service.exception.InvalidPasswordException;
import doctor.service.exception.MemberNotFoundException;
import mvc.command.CommandHandler;

public class ChangePasswordHandler implements CommandHandler {
	private static final String FORM_VIEW = "/WEB-INF/view/changePWD/changePwdForm.jsp";
	private ChangePasswordService changePwdSvc = new ChangePasswordService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) {
		System.out.println("processForm [get]");
		return FORM_VIEW;
	}

	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("processForm [post]");
		// 사용자가 로그인된 상태이므로 세션의 authUser 속성에 회원정보(User 객체)가 붙어 있음
		// 세션에서 회원 정보 가져옴
		User user = (User) req.getSession().getAttribute("authUser");

		Map<String, Boolean> errors = new HashMap<>();
		req.setAttribute("errors", errors);

		String curPwd = req.getParameter("curPwd");
		String newPwd = req.getParameter("newPwd");

		if (curPwd == null || curPwd.isEmpty()) {
			errors.put("curPwd", Boolean.TRUE);
		}
		if (newPwd == null || newPwd.isEmpty()) {
			errors.put("newPwd", Boolean.TRUE);
		}
		if (curPwd != null) {
			if (curPwd.equals(newPwd)) {
				errors.put("samePassword", Boolean.TRUE);
			}
		}
		if (!errors.isEmpty()) {
			return FORM_VIEW;
		}

		try {
			changePwdSvc.changePassword(user.getDocID(), curPwd, newPwd);
			System.out.println("ChangePasswordHandler >> changePwdSvc ");
			return "/WEB-INF/view/changePWD/changePwdSuccess.jsp";
		} catch (InvalidPasswordException e) {
			errors.put("badCurPwd", Boolean.TRUE);
			return FORM_VIEW;
		} catch (MemberNotFoundException e) {
			res.sendError(HttpServletResponse.SC_BAD_REQUEST);
			return null;
		}
	}

}
