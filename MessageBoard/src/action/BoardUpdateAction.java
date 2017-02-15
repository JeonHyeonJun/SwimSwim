package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import model.Board;

public class BoardUpdateAction implements Action{

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Board board = new Board();
		
		board.setNum(Integer.parseInt(req.getParameter("num")));
		board.setName(req.getParameter("name"));
		board.setPass(req.getParameter("pass"));
		board.setEmail(req.getParameter("email"));
		board.setTitle(req.getParameter("title"));
		board.setContent(req.getParameter("content"));
		
		BoardDao bd = BoardDao.getInstance();
		bd.updateBoard(board);
		
		new BoardListAction().excute(req, resp);
	}

}
