package br.ufscar.systemExampleMVC_OrdenacaoNumeros.model.dao;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

import br.ufscar.systemExampleMVC_OrdenacaoNumeros.model.vo.Ordenacao;

/**
 *
 * @author Gustavo Ferreira
 * @see Classe que executa as operacoes de IO (entrada e saida) do sistema com relacao
 * aos dados resultantes da ordenacao
 */
public class OrdenacaoDAO {
    
    /**
     * Metodo que salva em um arquivo de texto os dados do objeto de ordenacao
     * @param Ordenacao ordenacao
     * @throws FileNotFoundException 
     */
    public void salvar(Ordenacao ordenacao) throws FileNotFoundException{
        PrintWriter pw = new PrintWriter("ordenacao.txt");
        pw.print(ordenacao);
        pw.flush();
        pw.close();
    }
}
