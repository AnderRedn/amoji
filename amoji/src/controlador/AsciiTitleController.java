package controlador;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import modelo.Asciitext;

@Controller
public class AsciiTitleController {

	@RequestMapping(value = "/asciititle.htm", method = RequestMethod.GET)
	public String showAsciiTitleForm(Model model) {
		Asciitext text = new Asciitext();
        model.addAttribute("textAscii", text);
		return "AsciiTitle";
	}
	
	@ModelAttribute("listaEstilos")
    public String[] getTypeList(){
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject("http://artii.herokuapp.com/fonts_list", String.class);
		String[] types = result.split("\n");
        return types;
    }
	
	@RequestMapping(value = "/getasciititle.htm", method = RequestMethod.GET)
	public String showAsciiTitle(@ModelAttribute("textAscii") Asciitext a, Model model) {
		RestTemplate restTemplate = new RestTemplate();
		String result= null;
		if(a.getInputStyle()!=null) {
			result = restTemplate.getForObject("http://artii.herokuapp.com/make?text={text}&font={font}", String.class,a.getInputText(),a.getInputStyle());
		}else {
			result = restTemplate.getForObject("http://artii.herokuapp.com/make?text={text}", String.class,a.getInputText());			
		}

        model.addAttribute("textPlain", result);
		return "AsciiTitle";
	}
}
