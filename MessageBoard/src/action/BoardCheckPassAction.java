package action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.BoardDao;
import model.Board;

public class BoardCheckPassAction implements Action{

	@Override
	public void excute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = null;
		
		String num = req.getParameter("num");
		String pass = req.getParameter("pass");
		
		BoardDao bd = BoardDao.getInstance();
		Board board = bd.selectOneBoardByNum(num);
		
		if(board.getPass().equals(pass))
			url = "/board/checkSuccess.jsp";
		else{
			url = "/board/boardCheckPass.jsp";
			req.setAttribute("msg", "비밀번호가 일치하지 않습니다");
		}
		
		req.getRequestDispatcher(url).forward(req, resp);
	}

}
