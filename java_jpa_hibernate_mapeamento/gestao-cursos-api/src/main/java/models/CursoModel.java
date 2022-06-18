package models;

import entities.Curso;
import entities.Professor;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class CursoModel {

    EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("gestao-cursos-jpa");

    public void create(Curso curso){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        Professor professor;

        try{
            entityManager = entityFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            if(curso.getProfessor().getId() != null) {
                professor = entityManager.find(Professor.class, curso.getProfessor().getId());
                curso.setProfessor(professor);
            }
            entityManager.persist(curso);
            entityTransaction.commit();
        }catch(Exception ex){
            ex.printStackTrace();
            if(entityTransaction != null)
                entityTransaction.rollback();
        }finally{
            if(entityManager != null)
                entityManager.close();
        }
    }

    public List<Curso> findAll(){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        List<Curso> cursosFound;

        try{
            entityManager = entityFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            cursosFound = entityManager.createQuery("FROM " + Curso.class.getName()).getResultList();
            entityTransaction.commit();
        }catch(Exception ex){
            ex.printStackTrace();
            cursosFound = null;
            if(entityTransaction != null)
                entityTransaction.rollback();
        }finally{
            if(entityManager != null)
                entityManager.close();
        }

        return cursosFound;
    }

    public Curso findById(Curso curso){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        Curso cursoFound = null;

        try{
            entityManager = entityFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            cursoFound = entityManager.find(Curso.class, curso.getId());
            entityTransaction.commit();
        }catch (Exception ex){
            ex.printStackTrace();
            cursoFound = null;
        }finally{
            if(entityManager != null)
                entityManager.close();
        }
        return cursoFound;
    }

    public void update(Curso curso){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try{
            entityManager = entityFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.merge(curso);
            entityTransaction.commit();
        }catch(Exception ex){
            ex.printStackTrace();
            if(entityTransaction != null)
                entityTransaction.rollback();
        }finally{
            if(entityManager != null)
                entityManager.close();
        }
    }

    public void delete(Curso curso){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        Curso cursoDeleted;

        try{
            entityManager = entityFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            cursoDeleted = entityManager.find(Curso.class, curso.getId());
            entityManager.remove(cursoDeleted);
            entityTransaction.commit();
        }catch(Exception ex){
            ex.printStackTrace();
            if(entityTransaction != null)
                entityTransaction.rollback();
        }finally{
            if(entityManager != null)
                entityManager.close();
        }
    }
}