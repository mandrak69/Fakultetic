package eng.dragan.markovic.fon.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/*
 * ne koristim vise, koristim sada @ControllerAdvice klasu
 */

//@Component
public class MyGlobalExceptionHandler implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		
		System.out.println("==========================================================");
		System.out.println("====== MyGlobalExceptionHandler ==========================");
		System.out.println("==========================================================");
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("error/globalException");
		modelAndView.addObject("errorObj",ex);
		modelAndView.addObject("errorMessage",ex.getMessage());
		
		return modelAndView;
	}

}
