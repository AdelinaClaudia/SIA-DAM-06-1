package org.app.service.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Angajat{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@NotNull
	private Integer marcaAngajat;
	private String numePrenumeAngajat;
	private Integer cnpAngajat;
	
	@Temporal(TemporalType.DATE)
	
	private Date dataAngajare;
	private String bancaAngajat;
	private String ibanAngajat;
	
	@OneToMany(mappedBy="angajat", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Contract> contract = new ArrayList<Contract>();
	
	//--get set
	public Integer getMarcaAngajat() {
		return marcaAngajat;
	}
	//metoda1
	public void adaugacontract(Contract c) {
		if(!this.contract.contains(c))
		this.contract.add(c);
	}
	public void setMarcaAngajat(Integer marcaAngajat) {
		this.marcaAngajat = marcaAngajat;
	}
	
	public String getNumePrenumeAngajat() {
		return numePrenumeAngajat;
	}
	public void setNumePrenumeAngajat(String numePrenumeAngajat) {
		this.numePrenumeAngajat = numePrenumeAngajat;
	}

	public Integer getCnpAngajat() {
		return cnpAngajat;
	}
	public void setCnpAngajat(Integer cnpAngajat) {
		this.cnpAngajat = cnpAngajat;
	}
	
	public Date getDataAngajare() {
		return dataAngajare;
	}
	public void setDataAngajare(Date dataAngajare) {
		this.dataAngajare = dataAngajare;
	}
	
	public String getBancaAngajat() {
		return bancaAngajat;
	}
	public void setBancaAngajat(String bancaAngajat) {
		this.bancaAngajat = bancaAngajat;
	}

	public String getIbanAngajat() {
		return ibanAngajat;
	}
	public void setIbanAngajat(String ibanAngajat) {
		this.ibanAngajat = ibanAngajat;
	}
	public List<Contract> getContract() {
		return contract;
	}

	public void setContract(List<Contract> contracte) {
		this.contract.addAll(contracte);
	}
	
	public void setContract(Contract contract) {
		this.contract.add(contract);
	}

	
	public Angajat(Integer marcaAngajat, String numePrenumeAngajat, Integer cnpAngajat, Date dataAngajare,
			String bancaAngajat, String ibanAngajat) {
		super();
		this.marcaAngajat = marcaAngajat;
		this.numePrenumeAngajat = numePrenumeAngajat;
		this.cnpAngajat = cnpAngajat;
		this.dataAngajare = dataAngajare;
		this.bancaAngajat = bancaAngajat;
		this.ibanAngajat = ibanAngajat;
	}
	public Angajat() {
		super();
	}
	public Angajat(List<Contract> contract) {
		super();
		this.contract = contract;
	}
	public Angajat(Integer marcaAngajat, String numePrenumeAngajat) {
		super();
		this.marcaAngajat = marcaAngajat;
		this.numePrenumeAngajat = numePrenumeAngajat;
	}
	
		

	
	
}

