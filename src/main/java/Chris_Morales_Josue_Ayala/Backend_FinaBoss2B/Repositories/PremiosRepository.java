package Chris_Morales_Josue_Ayala.Backend_FinaBoss2B.Repositories;

import Chris_Morales_Josue_Ayala.Backend_FinaBoss2B.Entities.PremiosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PremiosRepository extends JpaRepository<PremiosEntity, Long> {

}
