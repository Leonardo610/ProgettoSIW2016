package it.clinic.controller;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import it.clinic.facade.AdministratorFacade;
import it.clinic.model.Indicator;



@ManagedBean
public class IndicatorController {

	@ManagedProperty(value="#{param.id}")
	private Long id;
	@ManagedProperty(value="#{param.idExam}")
	private Long idExam;
	private String name;

	private Long idIndicator;
	private Indicator indicator;
	private List<Indicator> indicators;



	@EJB
	private AdministratorFacade administratorFacade;

	// questo metodo viene invocato appena si chiama l'indicatore Controller. In questo modo, carico direttamente tutti gli indicatori dal 
	// database per interrogarli
	@PostConstruct
	public void indicatorsList(){
		this.indicators = administratorFacade.getAllIndicators();
	}
	
	
	public String createIndicator(){
		String nextPage = "successNewIndicator";
		try{
			this.indicator = administratorFacade.createIndicator(name);
		} catch (EJBTransactionRolledbackException e){
			nextPage = "errorNewIndicator";
			this.indicator = new Indicator(name);
		}
		return nextPage;
	}
	
	//metodi setters e getters
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Indicator getIndicator() {
		return indicator;
	}
	
	public void setIndicator(Indicator indicator) {
		this.indicator = indicator;
	}
	
	public List<Indicator> getIndicators() {
		return indicators;
	}
	
	public void setIndicators(List<Indicator> indicators) {
		this.indicators = indicators;
	}
	public Long getIdIndicator() {
		return idIndicator;
	}
	
	
	public void setIdIndicator(Long idIndicator) {
		this.idIndicator = idIndicator;
	}
	public Long getIdExam() {
		return idExam;
	}
	
	
	public void setIdExam(Long idExam) {
		this.idExam = idExam;
	}
}
