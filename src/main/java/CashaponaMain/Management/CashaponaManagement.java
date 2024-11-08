package CashaponaMain.Management;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import CashaponaMain.Entity.CashaponaEntity;
import CashaponaMain.Response.CashaponaDTO;
import CashaponaMain.Response.CashaponaProjectionConstructor;
import CashaponaMain.Response.CashaponaProjectionConstructor2;
import CashaponaMain.Response.CashponaDTOnative;
import CashaponaMain.Response.JoinDetails;
import CashaponaMain.Service.CashaponaService;

@RestController
@RequestMapping("/cashapona")
public class CashaponaManagement {

	@Autowired
	CashaponaService cashaponaservice;
	
	@PostMapping("/add")
	public void toAdd(@RequestBody CashaponaEntity cashaponaentity)
	{	
		cashaponaservice.addData(cashaponaentity);
	}
	
	@PostMapping("/all")
	public void toAddAll(@RequestBody List<CashaponaEntity> cashaponaentity) {
		cashaponaservice.addAll(cashaponaentity);
	}
	
	@GetMapping("/get")
	public List<CashaponaEntity> toGetAll(){
		return cashaponaservice.getAll();
	}
	
	@GetMapping("/get/{id}")
	public CashaponaEntity toGetById(@PathVariable	int id) {
		CashaponaEntity dataId =cashaponaservice.getById(id);
		return dataId;
	}
	
	@PutMapping("/update/{id}")
	public void toUpdate(@PathVariable int id) {
		cashaponaservice.update(id);
	}
	
	@DeleteMapping("/delete/{id}")
	public void toDelete(@PathVariable int id)
	{	
		cashaponaservice.delete(id);
	}
	
	@DeleteMapping("/deleteall")
	public void toDeleteAll()
	{	
		cashaponaservice.deleteAll();
	}
	
	
	@GetMapping("/salary/{field}")
	public List<CashaponaEntity> sortAll(@PathVariable String field){
		return cashaponaservice.sort(field);
	}
	
	//sql native query
	
	@GetMapping("/tofindall")
	public List<CashaponaEntity> managementFindAll(){
		return cashaponaservice.servicetoFindAll();
	}
	
	@GetMapping("/namesal")
	public List<CashponaDTOnative> managementFindNameSal(){
		return cashaponaservice.serviceFindNameSal();
	}
	
	
	
	
	
	//projection interface
	@GetMapping("/require")
	public List<CashaponaDTO> managementGetRequire(){
	
		return cashaponaservice.serviceGetRequire();
	}
	
	//projection constructor
	@GetMapping("/conrequire")
	public List<CashaponaProjectionConstructor> managementConRequire(){
	
		return cashaponaservice.serviceConRequire();
	}
	
	
	@GetMapping("/conrequire2")
	public List<CashaponaProjectionConstructor2> managementConRequire2(){
		return cashaponaservice.serviceConRequire2();
	}
	
	
	
	
	//jpa query
	
	/* @GetMapping("/name/{name}")
	public CashaponaEntity getByName(@PathVariable String name) {
		return cashaponaservice.serviceGetCashaponaEntityByName(name);
	} */
	
	@GetMapping("/{name}/{location}")
	public CashaponaEntity managementGetByNameAndLocation(@PathVariable String name ,@PathVariable String location) {
		return cashaponaservice.seriveGetByNameAndLocation(name, location);
	}
	
	@GetMapping("/{salary}")
	public CashaponaEntity managementGetBySalary(@PathVariable int salary) {
		return cashaponaservice.seriveGetBySalary(salary);
	}
	
		@GetMapping("/namesin")
		public List<CashaponaEntity> managementFindByName() {
			return cashaponaservice.serviceFindByNames();
	}
	
		@GetMapping("/salaryin")
		public ResponseEntity<List<CashaponaEntity>> managementFindBySalary(){
			List<CashaponaEntity> sal=cashaponaservice.serviceFindBySalary();
			return new ResponseEntity<>(sal,HttpStatus.ACCEPTED);
		}
	
		@GetMapping("/rolein/{names}")
		public ResponseEntity<List<CashaponaEntity>> managementFindByrole(@PathVariable List<String> names){
			List<CashaponaEntity> role=cashaponaservice.serviceFindByJobRole(names);
			return new ResponseEntity<>(role,HttpStatus.ACCEPTED);
		}
		@GetMapping("/idin/{ids}")
		public ResponseEntity<List<CashaponaEntity>> managementFindById(@PathVariable List<Integer> ids){
			List<CashaponaEntity> id=cashaponaservice.servicefindById(ids);
			return new ResponseEntity<>(id,HttpStatus.ACCEPTED);
		}
		
		@GetMapping("/joins")
		public List<JoinDetails> servicejoin(){
			return cashaponaservice.servicejoin();
		}
}


