package controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
        EType et = new EType();
        model.addAttribute("eType", et);
        return "AnadirNuevo";
	}
	
	@ModelAttribute("listaType")
    public List<EType> getExerciseList(){
		List<EType> listaType = typeBL.listEType();
        return listaType;
    }
	
	 @RequestMapping(method = RequestMethod.POST)    
	public String saveEmoticon(@ModelAttribute("emoji") Emoji e, @ModelAttribute("eType") EType et){
		if (e.getEmoticon()!=null) {
			emojiBL.createEmoji(e);   
		}
		if (et.getNameType()!=null) {
			typeBL.createEType(et);   
		}
         
        return "redirect:/listemojis.htm";//  
    }    
}
