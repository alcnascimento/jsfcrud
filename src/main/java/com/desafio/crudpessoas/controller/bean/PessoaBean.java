package com.desafio.crudpessoas.controller.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.PrimeFaces;
import org.primefaces.event.RowEditEvent;

import com.desafio.crudpessoas.dao.PessoaDAO;
import com.desafio.crudpessoas.domain.Pessoa;

@ManagedBean(name = "pessoaBean")
@SessionScoped
public class PessoaBean implements Serializable {
	private boolean showTable = false;
	private List<Pessoa> usersList;
	private List<Pessoa> searchList;
	private List<Pessoa> searchByRecordNoList;
	PessoaDAO userDao = new PessoaDAO();
	Pessoa user = new Pessoa();
	Pessoa newuser = new Pessoa();

	public List<Pessoa> getUsers() {

		usersList = userDao.getPessoas();

		showTable = usersList.size() > 0;

		return usersList;
	}

	public String addUser() {

		try {
			userDao.addPessoa(newuser);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("User successfully saved.");
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação",
				"Pessoa Salva com Sucesso.");
		PrimeFaces.current().dialog().showMessageDynamic(message);
		newuser = new Pessoa();

		return "index";
	}

	public void changeUser(Pessoa user) {
		this.user = user;
	}

	public void UpdateUser(Pessoa user) {
		userDao.updatePessoa(user);
		System.out.println("User Info successfully saved.");
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação",
				"Pessoa Atualizada com Sucesso .");
		PrimeFaces.current().dialog().showMessageDynamic(message);
		user = new Pessoa();
	}

	public void deleteUser(Pessoa user) {
		userDao.deletePessoa(user);
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Informação", "Pessoa Excluida com Sucesso");
		PrimeFaces.current().dialog().showMessageDynamic(message);
	}

	public void onRowEdit(RowEditEvent event) {
		Pessoa editeduser = (Pessoa) event.getObject();

		FacesMessage message = new FacesMessage(" Editando Registro Id: ", editeduser.getId().toString());
		FacesContext.getCurrentInstance().addMessage(null, message);

		userDao.updatePessoa(editeduser);
	}

	public void onCancel(RowEditEvent event) {
		FacesMessage message = new FacesMessage("Edição Cancelada");
		FacesContext.getCurrentInstance().addMessage(null, message);
		usersList.remove((Pessoa) event.getObject());
	}

	public Pessoa getUser() {
		return user;
	}

	public void setUser(Pessoa user) {
		this.user = user;
	}

	public Pessoa getNewuser() {
		return newuser;
	}

	public void setNewuser(Pessoa newuser) {
		this.newuser = newuser;
	}

	public List<Pessoa> getUsersList() {
		return usersList;
	}

	public void setUsersList(List<Pessoa> usersList) {
		this.usersList = usersList;
	}

	public List<Pessoa> getSearchList() {
		return searchList;
	}

	public void setSearchList(List<Pessoa> searchList) {
		this.searchList = searchList;
	}

	public List<Pessoa> getSearchByRecordNoList() {
		return searchByRecordNoList;
	}

	public void setSearchByRecordNoList(List<Pessoa> searchByRecordNoList) {
		this.searchByRecordNoList = searchByRecordNoList;
	}

	public boolean isShowTable() {
		return showTable;
	}

	public void setShowTable(boolean showTable) {
		this.showTable = showTable;
	}
}