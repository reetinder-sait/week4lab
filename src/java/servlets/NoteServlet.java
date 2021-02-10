
package servlets;

import domain.Note;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class NoteServlet extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            if (request.getParameter("edit").equals("")) {
                getServletContext().getRequestDispatcher("/WEB-INF/editnote.jsp").forward(request, response);
            }
        } catch (Exception e) {
            String path = getServletContext().getRealPath("/WEB-INF/note.txt");
            
            BufferedReader br = new BufferedReader(new FileReader(new File(path)));

            String title = br.readLine();
            String content = br.readLine();
            br.close();
            Note note = new Note(title, content);

            getServletContext().setAttribute("note", note);
            getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);
        }
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String paths = getServletContext().getRealPath("/WEB-INF/note.txt");
    
        PrintWriter print = new PrintWriter(new BufferedWriter(new FileWriter(paths, false)));

        String titleInput = request.getParameter("titleInput");
        String contentsInput = request.getParameter("contentsInput");

        print.write(titleInput + "\n");
        print.write(contentsInput + "\n");
        print.close();

        Note note = new Note(titleInput, contentsInput);

        getServletContext().setAttribute("note", note);
        getServletContext().getRequestDispatcher("/WEB-INF/viewnote.jsp").forward(request, response);

    }

   
    @Override
    public String getServletInfo() {
        return "A simple description";
    }

}
