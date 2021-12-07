package william.testeSpringSecutiry.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import william.testeSpringSecutiry.Usuario;
import william.testeSpringSecutiry.Repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	
	@Autowired
	UsuarioRepository usuarioRepository;
	
	BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
	
	@GetMapping
	public List<Usuario> getAll() {
		return usuarioRepository.findAll(); 
	}
	
	@PostMapping
	public Usuario createUsuario(@RequestBody Usuario usuario) {
		usuario.setSenha(encoder.encode(usuario.getPassword()));
		return usuarioRepository.save(usuario); 
	}
}
