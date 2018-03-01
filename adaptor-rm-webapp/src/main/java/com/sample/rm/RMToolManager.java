// Start of user code Copyright
/*******************************************************************************
 * Copyright (c) 2011, 2012 IBM Corporation and others.
 *
 *  All rights reserved. This program and the accompanying materials
 *  are made available under the terms of the Eclipse Public License v1.0
 *  and Eclipse Distribution License v. 1.0 which accompanies this distribution.
 *  
 *  The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 *  and the Eclipse Distribution License is available at
 *  http://www.eclipse.org/org/documents/edl-v10.php.
 *  
 *  Contributors:
 *  
 *	   Sam Padgett	       - initial API and implementation
 *     Michael Fiedler     - adapted for OSLC4J
 *     Jad El-khoury        - initial implementation of code generator (https://bugs.eclipse.org/bugs/show_bug.cgi?id=422448)
 *     Matthieu Helleboid   - Support for multiple Service Providers.
 *     Anass Radouani       - Support for multiple Service Providers.
 *
 * This file is generated by org.eclipse.lyo.oslc4j.codegenerator
 *******************************************************************************/
// End of user code

package com.sample.rm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.ServletContextEvent;
import java.util.List;

import org.eclipse.lyo.oslc4j.core.model.ServiceProvider;
import org.eclipse.lyo.oslc4j.core.model.AbstractResource;
import com.sample.rm.servlet.ServiceProviderCatalogSingleton;
import com.sample.rm.ServiceProviderInfo;
import com.sample.rm.resources.Requirement;


// Start of user code imports
import java.util.concurrent.ThreadLocalRandom;
import java.net.URISyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
// End of user code

// Start of user code pre_class_code
// End of user code

public class RMToolManager {

    // Start of user code class_attributes
	private static final Logger log = LoggerFactory.getLogger(RMToolManager.class);
    // End of user code
    
    
    // Start of user code class_methods
	private static int randomNumber(int origin, int bound) {
		return ThreadLocalRandom.current().nextInt(origin, bound);
	}

	private static Requirement createRandomRequirement(String id) {
		Requirement r = null;
		try {
			r = RMToolResourcesFactory.createRequirement(id);
			r.setTitle("A sample Requirement with id:" + id);
			r.setDescription("A sample Requirement with id:" + id);
		} catch (URISyntaxException e) {
            log.error("Failed to create resource", e);
		}
		return r;
	}

	private static List<Requirement> createRandomRequirements(int min, int max, int minId, int maxId)
    {
		int size = randomNumber(min, max);
		List<Requirement> resources = new ArrayList<Requirement>(size);
		for (int i = 0; i < size; i++) {
	    	resources.add(createRandomRequirement(Integer.toString(randomNumber(minId, maxId))));
		}
        return resources;
    }
    // End of user code

    public static void contextInitializeServletListener(final ServletContextEvent servletContextEvent)
    {
        
        // Start of user code contextInitializeServletListener
        // TODO Implement code to establish connection to data backbone etc ...
        // End of user code
    }

    public static void contextDestroyServletListener(ServletContextEvent servletContextEvent) 
    {
        
        // Start of user code contextDestroyed
        // TODO Implement code to shutdown connections to data backbone etc...
        // End of user code
    }

    public static ServiceProviderInfo[] getServiceProviderInfos(HttpServletRequest httpServletRequest)
    {
        ServiceProviderInfo[] serviceProviderInfos = {};
        
        // Start of user code "ServiceProviderInfo[] getServiceProviderInfos(...)"
        ServiceProviderInfo r1 = new ServiceProviderInfo();
        r1.name = "A sample RM Service Provider 1";
        r1.serviceProviderId = "1";

        ServiceProviderInfo r2 = new ServiceProviderInfo();
        r2.name = "A sample RM Service Provider 2";
        r2.serviceProviderId = "2";

        serviceProviderInfos = new ServiceProviderInfo[2];
        serviceProviderInfos[0] = r1;
        serviceProviderInfos[1] = r2;
        // End of user code
        return serviceProviderInfos;
    }

    public static List<Requirement> queryRequirements(HttpServletRequest httpServletRequest, String where, int page, int limit)
    {
        List<Requirement> resources = null;
        
        // Start of user code queryRequirements
    	resources = createRandomRequirements(1,  30, 1,  10000);
        // End of user code
        return resources;
    }


    public static Requirement getRequirement(HttpServletRequest httpServletRequest, final String requirementId)
    {
        Requirement aResource = null;
        
        // Start of user code getRequirement
    	aResource = createRandomRequirement(requirementId);
        // End of user code
        return aResource;
    }




    public static String getETagFromRequirement(final Requirement aResource)
    {
        String eTag = null;
        // Start of user code getETagFromRequirement
        // TODO Implement code to return an ETag for a particular resource
        // End of user code
        return eTag;
    }

}
