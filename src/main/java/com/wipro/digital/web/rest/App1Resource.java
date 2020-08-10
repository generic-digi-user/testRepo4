package com.wipro.digital.web.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;



/**
 * App1Resource
 */
@RestController
@RequestMapping("/api/app-1")
public class App1Resource {

    private final Logger log = LoggerFactory.getLogger(App1Resource.class);

     /**
     * GET getAction
     */
    @GetMapping("/get-action")
    public String getAction() {

       return " \r\n Hi from Accelerator !!! This is an example controller, please modify it to have your specifics !! \r\n \r\n";


    }

   /**
      * PUT putAction
      */
      @PutMapping("/put-action")
      public String putAction() {
          return "putAction";
      }

      /**
      * POST postAction
      */
      @PostMapping("/post-action")
      public String postAction() {
          return "postAction";
      }

      /**
      * DELETE deleteAction
      */
      @DeleteMapping("/delete-action")
      public String deleteAction() {
          return "deleteAction";
      }
}
