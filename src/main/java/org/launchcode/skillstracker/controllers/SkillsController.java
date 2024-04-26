package org.launchcode.skillstracker.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@ResponseBody
//@RequestMapping("skills")
public class SkillsController {

    @GetMapping()
    public String skillsTracker() {
        return "<html>" +
                    "<body>" +
                        "<h1>Skills Tracker</h1>" +
                        "<h2>We have a few skills we would like to learn. Here is the list!</h2>" +
                        "<ol>" +
                            "<li>Java</li>" +
                            "<li>JavaScript</li>" +
                            "<li>Python</li>" +
                        "</ol>" +
                    "</body>" +
                "</html>";
    }

    @RequestMapping(method = {RequestMethod.GET, RequestMethod.POST}, value = "skills")
    public String skillsTrackerQueryParam(@RequestParam String name, @RequestParam int code1, @RequestParam int code2, @RequestParam int code3) {

        return "<html>" +
                    "<body>" +
                        "<h1>" + name + "</h1>" +
                        "<ol>" +
                            "<li>" + translate(code1) + "</li>" +
                            "<li>" + translate(code2) + "</li>" +
                            "<li>" + translate(code3) + "</li>" +
                        "</ol>" +
                    "</body>" +
                "</html>";
    }

    @GetMapping("form")
    public String skillsTrackerForm() {
        return "<html>" +
                    "<body>" +
                        "<form action='skills' method='post'>" +
                            "<label>Name:" +
                                "<input type='text' name='name'>" +
                                "<br>" +
                            "</label>" +
                            "<label>My Favorite Language:" +
                                "<select name='code1'>" +
                                    "<option value='1'>Java</option>" +
                                    "<option value='2'>JavaScript</option>" +
                                    "<option value='3'>Python</option>" +
                                "</select>" +
                            "</label>" +
                            "<br>" +
                                "<label>My Second Favorite Language:" +
                                "<select name='code2'>" +
                                    "<option value='1'>Java</option>" +
                                    "<option value='2'>JavaScript</option>" +
                                    "<option value='3'>Python</option>" +
                                "</select>" +
                            "</label>" +
                            "<br>" +
                                "<label>My Third Favorite Language:" +
                                "<select name='code3'>" +
                                    "<option value='1'>Java</option>" +
                                    "<option value='2'>JavaScript</option>" +
                                    "<option value='3'>Python</option>" +
                                "</select>" +
                            "</label>" +
                            "<br>" +
                            "<input type='submit' value='Submit'>" +
                        "</form>" +
                    "</body>" +
                "</html>";
    }

    private String translate(int code) {
        String translation = switch (code) {
            case 1 -> "Java";
            case 2 -> "JavaScript";
            case 3 -> "Python";
            default -> "n/a";
        };
        return translation;
    }
}
