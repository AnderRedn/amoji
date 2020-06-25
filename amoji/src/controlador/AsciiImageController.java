package controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AsciiImageController {

	@RequestMapping(value = "/asciiimage.htm", method = RequestMethod.GET)
	public ModelAndView MostrarPage(ModelMap modelo){
		return new ModelAndView("AsciiImage");
	}
}
