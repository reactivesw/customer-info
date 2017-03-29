package io.reactivesw.customer.info.infrastructure.exception;

import io.reactivesw.exception.handler.ExceptionHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * customer info exception handler.
 */
@Component
public class CustomerInfoExceptionHandler extends ExceptionHandler implements
    HandlerExceptionResolver {

  /**
   * exception handler.
   */
  @Override
  public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response,
                                       Object handler, Exception ex) {
    setResponse(request, response, handler, ex);
    return new ModelAndView();
  }
}
