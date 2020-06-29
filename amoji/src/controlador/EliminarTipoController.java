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
import negocio.ETypeBL;

@Controller
public class EliminarTipoController {

	@Autowired
	ETypeBL typeBL;

	@RequestMapping(value = "/eliminartipo.htm", method = RequestMethod.GET)
	public String mostrarFormEliminarTipo(Model model) {
		EType et = new EType();
		model.addAttribute("eType", et);
		return "EliminarTipo";
	}

	@ModelAttribute("listaType")
	public List<EType> getTypeList() {
		List<EType> listaType = typeBL.listEType();
		return listaType;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String eliminarTipo(@RequestParam("idType") int idType) {
		typeBL.deleteEmoji(idType);
		return "redirect:listemojis.htm";
	}
}
