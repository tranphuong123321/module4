package com.example.repository.impl;

import com.example.model.Song;
import com.example.repository.ISongRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class SongRepository implements ISongRepository {
    @Override
    public List<Song> findAll() {
        TypedQuery<Song> typedQuery = BaseRepository.entityManager.createQuery("select s from Song s", Song.class);

        return typedQuery.getResultList();
    }

    @Override
    public void save(Song song) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(song);
        entityTransaction.commit();
    }

    @Override
    public Song findById(int id) {
        TypedQuery<Song> typedQuery = BaseRepository.entityManager.createQuery(
                "select s " +
                        "from Song s " +
                        "where s.id=:idSong", Song.class);
        typedQuery.setParameter("idSong", id);
        return typedQuery.getSingleResult();
    }

    @Override
    public void update(int id, Song song) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(song);
        entityTransaction.commit();
    }

    @Override
    public void remove(int id) {
            EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
            entityTransaction.begin();

            Song song = findById(id);

            BaseRepository.entityManager.remove(song);
            entityTransaction.commit();

    }
}
