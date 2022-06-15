package models;

import entities.Aluno;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class AlunoModel {
    //- create, findById, findAll, update e delete.
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("gestao-cursos-jpa");
    public void create(Aluno aluno){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try{
            entityManager = emf.createEntityManager();
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

    public Aluno findById(Aluno aluno){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        Aluno alunoX = null;

        try{
            entityManager = emf.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            alunoX = entityManager.find(Aluno.class, aluno.getId());
            entityTransaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            alunoX = null;
        }finally {
            if(entityManager != null)
                entityManager.close();
        }
        return alunoX;
    }

    public List<Aluno> findAll(){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        List<Aluno> alunosResult;

        try{
            entityManager = emf.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            alunosResult = entityManager.createQuery("FROM " + Aluno.class.getName()).getResultList();
            entityTransaction.commit();
        }catch (Exception e){
            e.printStackTrace();
            alunosResult = null;
            if(entityTransaction != null)
                entityTransaction.rollback();
        }finally {
            if(entityManager != null){
                entityManager.close();
            }
        }
        return alunosResult;
    }

    public void update(Aluno aluno){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;

        try{
            entityManager = emf.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            entityManager.merge(aluno);
            entityTransaction.commit();
        }catch(Exception e){
            e.printStackTrace();
            if(entityTransaction != null)
                entityTransaction.rollback();
        }finally{
            if(entityManager != null)
                entityManager.close();
        }

    }

    public void delete(Aluno aluno){
        EntityManager entityManager = null;
        EntityTransaction entityTransaction = null;
        Aluno alunoDeleted;

        try {
            entityManager = emf.createEntityManager();
            entityTransaction = entityManager.getTransaction();
            entityTransaction.begin();
            alunoDeleted = entityManager.find(Aluno.class, aluno.getId());
            entityManager.remove(alunoDeleted);
            entityTransaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            if (entityTransaction != null)
                entityTransaction.rollback();
        } finally {
            if (entityManager != null)
                entityManager.close();
        }
    }
}
