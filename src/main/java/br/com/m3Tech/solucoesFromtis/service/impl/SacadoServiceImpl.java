package br.com.m3Tech.solucoesFromtis.service.impl;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import br.com.m3Tech.solucoesFromtis.dto.SacadoDto;
import br.com.m3Tech.solucoesFromtis.querys.Querys;
import br.com.m3Tech.solucoesFromtis.service.ISacadoService;


@Service
public class SacadoServiceImpl implements ISacadoService, Serializable{

	private static final long serialVersionUID = 1L;

	public List<SacadoDto> findAll(Connection con, Integer idFundo) {
		
		List<SacadoDto> sacados = new ArrayList<SacadoDto>();
		
		try {
			PreparedStatement ps = con.prepareStatement(Querys.ALL_SACADOS);
			
			ps.setInt(1, idFundo);
			
			ps.execute();
			
			ResultSet rs = ps.getResultSet();
			
			while(rs.next()) {
				SacadoDto sacado = new SacadoDto(rs.getInt("ID_SACADO"), 
											  rs.getString("NM_SACADO"), 
											  rs.getString("NU_CPF_CNPJ"),
											  rs.getString("DS_LOGRADOURO"),
											  rs.getString("NU_CEP"));
				
				sacados.add(sacado);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sacados;
	}

	public SacadoDto findOneById(Connection con, Integer idSacado) {
		SacadoDto sacado = null;
		
		try {
			PreparedStatement ps = con.prepareStatement(Querys.ONE_SACADO);
			
			ps.setInt(1, idSacado);
			
			ps.execute();
			
			ResultSet rs = ps.getResultSet();
			
			if(rs.next()) {
				sacado = new SacadoDto(rs.getInt("ID_SACADO"), 
											  rs.getString("NM_SACADO"), 
											  rs.getString("NU_CPF_CNPJ"),
											  rs.getString("DS_LOGRADOURO"),
											  rs.getString("NU_CEP"));
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return sacado;
	}

	@Override
	public SacadoDto getPrimeiroSacado(Connection con, Integer idFundo) throws SQLException {
		SacadoDto sacado = null;

		String sqlQuery = "select TOP 1 ID_SACADO, NM_SACADO, NU_CPF_CNPJ,DS_LOGRADOURO,NU_CEP from TB_FUNDO_SACADO where ID_FUNDO = " + idFundo;

		PreparedStatement ps = con.prepareStatement(sqlQuery);

		ps.execute();

		ResultSet rs = ps.getResultSet();

		if (rs.next()) {
			sacado = new SacadoDto(rs.getInt("ID_SACADO"), rs.getString("NM_SACADO"), rs.getString("NU_CPF_CNPJ"),
					rs.getString("DS_LOGRADOURO"), rs.getString("NU_CEP"));

		}

		return sacado;
	}
	


}
