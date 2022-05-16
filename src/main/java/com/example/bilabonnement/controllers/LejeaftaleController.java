package com.example.bilabonnement.controllers;

import com.example.bilabonnement.models.Bil;
import com.example.bilabonnement.models.Kunde;
import com.example.bilabonnement.models.Lejeaftale;
import com.example.bilabonnement.repository.LejeaftaleRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.context.request.WebRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;

@Controller
public class LejeaftaleController {

    BilController bc = new BilController();
    LejeaftaleRepository lr = new LejeaftaleRepository();

    @PostMapping("/lejeaftaler")
    public String opretLejeaftale(WebRequest dataFromForm, HttpServletRequest request, RequestBody requestBody) throws SQLException {
        HttpSession session = request.getSession();

        Bil bil = (Bil) session.getAttribute("bil");
        Kunde kunde = (Kunde) session.getAttribute("kunde");
        boolean status = true;

        Lejeaftale lejeaftale = new Lejeaftale(bil, kunde, status);
        lr.indsætLejeaftale(lejeaftale);
        return "redirect:/lejeaftaler";
    }

}
