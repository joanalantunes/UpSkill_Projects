package Agrupo5.upskill.agrupo5.upskill.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@Controller
public class ImageController {

    @RequestMapping(value = "/user-photos/{id}/{imageName}")
    @ResponseBody
    public byte[] getImage(@PathVariable(value = "id") Long id, @PathVariable(value = "imageName") String imageName) throws IOException {
        File serverFile = new File("user-photos/" + id + "/" + imageName);

        return Files.readAllBytes(serverFile.toPath());
    }
}
