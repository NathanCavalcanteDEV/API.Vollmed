package API.Rest.da.aplicacao.Voll.med.medico;

import org.apache.logging.log4j.util.Lazy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

//extends herdando das outras classes
public interface MedicoRepository extends JpaRepository <Medico, Long> {
    Page<Medico> findAllByAtivoTrue(Pageable paginacao);
}
