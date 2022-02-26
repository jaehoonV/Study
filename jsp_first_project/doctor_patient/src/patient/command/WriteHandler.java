package patient.command;

import java.io.IOException;

import javax.naming.NamingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import patient.service.exception.PermissionDeniedException;
import mvc.command.CommandHandler;
import patient.service.PatientData;
import patient.service.exception.PatientNotFoundException;
import patient.service.ReadService;
import patient.service.WriteRequest;
import patient.service.WriteService;

public class WriteHandler implements CommandHandler{
	private static final String FORM_VIEW = "/WEB-INF/view/patients/writeForm.jsp";
	
	private ReadService readService = new ReadService();
	private WriteService writeService = new WriteService();
	
	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		if (req.getMethod().equalsIgnoreCase("GET")) {
			return processForm(req, res);
		} else if (req.getMethod().equalsIgnoreCase("POST")) {
			return processSubmit(req, res);
		} else {
			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			return null;
		}
	}

	private String processForm(HttpServletRequest req, HttpServletResponse res) throws NamingException, IOException {
		try {
			String noVal = req.getParameter("ID");
			String ID = noVal;
			PatientData patientData = readService.getPatient(ID);
			
			WriteRequest wtReq = new WriteRequest(patientData.getPatients().getPatientID(),
					patientData.getDiagnosis(), patientData.getPrescription());
			req.setAttribute("wtReq", wtReq);
			return FORM_VIEW;
		} catch (PatientNotFoundException e) {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		}
	}
	
	private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws IOException, NamingException {
		
		System.out.println("WriteHandler >> processSubmit");
		String noVal = req.getParameter("ID");

		WriteRequest wtReq = new WriteRequest(noVal, req.getParameter("diagnosis"), req.getParameter("prescription"));
		req.setAttribute("wtReq", wtReq);

		try {
			writeService.write(wtReq);
			return "/WEB-INF/view/patients/writeSuccess.jsp";
		} catch (PatientNotFoundException e) {
			res.sendError(HttpServletResponse.SC_NOT_FOUND);
			return null;
		} catch (PermissionDeniedException e) {
			res.sendError(HttpServletResponse.SC_FORBIDDEN);
			return null;
		}
	}

	
}
