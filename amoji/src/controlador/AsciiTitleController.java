package controlador;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import modelo.Asciitext;
import modelo.EType;

@Controller
public class AsciiTitleController {

	@RequestMapping(value = "/asciititle.htm", method = RequestMethod.GET)
	public String showAsciiTitleForm(Model model) {
		Asciitext text = new Asciitext();
        model.addAttribute("textAscii", text);
		return "AsciiTitle";
	}
	
	@ModelAttribute("listaEstilos")
    public String[] getExerciseList(){
		RestTemplate restTemplate = new RestTemplate();
		String result = restTemplate.getForObject("http://artii.herokuapp.com/fonts_list", String.class);
		String[] types = result.split("\n");
        return types;
    }
	
	@RequestMapping(value = "/getasciititle.htm", method = RequestMethod.GET)
	public String showAsciiTitle(@ModelAttribute("textAscii") Asciitext a, Model model) {
		String inputText = String.join("+", a.getInputText().split(" "));
		String urlStr = "http://artii.herokuapp.com/make?text="+inputText;
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
