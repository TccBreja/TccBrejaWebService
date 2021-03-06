package br.com.youbeer.webserverapp.apresentacao;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import br.com.youbeer.webserverapp.modelo.Cerveja;
import br.com.youbeer.webserverapp.modelo.Estabelecimento;
import br.com.youbeer.webserverapp.service.IYoubeerService;
import br.com.youbeer.webserverapp.service.YoubeerServiceImpl;

public class CadastrarCervejasAction extends ActionBase{

	@Override
	protected ActionForward executar(ActionMapping mapping, ActionForm form, HttpServletRequest request, HttpServletResponse response) {
	
		// Inst�ncia do service
		IYoubeerService service = new YoubeerServiceImpl();
		
		// Obt�m o estabelecimento escolhido
		int codigoEstabelecimento = Integer.parseInt(request.getParameter("codigoEstabelecimento"));
		Estabelecimento estabelecimento = service.buscarPorCodigo(codigoEstabelecimento);
			
		// Obt�m a lista de cervejas cadastradas no banco
		List<Cerveja> cervejas = service.listarCervejas();
		
		/*
		//Mock do recebimento da lista de cervejas
		List<Cerveja> cervejas = new ArrayList<Cerveja>();
		Cerveja cerveja1 = new Cerveja();
		cerveja1.setCodigoCerveja(101010);
		cerveja1.setNomeCerveja("Skoll");
		cerveja1.setTipo("Garrafa - 600ml");
		
		Cerveja cerveja2 = new Cerveja();
		cerveja2.setCodigoCerveja(111002);
		cerveja2.setNomeCerveja("Brahma");
		cerveja2.setTipo("Garrafa - 600ml");
		
		cervejas.add(cerveja1);
		cervejas.add(cerveja2);
		cervejas.add(cerveja2);
		cervejas.add(cerveja2);
		*/
		
		// Seta atributos de request
		request.setAttribute("nomeEstabelecimento", estabelecimento.getNomeEstabelecimento());
		request.setAttribute("listaCervejasEstabelecimento", estabelecimento.getListaCervejas());
		request.setAttribute("listaCervejasBanco", cervejas);
		request.setAttribute("appendListaCervejas", criaAppendLista(estabelecimento.getListaCervejas()));
		
		// Retorna sucesso
		return mapping.findForward("sucesso");
	}

	/**
	 * Retorna o append din�mico com as cervejas retornadas do banco de dados
	 * @param List cervejas Objeto <tt>Cerveja</tt>.
	 */
	public String criaAppendLista(List<Cerveja> cervejas){
		
		String appendLista = "";
		appendLista += "<tr><td align='center'><a class='btn btn-danger deletavel'><em class='fa fa-trash'>"
				+ "</em></a></td><td class='hidden-xs'><select id='listaCervejasSelect' name='listaCervejasSelect' class='form-control'>"
				+ "<logic:iterate id='listaCervejas' name='listaCervejasBanco'>";
		
		for(Cerveja cerveja : cervejas){
			appendLista += "<option value='" + cerveja.getCodigoCerveja() + "'>";
			appendLista += cerveja.getNomeCerveja() + " - " + cerveja.getTipo() + ": " + cerveja.getVolumeLiquido() + "mL";
			appendLista += "</option>";
		}
		
		appendLista += "</logic:iterate></select></td><td><div class='input-group'><div class='input-group-addon'>$</div>"
				+ "<input type='text' name='valorCerveja' class='form-control dinheiro'></div></td></tr>";
		return appendLista;
		
	}
}
