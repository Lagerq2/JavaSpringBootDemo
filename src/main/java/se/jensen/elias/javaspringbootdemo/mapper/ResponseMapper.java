package se.jensen.elias.javaspringbootdemo.mapper;

public interface ResponseMapper<E, D> {

    D toResponseDTO(E entity);


}
