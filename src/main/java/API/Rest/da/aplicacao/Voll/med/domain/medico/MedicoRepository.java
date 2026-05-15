package API.Rest.da.aplicacao.Voll.med.domain.medico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

//extends herdando das outras classes
public interface MedicoRepository extends JpaRepository <Medico, Long> {
    Page<Medico> findAllByAtivoTrue(Pageable paginacao);
}
