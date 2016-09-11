package com.admitone.controller;

import com.admitone.model.Cancellation;
import com.admitone.service.TicketServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by gjohnson on 9/10/16.
 */

@RestController
public class CancellationController {

    @Autowired
    private TicketServiceImpl ticketService;

    @RequestMapping(value = "/cancel", method = RequestMethod.POST)
    public @ResponseBody ResponseEntity<Cancellation> process(@RequestBody Cancellation cancellation){
        ticketService.processCancellation(cancellation.getUsername(), cancellation.getShowId(), cancellation.getTicketCount());
        return new ResponseEntity<Cancellation>(cancellation, HttpStatus.OK);
    }

}
