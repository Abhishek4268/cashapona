package CashaponaMain.Service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import CashaponaMain.Entity.CashaponaEntity;
import CashaponaMain.Repository.CashaponaRepository;
import CashaponaMain.Response.CashaponaDTO;
import CashaponaMain.Response.CashaponaProjectionConstructor;
import CashaponaMain.Response.CashaponaProjectionConstructor2;
import CashaponaMain.Response.CashponaDTOnative;
import CashaponaMain.Response.JoinDetails;

@Service
public class CashaponaService {
	
	@Autowired
	CashaponaRepository cashaponarepository;	

	//to add the data
	public void addData( CashaponaEntity cashapona) {
		cashaponarepository.save(cashapona);
	}
	
	//to add the data multiple
	public void addAll( List<CashaponaEntity> cashapona) {
		cashaponarepository.saveAll(cashapona);
	}
	
	//to fetch all the data
	public List<CashaponaEntity> getAll(){
		List<CashaponaEntity> data=cashaponarepository.findAll();
		return data;
	}
	//to fetch data individual
	public CashaponaEntity getById(int id)
	{	
		CashaponaEntity dataById=cashaponarepository.findById(id).get();
		return dataById;
	}
	//to update the data 
	public void update(int id)
	{	
		CashaponaEntity updateEntity=cashaponarepository.findById(id).get();
		updateEntity.setName("Abhishek");
		updateEntity.setRole("java");
		updateEntity.setSalary(25000);
		cashaponarepository.save(updateEntity);
		
	}
	//to delete the data
	public void delete(int id){
		CashaponaEntity deleteEntity=cashaponarepository.findById(id).get();
		cashaponarepository.delete(deleteEntity);
	}
	
	public void deleteAll(){
		cashaponarepository.deleteAll();
	}
	
	//SQL nqtive query
	
	public List<CashaponaEntity> sort(String field){
		return  cashaponarepository.findAll(Sort.by(Sort.Direction.DESC,field));
	}
	
	public List<CashponaDTOnative> serviceFindNameSal() {
		// TODO Auto-generated method stub
		return cashaponarepository.findnamesal();
	}

	
	//JPA Query 
	
	public List<CashaponaEntity> servicetoFindAll() {
		
		List<CashaponaEntity> cpentity=cashaponarepository.findAll();
		return cpentity;
	}
	
	
	
	
	
	
	
	public CashaponaEntity serviceGetCashaponaEntityByName(String name){
		return cashaponarepository.getCashaponaEntityByName(name);
	}
	
	public CashaponaEntity seriveGetByNameAndLocation(String name,String location) {
		return cashaponarepository. getByNameAndLocation(name, location);
	}
	
	public CashaponaEntity seriveGetBySalary(Integer salary) {
		CashaponaEntity sal=cashaponarepository.getBySal(salary);
		return sal;
	}
	
	public List<CashaponaEntity> serviceFindByNames(){
		List<CashaponaEntity> CP=cashaponarepository.findByNameIn(Arrays.asList("Abhishek","raghu","srinu"));
		return CP;
	}
	
	public List<CashaponaEntity> serviceFindBySalary(){
		
		List<CashaponaEntity> Cpsal=cashaponarepository.findBySalaryIn(Arrays.asList(25000,30000));
		return Cpsal;
	}
	
public List<CashaponaEntity> serviceFindByJobRole(List<String> names){
		
		List<CashaponaEntity> Cprole=cashaponarepository.findByJobRoleIn(names);
		return Cprole;
	}
	
	
public List<CashaponaEntity> servicefindById(List<Integer> ids){
	List<CashaponaEntity> CpId =cashaponarepository.findByIdIn(ids);
	return CpId;
}

//projection interface
public List<CashaponaDTO> serviceGetRequire() {
	// TODO Auto-generated method stub
	return  cashaponarepository.findRequired();
}

//projection constructor
public List<CashaponaProjectionConstructor> serviceConRequire() {
return cashaponarepository.conrequire();
}

//constructor wit natie query not works
public List<CashaponaProjectionConstructor2> serviceConRequire2() {
return cashaponarepository.conrequire2();
}

//joins query

	public List<JoinDetails> servicejoin(){
		return cashaponarepository.byJoin();
	}





	
}
