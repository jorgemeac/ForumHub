package br.com.forumhub.api.controller;

import br.com.forumhub.api.usuario.DadosAutenticacao;
import br.com.forumhub.api.usuario.DadosUsuario;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public ResponseEntity efetuarLogin(@RequestBody @Valid DadosUsuario dadosUsuario) {
       var token = new UsernamePasswordAuthenticationToken(dadosUsuario.email(), dadosUsuario.senhaHash());
       var authentication = authenticationManager.authenticate(token);

       return ResponseEntity.ok().build();
    }
}
