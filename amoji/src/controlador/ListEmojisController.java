package controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import modelo.EType;
import modelo.Emoji;
import negocio.ETypeBL;
import negocio.EmojiBL;

@Controller
public class ListEmojisController {

	@Autowired
	EmojiBL emojiBL;
	
	@Autowired
	ETypeBL typeBL;

	@RequestMapping(value = "/listemojis.htm", method=RequestMethod.GET)
	public String listEmojis(Model model) {
		EType e =new EType();
		List<Emoji> lista = emojiBL.listEmojis();
        model.addAttribute("listado", lista);
        
        model.addAttribute("myEType", e);
        return "ListEmojis";

    
		/*List<Emoji> lista = emojiBL.listEmojis();
		List<EType> listaType = typeBL.listEType();
		return new ModelAndView("ListEmojis", "listado", lista);*/
	}
	
	@ModelAttribute("listaType")
    public List<EType> getExerciseList(){
		List<EType> listaType = typeBL.listEType();
        return listaType;
    }
	
	/*@RequestMapping(method=RequestMethod.POST)
	public String sortByType(@ModelAttribute("listaType") EType eType, Model model){
	    //dogFromForm.getBreed() will give you the selected breed from the <form:select
		List<Emoji> lista = emojiBL.getEmojisByType(eType.getIdType());
		List<EType> listaType = typeBL.listEType();
		model.addAttribute("listaType", listaType);
        model.addAttribute("listado", lista);
        model.addAttribute("myEType", new EType());
        return "redirect:listemojis.htm";
	}*/
	
	@RequestMapping(value = "/listaType.htm", method=RequestMethod.GET)
    public String listaType(@RequestParam("idType") int idType, Model model) {
		List<Emoji> lista = emojiBL.getEmojisByType(idType);
        model.addAttribute("listado", lista);
        EType e =new EType();
        
        model.addAttribute("myEType", e);
        return "ListEmojis";
    }
	
	// /EliminarProyecto.htm?id=4
		@RequestMapping(value="/EliminarEmoticono.htm")
		public String eliminarProyecto(@RequestParam("idEmoticon") int idEmoticon){
			emojiBL.deleteEmoji(idEmoticon);
			return "redirect:listemojis.htm";
		}

}
