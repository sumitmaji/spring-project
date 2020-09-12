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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sum.hr.server.data.dao.CountryDAO;
import com.sum.hr.server.data.model.Country;
import com.sum.hr.server.hrexception.HrException;


@Service("countryService")  
public class CountryServiceImpl implements CountryService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6440632235600495002L;
	private static transient Logger log = Logger
			.getLogger(CountryServiceImpl.class);
	@Autowired
	private CountryDAO countryDAO;

	@Transactional
	public Country getCountry(String name) {
		try {

			Country country = countryDAO.get(name);
			return country;

		} catch (HrException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
