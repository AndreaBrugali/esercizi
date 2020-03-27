package esercizi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/esercizio2")
public class esercizio2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public esercizio2() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		float ope1=Float.parseFloat(request.getParameter("op1"));
		float ope2=Float.parseFloat(request.getParameter("op2"));
		String op =request.getParameter("op");
		
		
		float result=0;
		
		if(op.contentEquals("+"))
		{result=ope1+ope2;}
		else if(op.contentEquals("-"))
		{result=ope1-ope2;}
		else if(op.contentEquals("*"))
		{result=ope1*ope2;}
		else if(op.contentEquals("/"))
		{result=ope1/ope2;}
		response.getWriter().append("operazione => "+ope1+" "+op+" "+ope2+" = "+result);
	}


}
