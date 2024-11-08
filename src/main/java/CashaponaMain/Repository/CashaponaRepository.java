package CashaponaMain.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import CashaponaMain.Entity.CashaponaEntity;
import CashaponaMain.Response.CashaponaDTO;
import CashaponaMain.Response.CashaponaProjectionConstructor;
import CashaponaMain.Response.CashaponaProjectionConstructor2;
import CashaponaMain.Response.CashponaDTOnative;
import CashaponaMain.Response.JoinDetails;


@Repository
public interface CashaponaRepository extends JpaRepository< CashaponaEntity, Integer> {
	
	
	//JPA Queries
	@Query("select cp from CashaponaEntity cp where cp.name= :n")
	 CashaponaEntity getCashaponaEntityByName(@Param("n") String name);
	
	@Query("select cp from CashaponaEntity cp where cp.name= :n and cp.location =:l")
	CashaponaEntity getByNameAndLocation(@Param("n") String name ,@Param("l") String location);
	
	@Query("select cp from CashaponaEntity cp where cp.salary=:s")
	CashaponaEntity getBySal(@Param("s") int salary);
	
	
	//native Queries
	@Query(value="select * from cashapona_details", nativeQuery=true)
	List<CashaponaEntity> findAll();
	
	@Query(value="select cp.name as name,cp.salary as salary from cashapona_details cp", nativeQuery=true)
	List<CashponaDTOnative> findnamesal();
	
	
	
	//Interface Projection
	@Query("select cp.name as name ,cp.jobRole as jobRole,cp.salary as salary from CashaponaEntity cp")
	List<CashaponaDTO> findRequired();
	
	
	//Constructor Projection
	@Query("select new CashaponaMain.Response.CashaponaProjectionConstructor (a.name,a.location) from CashaponaEntity a")
	List<CashaponaProjectionConstructor> conrequire();
	
	
	//it is not possible with native query
	@Query(value="select new CashaponaMain.Response.CashaponaProjectionConstructor2 (a.name,a.salary) from CashaponaEntity a", nativeQuery=true)
	List<CashaponaProjectionConstructor2> conrequire2();
	
	//joins
	@Query("select cp.name,cp.role,cs.phone from CashaponaDetails as cp inner join Details as cs on cp.id=cs.id")
	List<JoinDetails> byJoin();
	
	
	
	//finder methods
	List<CashaponaEntity> findByNameIn(List<String> names);
	
	List<CashaponaEntity> findBySalaryIn(List<Integer> salary);
	
	List<CashaponaEntity> findByJobRoleIn(List<String> jobrole);
	
	List<CashaponaEntity> findByIdIn(List<Integer> id);

}
