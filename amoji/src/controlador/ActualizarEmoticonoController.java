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
@RequestMapping(value = "/ActualizarEmoticono.htm")
public class ActualizarEmoticonoController {

	@Autowired
	EmojiBL emojiBL;

	@Autowired
	ETypeBL typeBL;

	@RequestMapping(method = RequestMethod.GET)
	public String mostrarFormAnadirNuevo(Model model, int idEmoticon) {
		Emoji e = new Emoji();
		Emoji eget = emojiBL.getEmojiById(idEmoticon);
		e.setEmoticon(eget.getEmoticon());
		e.setIdEmoticon(eget.getIdEmoticon());
		e.setName(eget.getName());
		e.setIdType(eget.getIdType());
		model.addAttribute("emojiUpd", e);
		EType et = new EType();
		model.addAttribute("eType", et);
		return "ActualizarEmoticono";

	}

	@ModelAttribute("listaType")
	public List<EType> getExerciseList() {
		List<EType> listaType = typeBL.listEType();
		return listaType;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String saveEmoticon(@ModelAttribute("emojiUpd") Emoji e) {
		emojiBL.updateEmoji(e);
		return "redirect:/listemojis.htm";//
	}
}
