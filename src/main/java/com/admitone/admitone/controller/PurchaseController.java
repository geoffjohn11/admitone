package com.admitone.controller;

import com.admitone.model.Purchase;
import com.admitone.service.PurchaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PurchaseController {

    @Autowired
    private PurchaseService purchaseService;

    @RequestMapping(value = "/purchase", method = RequestMethod.POST)
    public ResponseEntity<Purchase> process(@RequestBody Purchase purchase) {
        return new ResponseEntity<Purchase>(purchaseService.processPurchase(purchase), HttpStatus.OK);
    }

    @RequestMapping(value = "/purchase/{fromShowId}/{toShowId}", method = RequestMethod.GET)
    public ResponseEntity<List<Purchase>> display(@PathVariable("fromShowId") Long fromShowId, @PathVariable("toShowId") Long toShowId) {
        return new ResponseEntity<List<Purchase>>(purchaseService.fetchByShowIdRange(fromShowId, toShowId), HttpStatus.OK);
    }
}
