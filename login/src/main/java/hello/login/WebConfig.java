package hello.login;

import hello.login.web.interceptor.MyInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

  @Override
  public void addInterceptors(InterceptorRegistry registry) {
    registry.addInterceptor(new MyInterceptor())
        .order(1)
        .addPathPatterns("/**")
        .excludePathPatterns("/css/**", "/*.ico", "/error");
  }

//  @Bean
//  public FilterRegistrationBean myFIlter() {
//    FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//    filterRegistrationBean.setFilter(new MyFilter());
//    filterRegistrationBean.setOrder(1);
//    filterRegistrationBean.addUrlPatterns("/*");
//    return filterRegistrationBean;
//  }

}
