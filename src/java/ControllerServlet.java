/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import persistence.Product;
import persistence.ProductCategory;
import persistence.ProductCategoryFacade;
import persistence.ProductFacade;
import persistence.ProductImageFacade;
import persistence.ProductInstance;
import persistence.ProductInstanceFacade;
import persistence.Shop;
import persistence.ShopFacade;
import persistence.ShoppingCartLine;
import persistence.ShoppingCartLineFacade;
import persistence.Shoppingcart;

/**
 *
 * @author 11365866
 */
@WebServlet(name = "ControllerServlet", urlPatterns = {"/index",  "/search", "/cart", ""})
public class ControllerServlet extends HttpServlet {
    @EJB
    private ProductCategoryFacade productCategoryFacade;
    @EJB
    private ShopFacade shopFacade;
    @EJB
    private ProductFacade productFacade;
    @EJB
    private ProductImageFacade productImageFacade;
    @EJB
    private ProductInstanceFacade productInstanceFacade;
    @EJB
    private ShoppingCartLineFacade shoppingCartLineFacade;
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        
        List categories = productCategoryFacade.findAll();
        request.setAttribute("categories", categories);
        List shops = shopFacade.findAll();
        request.setAttribute("shops", shops);
        List<Product> products = productFacade.findAll();
        String searchQuery = "";
        
        String userPath = request.getServletPath();
        if (userPath.isEmpty()) userPath = "/index";
        else if(userPath.equals("/search")) {
            searchQuery = request.getParameter("q");
            String categoryQuery = request.getParameter("c");
            String shopName = request.getParameter("s");
            Shop shop = null;
            if (shopName != null) {
                shop = shopFacade.findByName(shopName);
                if (categoryQuery != null) {
                    ProductCategory category = productCategoryFacade.findByName(categoryQuery);
                    products = productFacade.findByQueryAndShopAndCategory(searchQuery == null ? "" : searchQuery, shop, category);
                    request.setAttribute("categoryQuery", categoryQuery);
                } else {
                    products = productFacade.findByQueryAndShop(searchQuery == null ? "" : searchQuery, shop);
                }
                request.setAttribute("shopName", shopName);
            } else if (categoryQuery != null) {
                ProductCategory category = productCategoryFacade.findByName(categoryQuery);
                products = productFacade.findByQueryAndCategory(searchQuery == null ? "" : searchQuery, category);
                request.setAttribute("categoryQuery", categoryQuery);
            } else {
                assert(searchQuery != null);
                products = productFacade.findByQuery(searchQuery);
            }
            
            // Find specific product instances in different shops.
            ArrayList<ProductInstance> productInstances = new ArrayList<ProductInstance>();
            for (int i = 0; i < products.size(); ++i) {
                Product p = products.get(i);
                List<ProductInstance> instances = productInstanceFacade.findByProduct(p);
                if (!instances.isEmpty()) {
                    productInstances.add(instances.get(0));
                }
            }
            request.setAttribute("productInstances", productInstances);
            
            userPath = "/index";
        }
        else if (userPath.equals("/cart")) {
            Shoppingcart cart = new Shoppingcart();
            cart.setId(0);
            List<ShoppingCartLine> lines = shoppingCartLineFacade.findByShoppingCart(cart);
            request.setAttribute("lines", lines);
            userPath = "/cart";
        }
        
        request.setAttribute("products", products);
        request.setAttribute("searchQuery", searchQuery);
        
        String url = userPath + ".jsp";
        try {                   
            getServletContext().getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
