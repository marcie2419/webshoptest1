package hu.gerviba.webschop.web;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import hu.gerviba.webschop.service.CircleService;

@Controller
@PreAuthorize("hasRole('ADMIN')")
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    CircleService circles;
    
	@GetMapping("/")
	public String adminRoot(Map<String, Object> model) {
        model.put("circles", circles.findAll());
		return "admin";
	}

	@GetMapping("/circles")
	public String adminCircles(Map<String, Object> model) {
		model.put("circles", circles.findAll());
		return "admin";
	}

    @GetMapping("/circles/new")
    public String adminAddCircle(Map<String, Object> model) {
        model.put("circles", circles.findAll());
        return "admin";
    }

    @GetMapping("/circles/edit")
    public String adminEditCircle(Map<String, Object> model) {
        model.put("circles", circles.findAll());
        return "admin";
    }

    @GetMapping("/circles/delete")
    public String adminDeleteCircle(Map<String, Object> model) {
        model.put("circles", circles.findAll());
        return "admin";
    }
    
}
