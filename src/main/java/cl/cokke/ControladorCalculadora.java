package cl.cokke;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class ControladorCalculadora {

	@GetMapping(value={"/index","/"})
	public String indexCalculadora(@RequestParam(name="numero1",defaultValue = "0") 
		String num1,@RequestParam(name="numero2", defaultValue = "0") String num2, Model model) {
		
		model.addAttribute("numeroA", num1);
		model.addAttribute("numeroB", num2);
		
		return "index";
	}
	
	@PostMapping(value="/calcular")
	public String indexCalculadoraRespuesta(@RequestParam(name="numero1",defaultValue = "0") 
			String num1,@RequestParam(name="numero2", defaultValue = "0") String num2, Model model ) {
		
		Double A = Double.parseDouble(num1);
		Double B = Double.parseDouble(num2);
		Double suma = A + B;
		Double resta = A - B;
		Double mult = A * B;
		Double div = A / B;
		
		model.addAttribute("numeroA", num1);
		model.addAttribute("numeroB", num2);
		model.addAttribute("resultSuma", "La suma de "+ num1+" + " + num2 +" es: "+ suma);
		model.addAttribute("resultResta", "La resta de "+ num1+" - " + num2 +" es: "+ resta);
		model.addAttribute("resultMult", "La multiplicacion de "+ num1+" * " + num2 +" es: "+ mult);
		model.addAttribute("resultDiv", "La divición de "+ num1+" / " + num2 +" es: "+ div);
		System.out.println(num1);
	
		return "index";
	}
	
	
}
