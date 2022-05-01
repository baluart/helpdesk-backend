package com.lucas.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.helpdesk.domain.Chamado;
import com.lucas.helpdesk.domain.Cliente;
import com.lucas.helpdesk.domain.Tecnico;
import com.lucas.helpdesk.domain.enums.Perfil;
import com.lucas.helpdesk.domain.enums.Prioridade;
import com.lucas.helpdesk.domain.enums.Status;
import com.lucas.helpdesk.repositories.ChamadoRepository;
import com.lucas.helpdesk.repositories.ClienteRepository;
import com.lucas.helpdesk.repositories.TecnicoRepository;

@Service
public class DBService {
	
	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;
	
	public void instaciaDB() {
	
		Tecnico tec1 = new Tecnico(null,"Lucas Nunes","01915254213","lucasbaluart@gmail.com","123");
		tec1.addPerfil(Perfil.ADMIN);
		
		Cliente cd_cli1 = new Cliente(null,"Ester Lima","04994011230","ester.lima.ferrera@gmail.com","123");
		
		Chamado chm1 = new Chamado(null, Prioridade.MEDIA,Status.ANDAMENTO,"Chamado 01","primeiro chamado",tec1,cd_cli1);
		
		
		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cd_cli1));
		chamadoRepository.saveAll(Arrays.asList(chm1));
	}
	

}
