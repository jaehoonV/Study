package auth.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import mvc.command.CommandHandler;

public class LogoutHandler implements CommandHandler {

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		System.out.println("LogoutHandler");
		// 로그아웃은 세션을 invalidate해주는것이 목표
		// req.getSession().invalidate();
		
		// HttpSession이 존재하면 현재 HttpSession을 반환하고 존재하지 않으면 새로이 생성하지 않고 그냥 null을 반환합니다
		HttpSession session = req.getSession(false);
		if (session != null) {
			session.invalidate();
		}
		// index.jsp 페이지로 돌아감
		res.sendRedirect(req.getContextPath() + "/index.jsp");
		return null;
	}

}
