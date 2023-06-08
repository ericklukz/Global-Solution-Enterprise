package br.com.fiap.globalSolution.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import br.com.fiap.globalSolution.models.Hortalica;
import br.com.fiap.globalSolution.models.Telefone;
import br.com.fiap.globalSolution.models.Terreno;
import br.com.fiap.globalSolution.models.TipoHortalica;
import br.com.fiap.globalSolution.models.Usuario;
import br.com.fiap.globalSolution.repository.HortalicaRepository;
import br.com.fiap.globalSolution.repository.TelefoneRepository;
import br.com.fiap.globalSolution.repository.TerrenoRepository;
import br.com.fiap.globalSolution.repository.TipoHortalicaRepository;
import br.com.fiap.globalSolution.repository.UsuarioRepository;

import java.util.List;

@Configuration
public class DataBaseSeeder implements CommandLineRunner {

    @Autowired
    UsuarioRepository userRepository; 

    @Autowired
    TelefoneRepository telefoneRepository; 

    @Autowired
    TerrenoRepository terrenoRepository;

    @Autowired
    HortalicaRepository hortalicaRepository; 

    @Autowired
    TipoHortalicaRepository tipoHortalicaRepository; 

    @Override
    public void run(String... args) throws Exception{
        Usuario usuario1 = new Usuario(1,"Maria","carlitos", "alo@");
        Usuario usuario2 = new Usuario(2,"Hugo","huginho", "ola@");
        Usuario usuario3 = new Usuario(3,"Carlos","marimari", "hello@");
        userRepository.saveAll(List.of(usuario1,usuario2,usuario3));
        
        Telefone telefone1 = new Telefone(1, "123456789", "011", "11111", usuario1);
        Telefone telefone2 = new Telefone(2, "563456780", "015", "22222", usuario2);
        Telefone telefone3 = new Telefone(3, "323456782", "014", "33333", usuario3);
        telefoneRepository.saveAll(List.of(telefone1, telefone2, telefone3));
        
        TipoHortalica tipo1 = new TipoHortalica(1, 'a', "alou");
        TipoHortalica tipo2 = new TipoHortalica(2, 'b', "alou");
        TipoHortalica tipo3 = new TipoHortalica(3, 'c', "alou");
        tipoHortalicaRepository.saveAll(List.of(tipo1,tipo2,tipo3));
                
        Hortalica horta1 = new Hortalica(1, "cenoura", "fevereiro", "agosto", tipo3);
        Hortalica horta2 = new Hortalica(2, "repolho", "maio", "setembro", tipo1);
        Hortalica horta3 = new Hortalica(3, "tomate", "julho", "outubro", tipo2);
        hortalicaRepository.saveAll(List.of(horta1, horta2, horta3));

        Terreno terreno1 = new Terreno(1, "125m", "grande da roça", "Rua n/a", "1225", "ZS", usuario1, horta1);
        Terreno terreno2 = new Terreno(2, "145m", "pequeno da roça", "rua b", "1125", "ZN", usuario2, horta2);
        Terreno terreno3 = new Terreno(3, "135m", "médio da roça", "rua 9", "1112", "ZL", usuario3, horta3);
        terrenoRepository.saveAll(List.of(terreno1,terreno2,terreno3));
        
    }
}
