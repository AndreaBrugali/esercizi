package esercizi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/esercizio1")
public class esercizio1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public esercizio1() {
    
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nS=request.getParameter("num");
		int n=Integer.parseInt(nS);
		System.out.println(n);
		for(int i=1;i<n+1;i++)
		{
			
			for(int a=0;a<i;a++)
			{
				response.getWriter().append("#");
			}
			response.getWriter().append("\n");
		}
	}

}
