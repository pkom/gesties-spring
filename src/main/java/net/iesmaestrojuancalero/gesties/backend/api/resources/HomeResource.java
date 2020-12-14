package net.iesmaestrojuancalero.gesties.backend.api.resources;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class HomeResource {

    @GetMapping()
    public String Home() {
        return "I am an unsecured api endpoint";
    }

    @GetMapping("/secured")
    public String Secured() {
        return "I am an secured api endpoint";
    }

}
