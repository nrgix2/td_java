package com.j2ee.tdspring.controllers;

import com.j2ee.tdspring.entities.Exit;
import com.j2ee.tdspring.services.ExitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ExitController {
    @Autowired
    private ExitService exitService;

    @GetMapping(path = "/exits")
    public Exit getUser(@RequestParam(value = "id") Integer id) {
        return exitService.getExitById(id);
    }

    @PutMapping("/exits")
    public Exit addOrUpdateUser(@RequestBody Exit exit) {
        return exitService.createOrUpdate(exit);
    }

    @GetMapping("/exits/all")
    public List<Exit> getUsers() {
        return exitService.getExits();
    }

    @DeleteMapping("/exits")
    public void deleteUser(@RequestParam(value = "id") Integer id) {
    	exitService.deleteExit(id);
    }
}
