package br.mp.mpf.simpletests.infra.spring;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate4.support.OpenSessionInViewInterceptor;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ComponentScan(basePackages = "br.mp.mpf.simpletests.web")
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
	registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
    }

    @Bean
    public OpenSessionInViewInterceptor openSessionInViewInterceptor() {
	OpenSessionInViewInterceptor interceptor = new OpenSessionInViewInterceptor();
	interceptor.setSessionFactory(sessionFactory);

	return interceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
	registry.addWebRequestInterceptor(openSessionInViewInterceptor());
    }

}
