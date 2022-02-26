package patient.service;

import java.util.List;

import patient.model.Patients;

//DB에서 받은 게시글 10개를 페이징 처리하기 위한 값들과 함께 묶어서 프론트로 전달하기 위한 객체
public class ListPage {

	private int total;
	private int currentPage;
	private List<Patients> content;
	private int totalPages;
	private int startPage;
	private int endPage;

	public ListPage(int total, int currentPage, int size, List<Patients> content) {
		this.total = total;
		this.currentPage = currentPage;
		this.content = content;
		if (total == 0) {
			totalPages = 0;
			startPage = 0;
			endPage = 0;
		} else {
			totalPages = total / size;
			if (total % size > 0) {
				totalPages++;
			}
			int modVal = currentPage % 5;
			startPage = currentPage / 5 * 5 + 1;
			if (modVal == 0) startPage -= 5;
			
			endPage = startPage + 4;
			if (endPage > totalPages) endPage = totalPages;
		}
	}

	public int getTotal() {
		return total;
	}

	public boolean hasNoPatients() {
		return total == 0;
	}

	public boolean hasPatients() {
		return total > 0;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}

	public int getTotalPages() {
		return totalPages;
	}

	public List<Patients> getContent() {
		return content;
	}

	public int getStartPage() {
		return startPage;
	}
	
	public int getEndPage() {
		return endPage;
	}
}

