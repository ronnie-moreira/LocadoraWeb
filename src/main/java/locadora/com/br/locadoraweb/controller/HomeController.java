package locadora.com.br.locadoraweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/*
* Abre a pagina inicial da locadora do ronnie
* Abertura e o nome da pagina HTML
* */
@Controller //Inf. ao string que a classe recebe acesso ao nav.
public class HomeController { //Declara o controller da pagina inicial
   @GetMapping("/") // Liga o End. principal ao método abaixo
   public String abrirPaginaInicial() {
       return "index";

   }
}

/*
 3 - Coloca a classe pacote no controller
 4 - Coloca a anotação que identifica o Controller
 4 - Ele importa a anotação para as rotas do Get

 */