package models;

import entities.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProdutoModel {

    public void create(Produto produto) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando criação de produto");
            em.getTransaction().begin();
            em.persist(produto);
            em.getTransaction().commit();
            System.out.println("Produto criado com sucesso!");
        } catch (Exception e) {
            em.close();
            System.out.println("Erro ao criar produto!");
        } finally {
            em.close();
            System.out.println("Fechando conexão com o banco de dados...");
            System.out.println();
        }
    }

    public Produto findById(Integer id) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando busca de produto");
            Produto produto = em.find(Produto.class, id);
            System.out.println("Produto de id " + id + " encontrado com sucesso!");
            return produto;
        } catch (Exception e) {
            System.out.println("Erro ao buscar produto de id " + id);
            return null;
        } finally {
            em.close();
            emf.close();
            System.out.println("Fechando conexão com o banco de dados...");
        }
    }

    public List<Produto> findAll() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando busca de todos os produtos");
            List<Produto> produtos = em.createQuery("SELECT p FROM Produto p", Produto.class).getResultList();
            System.out.println("Produtos encontrados com sucesso!");
            return produtos;
        } catch (Exception e) {
            System.out.println("Erro ao buscar todos os produtos!");
            return null;
        } finally {
            em.close();
            emf.close();
            System.out.println("Fechando conexão com o banco de dados...");
        }
    }

    public void update(Produto produto){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try{
            System.out.println("Iniciando atualização de produto");
            em.getTransaction().begin();
            produto = em.find(Produto.class, produto.getId());
            em.merge(produto);
            em.getTransaction().commit();
            System.out.println("Produto com id " + produto.getId() + " atualizado com sucesso!");
        }catch (Exception e){
            em.close();
            System.out.println("Erro ao atualizar produto com id " + produto.getId());
        } finally {
            em.close();
            emf.close();
            System.out.println("Fechando conexão com o banco de dados...");
        }
    }

    public void delete(Integer id){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try{
            System.out.println("Iniciando remoção de produto");
            em.getTransaction().begin();
            Produto produto = em.find(Produto.class, id);
            em.remove(produto);
            em.flush();
            em.getTransaction().commit();
            System.out.println("Produto com id " + id + " excluído com sucesso!");
        } catch (Exception e){
            em.close();
            System.out.println("Erro ao excluir produto com id " + id);
        } finally {
            em.close();
            emf.close();
            System.out.println("Fechando conexão com o banco de dados...");
        }
    }
}