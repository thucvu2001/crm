package cybersoft.javabe18.crm.api;

import com.google.gson.Gson;
import cybersoft.javabe18.crm.model.RoleModel;
import cybersoft.javabe18.crm.utils.UrlUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "role", urlPatterns = {UrlUtils.ROLE, UrlUtils.ROLE_ADD})
public class RoleController extends HttpServlet {
    private Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet");

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        req.setCharacterEncoding("UTF-8");

        RoleModel roleModel = new RoleModel();
        roleModel.setId(1);
        roleModel.setName("Vu Van Thuc");
        roleModel.setDescription("Đây là ví dụ về JSON");

        String json = gson.toJson(roleModel);

        PrintWriter printWriter = resp.getWriter();
        printWriter.println(json);
        printWriter.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
