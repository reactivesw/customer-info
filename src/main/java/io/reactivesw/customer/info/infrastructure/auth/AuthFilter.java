package io.reactivesw.customer.info.infrastructure.auth;

import io.reactivesw.customer.info.infrastructure.exception.CustomerInfoExceptionHandler;
import io.reactivesw.exception.AuthFailedException;
import io.reactivesw.exception.TokenMissingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * auth filter.
 */
//@Component
public class AuthFilter implements Filter {

  /**
   * logger.
   */
  private static final Logger LOG = LoggerFactory.getLogger(AuthFilter.class);

  //  @Autowired
  //  private transient CartAuthProvider authProvider;

  /**
   * cart exception handler.
   */
  @Autowired
  private transient CustomerInfoExceptionHandler exceptionHandler;

  /**
   * init.
   */
  @Override
  public void init(FilterConfig arg0) throws ServletException {
    // do nothing
  }

  /**
   * auth filter.
   *
   * @param request  ServletRequest
   * @param response ServletResponse
   * @param next     FilterChain
   */
  @Override
  public void doFilter(ServletRequest request, ServletResponse response,
                       FilterChain next) throws IOException, ServletException {
    try {
      // verify if access should be granted
      checkAuth((HttpServletRequest) request);

      next.doFilter(request, response);
    } catch (AuthFailedException ex) {
      LOG.debug("check auth failed. request:{}", request, ex);
      exceptionHandler.setResponse((HttpServletRequest) request, (HttpServletResponse) response,
          null, ex);
    }
  }

  /**
   * check auth function.
   *
   * @param request HttpServletRequest
   */
  private void checkAuth(HttpServletRequest request) {

    String header = request.getHeader("Authorization");

    if (header == null || !header.startsWith("Bearer ")) {
      throw new TokenMissingException("No auth token found in request headers.");
    }

    String tokenString = header.substring(7);


    //    authProvider.checkToken(token);

    LOG.debug("customer auth token:{}", tokenString);
  }


  /**
   * destroy.
   */
  @Override
  public void destroy() {
    // do nothing
  }
}
