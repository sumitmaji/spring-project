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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sum.hr.server.data.dao.JobDAO;
import com.sum.hr.server.data.model.Job;
import com.sum.hr.server.hrexception.HrException;


@Service("jobService")  
public class JobServiceImpl implements JobService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6440632235600495002L;
	private static transient Logger log = Logger
			.getLogger(JobServiceImpl.class);
	@Autowired
	private JobDAO jobDAO;

	@Transactional
	public Job getJob(String name) {
		try {

			Job job = jobDAO.get(name);
			return job;

		} catch (HrException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
