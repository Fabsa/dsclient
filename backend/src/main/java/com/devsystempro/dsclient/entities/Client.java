package com.devsystempro.dsclient.entities;

import java.io.Serializable;
import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

@Entity
@Table(name="tb_client")
public class Client implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String cpf;
    private Double income;
    private Integer children;
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant birthDate;
   
    //usado para mostrar o instante que um registro foi criado pela primeira vez e um exemplo
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")//padrão UTC
    private Instant createdAt; //usado para mostrar o instante que um registro foi criado pela primeira vez e um exemplo
    
    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")//padrão UTC
    private Instant updatedAt; //usado para mostrar o instante que um registro foi atualizada pela primeira vez e um exemplo
    
    
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
//////////////////////////////////////////////////////////////////////
	//usaremos paenas os metodos Get para fins de criação e atualização dos objetos existentes no banco
	
	public Instant getCreatedAt() {
		return createdAt;
	}

	/*public void setCreatedAt(Instant createdAt) {
		this.createdAt = createdAt;
	}*/

	public Instant getUpdatedAt() {
		return updatedAt;
	}

	/*public void setUpdatedAt(Instant updatedAt) {
		this.updatedAt = updatedAt;
	}*/
/////////////////////////////////////////////////////////////////////////////
	
	//metodo Auxiliar
	@PrePersist
	public void prePersist() 
	{
		createdAt = Instant.now();
	}
	@PreUpdate
	public void preUpdate() 
	{
		updatedAt = Instant.now();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	//HashCode e Equals abaixo e usado para fazer a comparação de um objeto com outro
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
