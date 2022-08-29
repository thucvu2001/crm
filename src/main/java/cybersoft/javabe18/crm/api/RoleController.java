package cybersoft.javabe18.crm.api;

import com.google.gson.Gson;
import cybersoft.javabe18.crm.model.ResponseData;
import cybersoft.javabe18.crm.model.RoleModel;
import cybersoft.javabe18.crm.services.RoleServices;
import cybersoft.javabe18.crm.utils.UrlUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
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
        PrintWriter printWriter = resp.getWriter();
        printWriter.println(json);
        printWriter.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String role = req.getParameter("role");
        String description = req.getParameter("description");
        Integer result = RoleServices.getINSTANCE().saveRole(role, description);
        ResponseData responseData = new ResponseData();
        responseData.setStatusCode(200);
        if (result == 1) {
            responseData.setSuccess(true);
            responseData.setMessage("Thêm thành công!");
        } else {
            responseData.setSuccess(false);
            responseData.setMessage("Thêm thất bại!");
        }
        PrintWriter printWriter = resp.getWriter();
        printWriter.println(gson.toJson(responseData));
        printWriter.flush();
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String id = req.getParameter("id");
        Integer result = RoleServices.getINSTANCE().deleteRoleById(id);
        ResponseData responseData = new ResponseData();
        responseData.setStatusCode(200);
        if (result == 1) {
            responseData.setSuccess(true);
            responseData.setMessage("Xoá thành công!");
        } else {
            responseData.setSuccess(false);
            responseData.setMessage("Xoá thất bại!");
        }
        PrintWriter printWriter = resp.getWriter();
        printWriter.println(gson.toJson(responseData));
        printWriter.flush();
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedReader br = new BufferedReader(req.getReader());
        StringBuilder builder = new StringBuilder();
        String line;
        while ((line = br.readLine()) != null) {
            builder.append(line);
            builder.append("\n");
        }
        String data = builder.toString();
        RoleModel roleModel = gson.fromJson(data, RoleModel.class);
        RoleServices.getINSTANCE().updateRoleById(roleModel);
        Integer result = RoleServices.getINSTANCE().updateRoleById(roleModel);
        ResponseData responseData = new ResponseData();
        responseData.setStatusCode(200);
        if (result == 1) {
            responseData.setSuccess(true);
            responseData.setMessage("Update thành công!");
        } else {
            responseData.setSuccess(false);
            responseData.setMessage("Update thất bại!");
        }
        PrintWriter printWriter = resp.getWriter();
        printWriter.println(gson.toJson(responseData));
        printWriter.flush();
        System.out.println("Kiem tra doPut: " + roleModel.getId() + " " + roleModel.getName() + " " + roleModel.getDescription());
    }
}
