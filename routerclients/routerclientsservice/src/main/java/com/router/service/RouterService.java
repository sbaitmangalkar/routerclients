package com.router.service;

import java.io.IOException;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.TextPage;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebClientOptions;
import com.gargoylesoftware.htmlunit.html.HtmlButtonInput;
import com.gargoylesoftware.htmlunit.html.HtmlForm;
import com.gargoylesoftware.htmlunit.html.HtmlHiddenInput;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlPasswordInput;
import com.gargoylesoftware.htmlunit.html.HtmlSubmitInput;
import com.gargoylesoftware.htmlunit.html.HtmlTextInput;
import com.router.model.RouterInfo;

public class RouterService {
	private WebClient webClient;
	
	public RouterService() {
		// TODO Auto-generated constructor stub
		webClient = new WebClient(BrowserVersion.EDGE);
		initWebClient();
	}
	
	private void initWebClient(){
		WebClientOptions webClientOptions = webClient.getOptions();
		webClientOptions.setJavaScriptEnabled(true);
		webClientOptions.setUseInsecureSSL(true);
		webClientOptions.setThrowExceptionOnScriptError(false);
		webClientOptions.setThrowExceptionOnFailingStatusCode(false);
	}
	
	public void login(RouterInfo loginInfo){
		String url = loginInfo.getUrl();
		String userName = loginInfo.getUserName();
		String password = loginInfo.getPassword();
		
		try {
			HtmlPage loginPage = webClient.getPage(url);
			//System.out.println(loginPage.asText());
			HtmlForm loginForm = loginPage.getFormByName("test");
			//HtmlTextInput userNameInputField = loginForm.getInputByName("username");
			//userNameInputField.setValueAttribute(userName);
			
			//HtmlPasswordInput passwordInputField = loginForm.getInputByName("password");
			//passwordInputField.setValueAttribute(password);
			
			HtmlHiddenInput loginButton = loginForm.getInputByValue("Send");
			
			Page appPage = loginButton.click();
			String content = appPage.getWebResponse().getContentAsString();
			System.out.println(content);
		} catch (FailingHttpStatusCodeException e) {
			e.printStackTrace();
		} catch(IOException e){
			e.printStackTrace();
		}
	}
}
