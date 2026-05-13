package API.Rest.da.aplicacao.Voll.med.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
// teste da api
public class HelloController {
    @GetMapping
    public String olaMundo() {
        return "teste";
    }
}
