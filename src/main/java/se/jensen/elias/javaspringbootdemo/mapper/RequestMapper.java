package se.jensen.elias.javaspringbootdemo.mapper;

public interface RequestMapper<E, RQ> {

    E toEntity(RQ dto);
}
