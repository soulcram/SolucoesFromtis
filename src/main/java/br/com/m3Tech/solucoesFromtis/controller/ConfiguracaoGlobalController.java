package br.com.m3Tech.solucoesFromtis.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.context.annotation.SessionScope;

import br.com.m3Tech.solucoesFromtis.model.ConfGlobal;
import br.com.m3Tech.solucoesFromtis.service.IConfGlobalService;
import br.com.m3Tech.utils.StringUtils;
import lombok.Getter;
import lombok.Setter;

@SessionScope
@Getter
@Setter
@Controller
public class ConfiguracaoGlobalController implements Serializable {

	private static final long serialVersionUID = 1L;

	private static final String VOLTAR = "/pages/cadastros/home.xhtml";


	@Autowired
	private IConfGlobalService configuracaoGlobalService;
	
	
	private ConfGlobal configuracaoGlobal;
	
	private String temaSelecionado = "cupertino";
    private List<String> temasDisponiveis = new ArrayList<String>();

	
	@PostConstruct
	public void init() {

		this.configuracaoGlobal = configuracaoGlobalService.getConfGlobal();
		
		 //Populando os temas
        temasDisponiveis.add("afterdark");
        temasDisponiveis.add("afternoon");
        temasDisponiveis.add("afterwork");
        temasDisponiveis.add("aristo");
        temasDisponiveis.add("black-tie");
        temasDisponiveis.add("blitzer");
        temasDisponiveis.add("bluesky");
        temasDisponiveis.add("bootstrap");
        temasDisponiveis.add("casablanca");
        temasDisponiveis.add("cruze");
        temasDisponiveis.add("cupertino");
        temasDisponiveis.add("dark-hive");
        temasDisponiveis.add("delta");
        temasDisponiveis.add("dot-luv");
        temasDisponiveis.add("eggplant");
        temasDisponiveis.add("excite-bike");
        temasDisponiveis.add("flick");
        temasDisponiveis.add("glass-x");
        temasDisponiveis.add("home");
        temasDisponiveis.add("hot-sneaks");
        temasDisponiveis.add("humanity");
        temasDisponiveis.add("le-frog");
        temasDisponiveis.add("midnight");
        temasDisponiveis.add("mint-choc");
        temasDisponiveis.add("overcast");
        temasDisponiveis.add("pepper-grinder");
        temasDisponiveis.add("redmond");
        temasDisponiveis.add("rocket");
        temasDisponiveis.add("sam");
        temasDisponiveis.add("smoothness");
        temasDisponiveis.add("south-street");
        temasDisponiveis.add("start");
        temasDisponiveis.add("sunny");
        temasDisponiveis.add("swanky-purse");
        temasDisponiveis.add("trontastic");
        temasDisponiveis.add("ui-darkness");
        temasDisponiveis.add("ui-lightness");
        temasDisponiveis.add("vader");
				
	}
	
	public String salvar() {
				
		try {			
			configuracaoGlobalService.salvar(this.configuracaoGlobal);
		} catch (Exception e) {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "", e.getMessage()));
			e.printStackTrace();
		}
		
		
		return VOLTAR;
	}
	

	

	public String voltar() {
		return VOLTAR;
	}

}
