package ir.whentomeet.backend.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "Some awesome API is gonna be born here!\n";
    }
}
