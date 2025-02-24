package com.academia.academia.service;

import com.academia.academia.config.CriptografiaSenha;
import com.academia.academia.model.DadosUsuarioCadastro;
import com.academia.academia.model.Usuario;
import com.academia.academia.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UsuarioService implements UserDetailsService {

    private final UsuarioRepository usuarioRepository;

    private final ModelMapper modelMapper;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        return usuarioRepository.findByLogin(login);
    }

    public DadosUsuarioCadastro criarUsuario(DadosUsuarioCadastro dto){
        Usuario usuario = modelMapper.map(dto, Usuario.class);

        //Criptografando senha
        String senhaCriptografada = CriptografiaSenha.criptografia(usuario.getPassword());
        usuario.setPassword(senhaCriptografada);

        usuarioRepository.save(usuario);
        return modelMapper.map(usuario, DadosUsuarioCadastro.class);
    }
}
