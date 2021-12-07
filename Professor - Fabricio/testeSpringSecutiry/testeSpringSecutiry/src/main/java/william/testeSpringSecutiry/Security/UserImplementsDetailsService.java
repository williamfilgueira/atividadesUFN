package william.testeSpringSecutiry.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import william.testeSpringSecutiry.Usuario;
import william.testeSpringSecutiry.Repository.UsuarioRepository;

@Repository
public class UserImplementsDetailsService implements UserDetailsService {
	@Autowired
	UsuarioRepository usuarioRepository;
	

	@Override
	public UserDetails loadUserByUsername(String nome) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findByNome(nome);
		
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuário não encontrado");
		}
		return usuario;
	}

}
