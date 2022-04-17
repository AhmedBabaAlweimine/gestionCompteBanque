package com.alweimine.banquesi.web;

import com.alweimine.banquesi.services.OperationService;
import com.alweimine.banquesi.services.PageOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperationRestController {
    @Autowired
    private OperationService operationService;


    @RequestMapping(value = "/versement",method = RequestMethod.PUT)
    public boolean verser(@RequestParam String code,
                          @RequestParam double montant,
                          @RequestParam Long codeEmpl) {
        return operationService.verser(code, montant, codeEmpl);
    }

    @RequestMapping(value = "/retrait",method = RequestMethod.PUT)
    public boolean retirer(@RequestParam String code,
                           @RequestParam double montant,
                           @RequestParam Long codeEmpl) {
        return operationService.retirer(code, montant, codeEmpl);
    }
    @RequestMapping(value = "/virement",method = RequestMethod.PUT)
    public boolean virement(@RequestParam String compt1,
                            @RequestParam String compt2,
                            @RequestParam double montant,
                            @RequestParam Long codeEmpl) {
        return operationService.virement(compt1, compt2, montant, codeEmpl);
    }
    @RequestMapping(value = "/operations",method = RequestMethod.GET)
    public PageOperation getOperations(@RequestParam String codeCompte,
                                       @RequestParam int page,
                                       @RequestParam int size) {
        PageOperation pageOperation= operationService.getOperations(codeCompte, page, size);
        return pageOperation;
    }
}
