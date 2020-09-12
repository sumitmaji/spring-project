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

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sum.hr.server.data.dao.DepartmentDAO;
import com.sum.hr.server.data.model.Department;
import com.sum.hr.server.data.model.Employee;
import com.sum.hr.server.hrexception.HrException;
import com.sum.hr.server.response.ListData;

@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6440632235600495002L;
	private static transient Logger log = Logger
			.getLogger(DepartmentServiceImpl.class);
	@Autowired
	private DepartmentDAO departmentDAO;

	@Transactional
	public Department getDepartment(int id) throws HrException{
		try {

			Department department = departmentDAO.get(id);
			return department;
		} catch (HrException e) {
			e.printStackTrace();
			throw e;
		}
	}

	@Transactional
	public ListData<Department> getDepartments() throws HrException, Exception {
		// TODO Auto-generated method stub
		
		ListData<Department> deptListData = new ListData<Department>();
		deptListData.setT(departmentDAO.list());
		return deptListData;
	}

}
