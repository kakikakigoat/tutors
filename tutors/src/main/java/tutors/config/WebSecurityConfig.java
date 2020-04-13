package tutors.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import tutors.domain.service.user.*;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	LoginUserDetailsService userDetailsService;

	@Bean 
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


	@Override
	public void configure(WebSecurity web)throws Exception {
		//以下のディレクトリやファイルに関してはアクセス可能
		web.ignoring().antMatchers("/css/**","/js/**","/images/**","/fonts/**");
	}


	@Override
	protected void configure(HttpSecurity http)throws Exception {
		http.authorizeRequests()//認証が必要となるURLを設定
		.antMatchers("/signUp/**","/index").permitAll()//account以下のURLも認証不要
		.anyRequest().authenticated()//それ以外は全て認証された状態
		.and()	
		.formLogin()
		.loginPage("/login")//ログインフォームのパス
		.loginProcessingUrl("/login")//認証機能を起動させるパス
		.usernameParameter("mailAddress")//リクエストパラメータのname属性を表示
		.passwordParameter("password")
		.defaultSuccessUrl("/top",true)//認証成功時のURL
		.failureUrl("/login?error=ture").permitAll();

		http.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout**"))//ログアウト処理を起動させるパス
		.logoutSuccessUrl("/index");//ログアウト完了時のパス
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
}


