package upeu.edu.libro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import upeu.edu.libro.entity.Autor;
import upeu.edu.libro.entity.Editorial;
import upeu.edu.libro.entity.Libro;
import upeu.edu.libro.repository.AutorRepository;
import upeu.edu.libro.repository.EditorialRepository;
import upeu.edu.libro.repository.LibroRepository;
import upeu.edu.libro.dto.LibroRequest;

import java.util.List;
@Controller
public class LibroGraphQl {

    @Autowired
    private LibroRepository libroRepository;
    @Autowired
    private AutorRepository autorRepository;
    @Autowired
    private EditorialRepository editorialRepository;
    @QueryMapping
    public List<Autor> listarAutor() {return autorRepository.findAll();}
    @QueryMapping
    public Autor listarAutorporId(@Argument int id)  {
        return autorRepository.findById(id).orElse(null);
    }
    @QueryMapping
    public List<Editorial> listarEditorial() {return editorialRepository.findAll();}
    @QueryMapping
    public Editorial listarEditorialId(@Argument int id)  {
        return editorialRepository.findById(id).orElse(null);
    }
    @QueryMapping
    public List<Libro> listarLibro() {return libroRepository.findAll();}
    @QueryMapping
    public Libro listarLibroId(@Argument int id)  {
        return libroRepository.findById(id).orElse(null);
    }

    @MutationMapping
    public Libro guardarLibro(@Argument LibroRequest libroRequest) {
        Autor autor = autorRepository.findById(libroRequest.autor()).orElse(null);
        Editorial editorial = editorialRepository.findById(libroRequest.editorial()).orElse(null);
        Libro libroBBDD = new Libro();

        libroBBDD.setTitulo(libroRequest.titulo());
        libroBBDD.setDescripcion(libroRequest.descripcion());
        libroBBDD.setPaginas(libroRequest.paginas());
        libroBBDD.setEdicion(libroRequest.edicion());
        libroBBDD.setAutor(autor);
        libroBBDD.setEditorial(editorial);

        return libroRepository.save(libroBBDD);
    }

    @MutationMapping
    public Libro actualizarLibro(@Argument int id ,@Argument LibroRequest libroRequest) {
        Autor autor = autorRepository.findById(libroRequest.autor()).orElse(null);
        Editorial editorial = editorialRepository.findById(libroRequest.editorial()).orElse(null);
        Libro libroBBDD = new Libro();
        libroBBDD.setIdl(id);
        libroBBDD.setTitulo(libroRequest.titulo());
        libroBBDD.setDescripcion(libroRequest.descripcion());
        libroBBDD.setPaginas(libroRequest.paginas());
        libroBBDD.setEdicion(libroRequest.edicion());
        libroBBDD.setAutor(autor);
        libroBBDD.setEditorial(editorial);
        return libroRepository.save(libroBBDD);
    }



    @MutationMapping
    public void eliminarLibro(@Argument int id) {
        libroRepository.deleteById(id);
    }







}
