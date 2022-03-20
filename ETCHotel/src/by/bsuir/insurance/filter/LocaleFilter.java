package by.bsuir.insurance.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import static by.bsuir.insurance.helper.ServletHelper.LANG;
import static by.bsuir.insurance.helper.ServletHelper.LOCALE;

public class LocaleFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException
    {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String language = request.getParameter(LANG);
        if (language != null && !language.isEmpty()) {
            HttpSession session = request.getSession(true);
            session.setAttribute(LOCALE, language);
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void destroy() {}

}
