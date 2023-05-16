package upeu.edu.libro.dto;

public record LibroRequest (

        Integer idl,
        String titulo,
        String descripcion,
        Integer paginas,
        String edicion,
        Integer autor,
        Integer editorial

){
}
