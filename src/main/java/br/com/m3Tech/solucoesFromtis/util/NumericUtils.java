package br.com.m3Tech.solucoesFromtis.util;

import java.math.BigDecimal;

public class NumericUtils {
	
	private NumericUtils() {}
	
	public static boolean isNull(BigDecimal valor) {
		return valor == null;
	}
	
	public static Integer getOnlyNumericsOfString(String valor) {
		return Integer.valueOf(valor.replaceAll("[^0-9]", ""));
	}
	
	
	public static BigDecimal getValorMenos10PorCento(BigDecimal valor) {
		
		BigDecimal dezPorCento = valor.multiply(BigDecimal.TEN).divide(new BigDecimal("100"));
		
		BigDecimal retorno = valor.subtract(dezPorCento);
		
		retorno = retorno.setScale(2, BigDecimal.ROUND_HALF_EVEN);
		
		return retorno;
	}

}
