package controlador;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import modelo.EType;
import modelo.Emoji;
import negocio.ETypeBL;
import negocio.EmojiBL;


@Controller
@RequestMapping(value="/anadirnuevo.htm")
public class AnadirNuevoController {
	
	@Autowired
	EmojiBL emojiBL;
	
	@Autowired
	ETypeBL typeBL;
	
	@RequestMapping(method=RequestMethod.GET)
	public String mostrarFormAnadirNuevo(Model model) {
		Emoji e = new Emoji();
        model.addAttribute("emoji", e);
        return "AnadirNuevo";

    
		/*List<Emoji> lista = emojiBL.listEmojis();
		List<EType> listaType = typeBL.listEType();
		return new ModelAndView("ListEmojis", "listado", lista);*/
	}
	
	@ModelAttribute("listaType")
    public List<EType> getExerciseList(){
		List<EType> listaType = typeBL.listEType();
        return listaType;
    }
	
	 @RequestMapping(method = RequestMethod.POST)    
	public String saveEmoticon(@ModelAttribute("emp") Emoji e){    
        emojiBL.createEmoji(e);    
        return "redirect:/listemojis.htm";//  
    }    
}
