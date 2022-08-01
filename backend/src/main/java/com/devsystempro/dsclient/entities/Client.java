package com.devsystempro.dsclient.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;

public class Client implements Serializable{
	private static final long serialVersionUID = 1L;
	
    private Long id;
    private String name;
    private String cpf;
    private Double income;
    private Integer children;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant birthDate;
    
	public Client() {}

	public Client(Long id, String name, String cpf, Double income,Instant birthDate,Integer children ) {
	
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.income = income;
		this.children = children;
		this.birthDate = birthDate;
	}

	
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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double getIncome() {
		return income;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public Integer getChildren() {
		return children;
	}

	public void setChildren(Integer children) {
		this.children = children;
	}

	public Instant getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Instant birthDate) {
		this.birthDate = birthDate;
	}

	
	//HashCode e Equals abaixo e usado para fazer a comparaçãode um objeto com outro
	@Override
	public int hashCode() {//comparação rapida 
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {//comparação mais demorada
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;//faz a comparação de Id para cada objeto criado.
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	
	

}
