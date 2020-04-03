package eng.dragan.markovic.fon.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@ControllerAdvice
public class MyGlobalExceptionHandlerAdvice {
	/*
	@ExceptionHandler(NullPointerException.class)
	public ModelAndView exceptionHandler(NullPointerException nullPointerException) {
		
		System.out.println("====================================================================");
		System.out.println("@ControllerAdvice exception ocured: NullPointerException===========");
		System.out.println("====================================================================");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("error/globalException");
		modelAndView.addObject("errorObj",nullPointerException);
		modelAndView.addObject("errorMessage",nullPointerException.getMessage());
		
		return modelAndView;
	}
	*/
	
	/*
	@ExceptionHandler(NullPointerException.class)
	public String exceptionHandler(NullPointerException nullPointerException,RedirectAttributes redirectAttributes) {
		
		System.out.println("====================================================================");
		System.out.println("@ControllerAdvice exception ocured: NullPointerException===========");
		System.out.println("====================================================================");
		redirectAttributes.addAttribute("errorMessage", nullPointerException.getMessage());
		
		return "redirect:/error/globalException";
	}
	*/
	
	@ExceptionHandler(NullPointerException.class)
	public String exceptionHandler(NullPointerException nullPointerException,RedirectAttributes redirectAttributes) {
		
		System.out.println("====================================================================");
		System.out.println("@ControllerAdvice exception ocured: NullPointerException===========");
		System.out.println("====================================================================");
		
		redirectAttributes.addFlashAttribute("errorMessage", nullPointerException.getMessage());
		redirectAttributes.addFlashAttribute("errorObj", nullPointerException);
		
		return "redirect:/error/globalException";
	}
}
