package org.openmrs.module.icare.laboratory.models;

// Generated Oct 7, 2020 12:48:40 PM by Hibernate Tools 5.2.10.Final

import org.hibernate.annotations.GenericGenerator;
import org.openmrs.User;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import static javax.persistence.GenerationType.IDENTITY;

/**
 * LbTestAllocationStatus generated by hbm2java
 */
@Entity
@Table(name = "lb_test_allocation_status")
public class TestAllocationStatus implements java.io.Serializable {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "test_allocation_status_id", unique = true, nullable = false)
	private int id;
	
	//	@GeneratedValue(generator = "system-uuid")
	//	@GenericGenerator(name = "system-uuid", strategy = "uuid")
	//	@Column(name = "uuid", unique = true)
	//	private String uuid = UUID.randomUUID().toString();
	
	@ManyToOne
	@JoinColumn(name = "test_allocation_id", nullable = false)
	private TestAllocation testAllocation;
	
	@ManyToOne
	@JoinColumn(name = "test_result_id", nullable = true)
	private Result testResult;
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;
	
	@Column(name = "status", length = 65535)
	private String status;
	
	@Column(name = "remarks", length = 65535)
	private String remarks;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "timestamp", length = 19)
	private Date timestamp;
	
	@Column(name = "category", length = 32)
	private String category;
	
	@Column(name = "retired")
	private Boolean retired;
	
	public String getStatus() {
		return this.status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getRemarks() {
		return this.remarks;
	}
	
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public TestAllocation getTestAllocation() {
		return testAllocation;
	}
	
	public void setTestAllocation(TestAllocation testAllocation) {
		this.testAllocation = testAllocation;
	}
	
	public Result getTestResult() {
		return testResult;
	}
	
	public void setTestResult(Result testResult) {
		this.testResult = testResult;
	}
	
	public Date getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	//	public String getUuid() {
	//		return uuid;
	//	}
	
	//	public void setUuid(String uuid) {
	//		this.uuid = uuid;
	//	}
	
	public String getCategory() {
		return category;
	}
	
	public void setCategory(String category) {
		this.category = category;
	}
	
	public void setRetired(boolean retired) {
		this.retired = retired;
	}
	
	public Boolean getRetired() {
		return retired;
	}
	
	public static TestAllocationStatus fromMap(Map<String, Object> map) {
		TestAllocationStatus testAllocationStatus = new TestAllocationStatus();
		
		TestAllocation testAllocation = new TestAllocation();
		testAllocation.setUuid(((Map) map.get("testAllocation")).get("uuid").toString());
		testAllocationStatus.setTestAllocation(testAllocation);
		
		if (map.get("testResult") != null && ((Map) map.get("testResult")).get("uuid") != null) {
			Result testResult = new Result();
			testResult.setUuid(((Map) map.get("testResult")).get("uuid").toString());
			testAllocationStatus.setTestResult(testResult);
		}
		
		User user = new User();
		user.setUuid(((Map) map.get("user")).get("uuid").toString());
		testAllocationStatus.setUser(user);
		
		testAllocationStatus.setRemarks(((map.get("remarks")).toString()));
		testAllocationStatus.setStatus((map.get("status")).toString());
		if (map.get("category") != null) {
			testAllocationStatus.setCategory((map.get("category")).toString());
		}
		if (map.get("retired") != null) {
			testAllocationStatus.setRetired((Boolean) map.get("retired"));
		}
		testAllocationStatus.setTimestamp(new Timestamp(new Date().getTime()));
		testAllocationStatus.setUser(user);
		return testAllocationStatus;
	}
	
	public Map<String, Object> toMap() {
		Map<String, Object> allocationStatusesObject = new HashMap<String, Object>();
		allocationStatusesObject.put("status", this.getStatus());
		allocationStatusesObject.put("remarks", this.getRemarks());
		allocationStatusesObject.put("timestamp", this.getTimestamp());
		//allocationStatusesObject.put("uuid", this.getUuid());
		if (this.getCategory() != null) {
			allocationStatusesObject.put("category", this.getCategory());
		}
		if (this.retired != null) {
			allocationStatusesObject.put("retired", this.getRetired());
		}
		Map<String, Object> result = new HashMap<>();

		if (this.testResult != null) {
			result.put("uuid", this.getTestResult().getUuid());
		} else {
			result = null;
		}
		allocationStatusesObject.put("result", result);
		Map<String, Object> testAllocationStatusUserObject = new HashMap<String, Object>();
		testAllocationStatusUserObject.put("uuid", this.getUser().getUuid());
		testAllocationStatusUserObject.put("display", this.getUser().getDisplayString());
		allocationStatusesObject.put("user", testAllocationStatusUserObject);
		
		return allocationStatusesObject;
	}
}
