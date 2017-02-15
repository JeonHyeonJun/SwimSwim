package action;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import model.Board;

public class BoardListAction implements Action{

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "/board/boardList.jsp";
		
		BoardDao bd = BoardDao.getInstance();
		
		List<Board> list = bd.selectAllBoards();
		
		req.setAttribute("list", list);
		
		req.getRequestDispatcher(url).forward(req, resp);
	}
	
}
