package br.ufscar.systemExampleMVC_OrdenacaoNumeros;

import br.ufscar.systemExampleMVC_OrdenacaoNumeros.controller.ControllerPrincipal;
import br.ufscar.systemExampleMVC_OrdenacaoNumeros.view.FramePrincipal;

/**
 *
 * @author Gustavo Ferreira
 */
public class MVC {

    public static void main(String[] args) {

        FramePrincipal framePrincipal = new FramePrincipal();
        new ControllerPrincipal(framePrincipal);
        framePrincipal.setVisible(true);

    }
}
