package sample.payara.dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import sample.payara.model.SampleModel;

@Stateless
public class SampleModelDao {
    @PersistenceContext(unitName = "apple")
    private EntityManager em;

    public SampleModel sampleModel() {
        return new SampleModel(1, "hoge");
    }

    public List<SampleModel> findAll() {
        return em.createQuery("from SampleModel s order by s.id", SampleModel.class).getResultList();
    }

    public SampleModel findBy(Long id) {
        return em.find(SampleModel.class, id);
    }

}
