package patient.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mvc.command.CommandHandler;
import patient.service.ListPage;
import patient.service.ListService;

public class ListHandler implements CommandHandler{
	
	private ListService listService = new ListService();

	@Override
	public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
		String pageNoVal = req.getParameter("pageNo");
		int pageNo = 1;
		if (pageNoVal != null) {
			pageNo = Integer.parseInt(pageNoVal);
		}
		ListPage listPage = listService.getListPage(pageNo);
		req.setAttribute("listPage", listPage);
		return "/WEB-INF/view/patients/listPatients.jsp";
	}

}
