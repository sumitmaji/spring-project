/*******************************************************************************
 * Copyright 2011 Google Inc. All Rights Reserved.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *******************************************************************************/
package com.sum.hr.server.service;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sum.hr.server.data.dao.EmployeeDAO;
import com.sum.hr.server.data.model.Employee;
import com.sum.hr.server.hrexception.HrException;
import com.sum.hr.server.hrexception.HrValidationException;
import com.sum.hr.server.response.ListData;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6440632235600495002L;
	private static transient Logger log = Logger
			.getLogger(EmployeeServiceImpl.class);
	@Autowired
	private EmployeeDAO employeeDAO;

	@Transactional
	public ListData<Employee> getEmployees(String start, String limit) {
		try {

			ListData<Employee> emListData = new ListData<Employee>();
			emListData.setT(employeeDAO.list(start, limit));
			emListData.setCount(employeeDAO.getEmployeeCount());
			return emListData;

		} catch (HrException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	public Employee getEmployee(int id) {
		try {

			Employee emp = employeeDAO.get(id);

			return emp;

		} catch (HrException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Transactional
	public Employee updateEmployee(Employee employee) throws HibernateException, HrValidationException, HrException{
		// TODO Auto-generated method stub
		employeeDAO.update(employee);

		return getEmployee(employee.getId());
	}

}
