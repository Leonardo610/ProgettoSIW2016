package it.clinic.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.EJBTransactionRolledbackException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import it.clinic.facade.AdministratorFacade;
import it.clinic.model.ExamTypology;
import it.clinic.model.Indicator;


@ManagedBean
public class ExamTypologyController {
	
	@ManagedProperty(value="#{param.id}")
	private Long id;
	private String name;
	private String detail;
	private ExamTypology examTypology;
	private List<ExamTypology> examTypologies;
	@ManagedProperty(value="#{param.idindicator}") // ???
	private Long idindicator; // ???
	private Indicator indicator; // ???
	private Set<Indicator> indicators; // ???
	
	@EJB(beanName = "aFacade")
	private AdministratorFacade administratorFacade;
	
	@PostConstruct
	public void examTypologiesList(){
		this.examTypologies = administratorFacade.getAllExamTypologies();
		this.indicators= new HashSet<Indicator>();
	}
	
	public String createExamTypology(){
		String nextPage = "./successNewTipologiaEsame.jsp";
		try{
			this.examTypology = administratorFacade.createExamTypology(name, detail,indicators);
		} catch (EJBTransactionRolledbackException e){ //Nel DBMS è già presente una tipolgia con lo stesso nome
			nextPage = "./errorNewTipologiaEsame.jsp";
			this.examTypology= new ExamTypology(name, detail,indicators); 
		}
		return nextPage;
	}
	
     public String findExamTypology(){
		this.examTypology = administratorFacade.getExamTypology(id);
		return "dettaglioTipologiaEsame.jsp"; //non c'è bisogno di /faces è già in contesto jsf
     }
	
	public String findExamTypology(Long id) {
		this.examTypology = administratorFacade.getExamTypology(id);
		return "dettaglioTipologiaEsame.jsp";   //non c'è bisogno di /faces è già in contesto jsf
	}
	
	public String listExamTypologies(){
		this.examTypologies = administratorFacade.getAllExamTypologies();
		return "/faces/tipologieEsami.jsp";
	}
	
	public String addIndicator(){
		Indicator typologyIndicator = administratorFacade.getIndicator(idindicator);
		this.indicators.add(typologyIndicator);
		return "newTipologiaEsame.jsp";
	}
	
	//metodi getters e setters
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public String getDetail() {
		return detail;
	}
	
	public void setDetail(String detail) {
		this.detail = detail;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public ExamTypology getExamTypology() {
		return examTypology;
	}
	
	public void setExamTypolgy(ExamTypology examTypology) {
		this.examTypology = examTypology;
	}
	
	public List<ExamTypology> getExamTypologies() {
		return examTypologies;
	}
	
	public void setExamTypologies(List<ExamTypology> examTypologies) {
		this.examTypologies = examTypologies;
	}
	
	public Long getIdindicator() {
		return idindicator;
	}
	public Indicator getIndicator() {
		return indicator;
	}
	public Set<Indicator> getIndicators() {
		return indicators;
	}
	
	public void setIdindicator(Long idindicator) {
		this.idindicator = idindicator;
	}
	
	public void setIndicator(Indicator indicator) {
		this.indicator = indicator;
	}
	
	public void setIndicators(Set<Indicator> indicators) {
		this.indicators = indicators;
	}
	
}
