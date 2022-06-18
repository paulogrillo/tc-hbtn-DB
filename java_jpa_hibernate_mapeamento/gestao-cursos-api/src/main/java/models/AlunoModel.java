package models;

import entities.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class AlunoModel {

    EntityManagerFactory entityFactory = Persistence.createEntityManagerFactory("gestao-cursos-jpa");

    public void create(Aluno aluno){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try{
            entityManager = entityFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.persist(aluno);
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

    public List<Aluno> findAll(){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        List<Aluno> alunosFound;

        try{
            entityManager = entityFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            alunosFound = entityManager.createQuery("FROM " + Aluno.class.getName()).getResultList();
            entityTransaction.commit();
        }catch(Exception ex){
            ex.printStackTrace();
            alunosFound = null;
            if(entityTransaction != null)
                entityTransaction.rollback();
        }finally{
            if(entityManager != null)
                entityManager.close();
        }

        return alunosFound;
    }

    public Aluno findById(Aluno aluno){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        Aluno alunodFound = null;

        try{
            entityManager = entityFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            alunodFound = entityManager.find(Aluno.class, aluno.getId());
            entityTransaction.commit();
        }catch (Exception ex){
            ex.printStackTrace();
            alunodFound = null;
        }finally{
            if(entityManager != null)
                entityManager.close();
        }
        return alunodFound;
    }

    public void update(Aluno aluno){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try{
            entityManager = entityFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.merge(aluno);
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

    public void delete(Aluno aluno) {
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        Aluno alunoDeleted;

        try {
            entityManager = entityFactory.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            alunoDeleted = entityManager.find(Aluno.class, aluno.getId());
            entityManager.remove(alunoDeleted);
            entityTransaction.commit();
        } catch (Exception ex) {
            ex.printStackTrace();
            if (entityTransaction != null)
                entityTransaction.rollback();
        } finally {
            if (entityManager != null)
                entityManager.close();
        }
    }
}