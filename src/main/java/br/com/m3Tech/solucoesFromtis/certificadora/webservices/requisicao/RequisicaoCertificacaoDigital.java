
package br.com.m3Tech.solucoesFromtis.certificadora.webservices.requisicao;

import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.Action;
import javax.xml.ws.RequestWrapper;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.4-b01
 * Generated source version: 2.2
 * 
 */
@WebService(name = "RequisicaoCertificacaoDigital", targetNamespace = "http://webservices.portal.fidc.fromtis.com.br/")
@XmlSeeAlso({
    ObjectFactory.class
})
public interface RequisicaoCertificacaoDigital {

    /**
     * 
     * @param requisicao
     */
    @WebMethod
    @Oneway
    @RequestWrapper(localName = "requisicao", targetNamespace = "http://webservices.portal.fidc.fromtis.com.br/", className = "br.com.fromtis.fidc.portal.webservices.requisicao.Requisicao")
    @Action(input = "http://webservices.portal.fidc.fromtis.com.br/RequisicaoCertificacaoDigital/requisicao")
    public void requisicao (@WebParam(name = "requisicaoCertificado", targetNamespace = "") RequisicaoCertificadoDigital retornoAquisicao);

}
