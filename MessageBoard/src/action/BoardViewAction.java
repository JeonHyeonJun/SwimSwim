package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import model.Board;

public class BoardViewAction implements Action{

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = "/board/boardView.jsp";
		
		String num = req.getParameter("num");
		BoardDao bd = BoardDao.getInstance();
		bd.updateReadCount(num);
		Board board = bd.selectOneBoardByNum(num);
		req.setAttribute("board", board);
		req.getRequestDispatcher(url).forward(req, resp);
	}

}
