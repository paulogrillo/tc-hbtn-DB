package models;

import entities.Pessoa;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PessoaModel {

    public void create(Pessoa pessoa) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a criação da pessoa");
            em.getTransaction().begin();
            em.persist(pessoa);
            em.getTransaction().commit();
            System.out.println("Pessoa criada com sucesso!");
        } catch (Exception e) {
            em.close();
            System.out.println("Erro ao criar pessoa "+ e.getMessage());
        } finally {
            em.close();
            emf.close();
            System.out.println("Fechando conexão com o banco de dados");
        }
    }

    public Pessoa findById(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a busca da pessoa de id " + id);
            Pessoa pessoa = em.find(Pessoa.class, id);
            System.out.println("Pessoa de id " + id + " encontrada com sucesso!");
            return pessoa;
        } catch (Exception e) {
            System.out.println("Erro ao buscar pessoa de id " + id + " " + e.getMessage());
            return null;
        } finally {
            em.close();
            emf.close();
            System.out.println("Fechando conexão com o banco de dados");
        }
    }

    public List<Pessoa> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a busca de todas as pessoas");
            List<Pessoa> pessoas = em.createQuery("SELECT p FROM Pessoa p", Pessoa.class).getResultList();
            System.out.println("Pessoas encontradas com sucesso!");
            return pessoas;
        } catch (Exception e) {
            System.out.println("Erro ao buscar todas as pessoas " + e.getMessage());
            return null;
        } finally {
            em.close();
            emf.close();
            System.out.println("Fechando conexão com o banco de dados");
        }
    }

    public void update(Pessoa pessoa) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a atualização da pessoa");
            em.getTransaction().begin();
            pessoa = em.find(Pessoa.class, pessoa.getId());
            em.merge(pessoa);
            em.getTransaction().commit();
            System.out.println("Pessoa de id " + pessoa.getId() + " atualizada com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao atualizar pessoa de id " + pessoa.getId() + " " + e.getMessage());
        } finally {
            em.close();
            emf.close();
            System.out.println("Fechando conexão com o banco de dados");
        }
    }

    public void delete(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a exclusão da pessoa de id " + id);
            em.getTransaction().begin();
            Pessoa pessoa = em.find(Pessoa.class, id);
            em.remove(pessoa);
            em.flush();
            em.getTransaction().commit();
            System.out.println("Pessoa de id " + id + " excluída com sucesso!");
        } catch (Exception e) {
            em.close();
            System.out.println("Erro ao excluir pessoa de id " + id + " " + e.getMessage());
        } finally {
            em.close();
            emf.close();
            System.out.println("Fechando conexão com o banco de dados");
        }
    }
}