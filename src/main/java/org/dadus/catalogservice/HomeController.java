package org.dadus.catalogservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class HomeController {
    
    @GetMapping("/{nome}")
    public String getGreeting( @PathVariable("nome") String nome){

        return String.format("Welcome to this book Catalog %s", nome);

    }
}
