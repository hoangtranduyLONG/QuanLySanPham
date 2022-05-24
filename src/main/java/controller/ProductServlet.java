package controller;

import com.sun.deploy.security.JarSignature;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", value = "/ProductServlet")
public class ProductServlet<ProductServiceImpl> extends HttpServlet {
    ProductServiceImpl productService = new ProductServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            default:
                showListPage(request, response);
        }
        private void showEditForm (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException JarSignature productService;
        {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/edit.jsp");
            int id = Integer.parseInt(request.getParameter("id"));
            Product product = productService.findProductById(id);
            request.setAttribute("sanPham", product);
            requestDispatcher.forward(request, response);
        }

        private void showCreateForm (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/create.jsp");
            requestDispatcher.forward(request, response);
        }

        private void showListPage (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("product/list.jsp");
            List<Product> products = productService.findAll();
            request.setAttribute("danhSach", products);
            requestDispatcher.forward(request, response);
        }
        @Override
        protected void doPost (HttpServletRequest request, HttpServletResponse response) throws
        ServletException, IOException {
            String action = request.getParameter("action");
            if (action == null) {
                action = "";
            }
            switch (action) {
                case "create":
                    createForm(request, response);
                    break;
                case "edit":
                    editForm(request, response);
                    break;
            }
        }

        private void editForm (HttpServletRequest request, HttpServletResponse response) throws IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            int price = Integer.parseInt(request.getParameter("price"));
            String name = request.getParameter("name");
            productService.update(id, new Product(id, name, price));
            response.sendRedirect("/products");
        }

        private void createForm (HttpServletRequest request, HttpServletResponse response) throws IOException {
            int id = Integer.parseInt(request.getParameter("id"));
            int price = Integer.parseInt(request.getParameter("price"));
            String name = request.getParameter("name");
            productService.save(new Product(id, name, price));
            response.sendRedirect("/products");
        }
    }

    private void editForm(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showListPage(HttpServletRequest request, HttpServletResponse response) {
    }

    private void createForm(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
    }
}
