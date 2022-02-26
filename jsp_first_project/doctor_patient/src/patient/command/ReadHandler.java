package patient.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import patient.service.exception.PatientContentNotFoundException;
import patient.service.PatientData;
import patient.service.exception.PatientNotFoundException;
import patient.service.ReadService;

public class ReadHandler implements CommandHandler {

	private ReadService readService = new ReadService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		// request에 파라미터 즉 "?no=값"을 달고 온다는 의미
		String noVal = req.getParameter("ID");
		if (noVal == null) {
			res.sendRedirect(req.getContextPath() + "/login.do");
			return null;
		}
		String ID = noVal;
		try {
			PatientData patientData = readService.getPatient(ID);
			req.setAttribute("patientData", patientData);
			return "/WEB-INF/view/patients/read.jsp";
		} catch (PatientNotFoundException | PatientContentNotFoundException e) {
			req.getServletContext().log("no patients", e);
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}
}
