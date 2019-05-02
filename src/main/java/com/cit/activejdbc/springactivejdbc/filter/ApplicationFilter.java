package com.cit.activejdbc.springactivejdbc.filter;

import lombok.extern.slf4j.Slf4j;
import org.javalite.activejdbc.Base;
import org.springframework.stereotype.Service;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by timad on 4/30/2019.
 */
@Slf4j
@Service
public class ApplicationFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        log.info("Resources opened ..................");
    }

    @Override
    public void destroy() {
        log.info("Resources destroyed ..................");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        Long beforeTime = System.currentTimeMillis();
        try {
//            Base.open("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/tests", "root", "root");
            Base.open("com.mysql.cj.jdbc.Driver", "jdbc:mysql://localhost:3306/tests?autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC", "root", "root");
            Base.openTransaction();
            filterChain.doFilter(servletRequest, servletResponse);
            Base.commitTransaction();
        } catch (IOException | ServletException e) {
            Base.rollbackTransaction();
            log.error("error occurred :: {}", e.getMessage());
            throw e;
        } finally {
            Base.close();
        }
        log.info("Processing time taken:: {} milliseconds", System.currentTimeMillis() - beforeTime);

    }
}
