package com.ssau.lab4.repository;

import com.ssau.lab4.models.BaseModel;
import lombok.NonNull;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

@NoRepositoryBean
public interface BaseRepository<T extends BaseModel, ID> extends JpaRepository<T, ID> {

    List<T> findAllByIsDeletedFalse();

    List<T> findAllByIsDeletedTrue();

    T findOneByUniqueIdAndIsDeletedFalse(Long id);

    T findOneByUniqueId(Long id);

    T findOneByUuidAndIsDeletedFalse(UUID uuid);

    T findOneByUuid(UUID uuid);

    @Override
    @Modifying
    @Query(value = "update #{#entityName} f set f.isDeleted=true where f.uniqueId= :id")
    void deleteById(@NonNull ID id);

    @Override
    @Modifying
    @Query(value = "update #{#entityName} f set f.isDeleted=true where f= :entity")
    void delete(@NonNull @Param("entity") T entity);

    @Override
    @Modifying
    @Query(value = "update #{#entityName} f set f.isDeleted=true where f in :entities")
    void deleteAll(@NonNull Iterable<? extends T> entities);
}