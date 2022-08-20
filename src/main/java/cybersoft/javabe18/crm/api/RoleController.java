package cybersoft.javabe18.crm.api;

import com.google.gson.Gson;
import cybersoft.javabe18.crm.model.RoleModel;
import cybersoft.javabe18.crm.services.RoleServices;
import cybersoft.javabe18.crm.utils.UrlUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "role", urlPatterns = {
        UrlUtils.ROLE,
        UrlUtils.ROLE_ADD
})
public class RoleController extends HttpServlet {

    private final Gson gson = new Gson();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<RoleModel> roleModels = RoleServices.getINSTANCE().getAllRole();

        String json = gson.toJson(roleModels);

        resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        resp.addHeader("Access-Control-Allow-Origin", "*");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = resp.getWriter();
        printWriter.println(json);
        printWriter.flush();

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {

    }
}
