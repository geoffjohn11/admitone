package com.admitone.controller;

import com.admitone.model.Exchange;
import com.admitone.service.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by gjohnson on 9/10/16.
 */

@RestController
public class ExchangeController {

    @Autowired
    private TicketServiceImpl ticketService;

    @RequestMapping(value = "/exchange", method = RequestMethod.POST)
    public
    @ResponseBody
    ResponseEntity<Exchange> process(@RequestBody Exchange exchange) {
        ticketService.processExchange(exchange.getUsername(), exchange.getFromShowId(), exchange.getTicketCount(), exchange.getToShowId());
        return new ResponseEntity<Exchange>(exchange, HttpStatus.OK);
    }

}
