package controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MenuController {


	@RequestMapping(value = "/menu.htm")
	public ModelAndView showMenu() {
		return new ModelAndView("menu");
	}

}
