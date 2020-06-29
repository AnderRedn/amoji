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

	@RequestMapping(value = "/listemojis.htm", method = RequestMethod.GET)
	public String listEmojis(Model model) {
		EType e = new EType();
		List<Emoji> lista = emojiBL.listEmojis();
		model.addAttribute("listado", lista);

		model.addAttribute("myEType", e);
		return "ListEmojis";

	}

	@ModelAttribute("listaType")
	public List<EType> getTypeList() {
		List<EType> listaType = typeBL.listEType();
		return listaType;
	}

	@RequestMapping(value = "/listaType.htm", method = RequestMethod.GET)
	public String listaType(@RequestParam("idType") int idType, Model model) {
		List<Emoji> lista = emojiBL.getEmojisByType(idType);
		model.addAttribute("listado", lista);
		EType e = new EType();

		model.addAttribute("myEType", e);
		return "ListEmojis";
	}

	@RequestMapping(value = "/EliminarEmoticono.htm")
	public String eliminarEmoticono(@RequestParam("idEmoticon") int idEmoticon) {
		emojiBL.deleteEmoji(idEmoticon);
		return "redirect:listemojis.htm";
	}

}
