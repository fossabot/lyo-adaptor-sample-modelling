// Start of user code Copyright
/*******************************************************************************
 * Copyright (c) 2012 IBM Corporation and others.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompanies this distribution.
 *
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 *
 * Contributors:
 *
 *     Michael Fiedler     - initial API and implementation for Bugzilla adapter
 *     Jad El-khoury       - initial implementation of code generator (https://bugs.eclipse.org/bugs/show_bug.cgi?id=422448)
 *     Jim Amsden          - Support for UI Preview (494303)
 *
 * This file is generated by org.eclipse.lyo.oslc4j.codegenerator
 *******************************************************************************/
// End of user code

package com.sample.rm.services;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.core.UriBuilder;

import org.apache.wink.json4j.JSONObject;
import org.eclipse.lyo.oslc4j.provider.json4j.JsonHelper;
import org.eclipse.lyo.oslc4j.core.OSLC4JUtils;
import org.eclipse.lyo.oslc4j.core.annotation.OslcCreationFactory;
import org.eclipse.lyo.oslc4j.core.annotation.OslcDialog;
import org.eclipse.lyo.oslc4j.core.annotation.OslcDialogs;
import org.eclipse.lyo.oslc4j.core.annotation.OslcQueryCapability;
import org.eclipse.lyo.oslc4j.core.annotation.OslcService;
import org.eclipse.lyo.oslc4j.core.model.Compact;
import org.eclipse.lyo.oslc4j.core.model.OslcConstants;
import org.eclipse.lyo.oslc4j.core.model.OslcMediaType;
import org.eclipse.lyo.oslc4j.core.model.Preview;
import org.eclipse.lyo.oslc4j.core.model.ServiceProvider;
import org.eclipse.lyo.oslc4j.core.model.Link;
import org.eclipse.lyo.oslc4j.core.model.AbstractResource;

import com.sample.rm.RMToolManager;
import com.sample.rm.RMToolConstants;
import com.sample.rm.resources.Oslc_rmDomainConstants;
import com.sample.rm.resources.Oslc_rmDomainConstants;
import com.sample.rm.servlet.ServiceProviderCatalogSingleton;
import com.sample.rm.resources.Requirement;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

// Start of user code imports
// End of user code

// Start of user code pre_class_code
// End of user code
@OslcService(Oslc_rmDomainConstants.REQUIREMENTS_MANAGEMENT_DOMAIN)
@Path("requirements")
@Api(value = "OSLC Service for {" + Oslc_rmDomainConstants.REQUIREMENT_LOCALNAME + "}")
public class ServiceProviderService1
{
    @Context private HttpServletRequest httpServletRequest;
    @Context private HttpServletResponse httpServletResponse;
    @Context private UriInfo uriInfo;

    // Start of user code class_attributes
    // End of user code

    // Start of user code class_methods
    // End of user code

    public ServiceProviderService1()
    {
        super();
    }

    @OslcQueryCapability
    (
        title = "QueryCapability",
        label = "QueryCapability",
        resourceShape = OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_rmDomainConstants.REQUIREMENT_PATH,
        resourceTypes = {Oslc_rmDomainConstants.REQUIREMENT_TYPE},
        usages = {}
    )
    @GET
    @Path("query")
    @Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON, OslcMediaType.TEXT_TURTLE})
    @ApiOperation(
        value = "Query capability for resources of type {" + Oslc_rmDomainConstants.REQUIREMENT_LOCALNAME + "}",
        notes = "Query capability for resources of type {" + "<a href=\"" + Oslc_rmDomainConstants.REQUIREMENT_TYPE + "\">" + Oslc_rmDomainConstants.REQUIREMENT_LOCALNAME + "</a>" + "}" +
            ", with respective resource shapes {" + "<a href=\"" + "../services/" + OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_rmDomainConstants.REQUIREMENT_PATH + "\">" + Oslc_rmDomainConstants.REQUIREMENT_LOCALNAME + "</a>" + "}",
        produces = OslcMediaType.APPLICATION_RDF_XML + ", " + OslcMediaType.APPLICATION_XML + ", " + OslcMediaType.APPLICATION_JSON + ", " + OslcMediaType.TEXT_TURTLE + ", " + MediaType.TEXT_HTML
    )
    public Requirement[] queryRequirements(
                                                    
                                                     @QueryParam("oslc.where") final String where,
                                                     @QueryParam("page") final String pageString,
                                                    @QueryParam("limit") final String limitString) throws IOException, ServletException
    {
        int page=0;
        int limit=20;
        if (null != pageString) {
            page = Integer.parseInt(pageString);
        }
        if (null != limitString) {
            limit = Integer.parseInt(limitString);
        }

        // Start of user code queryRequirements
        // Here additional logic can be implemented that complements main action taken in RMToolManager
        // End of user code

        final List<Requirement> resources = RMToolManager.queryRequirements(httpServletRequest, where, page, limit);
        return resources.toArray(new Requirement [resources.size()]);
    }

    @GET
    @Path("query")
    @Produces({ MediaType.TEXT_HTML })
    @ApiOperation(
        value = "Query capability for resources of type {" + Oslc_rmDomainConstants.REQUIREMENT_LOCALNAME + "}",
        notes = "Query capability for resources of type {" + "<a href=\"" + Oslc_rmDomainConstants.REQUIREMENT_TYPE + "\">" + Oslc_rmDomainConstants.REQUIREMENT_LOCALNAME + "</a>" + "}" +
            ", with respective resource shapes {" + "<a href=\"" + "../services/" + OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_rmDomainConstants.REQUIREMENT_PATH + "\">" + Oslc_rmDomainConstants.REQUIREMENT_LOCALNAME + "</a>" + "}",
        produces = OslcMediaType.APPLICATION_RDF_XML + ", " + OslcMediaType.APPLICATION_XML + ", " + OslcMediaType.APPLICATION_JSON + ", " + OslcMediaType.TEXT_TURTLE + ", " + MediaType.TEXT_HTML
    )
    public Response queryRequirementsAsHtml(
                                    
                                       @QueryParam("oslc.where") final String where,
                                       @QueryParam("page") final String pageString,
                                    @QueryParam("limit") final String limitString) throws ServletException, IOException
    {
        int page=0;
        int limit=20;
        if (null != pageString) {
            page = Integer.parseInt(pageString);
        }
        if (null != limitString) {
            limit = Integer.parseInt(limitString);
        }

        // Start of user code queryRequirementsAsHtml
        // End of user code

        final List<Requirement> resources = RMToolManager.queryRequirements(httpServletRequest, where, page, limit);

        if (resources!= null) {
            httpServletRequest.setAttribute("resources", resources);
            // Start of user code queryRequirementsAsHtml_setAttributes
            // End of user code

            httpServletRequest.setAttribute("queryUri",
                    uriInfo.getAbsolutePath().toString() + "?oslc.paging=true");
            if (resources.size() > limit) {
                resources.remove(resources.size() - 1);
                httpServletRequest.setAttribute("nextPageUri",
                        uriInfo.getAbsolutePath().toString() + "?oslc.paging=true&amp;page=" + (page + 1));
            }
            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/com/sample/rm/requirementscollection.jsp");
            rd.forward(httpServletRequest,httpServletResponse);
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @OslcDialog
    (
         title = "SelectionDialog1",
         label = "SelectionDialog1",
         uri = "requirements/selector",
         hintWidth = "0px",
         hintHeight = "0px",
         resourceTypes = {Oslc_rmDomainConstants.REQUIREMENT_TYPE},
         usages = {}
    )
    @GET
    @Path("selector")
    @Consumes({ MediaType.TEXT_HTML, MediaType.WILDCARD })
    public void RequirementSelector(
        @QueryParam("terms") final String terms
        
        ) throws ServletException, IOException
    {
        try {
            // Start of user code RequirementSelector_init
            // End of user code

            httpServletRequest.setAttribute("selectionUri",UriBuilder.fromUri(OSLC4JUtils.getServletURI()).path(uriInfo.getPath()).build().toString());
            // Start of user code RequirementSelector_setAttributes
            // End of user code

            if (terms != null ) {
                httpServletRequest.setAttribute("terms", terms);
                final List<Requirement> resources = RMToolManager.RequirementSelector(httpServletRequest, terms);
                if (resources!= null) {
                            httpServletRequest.setAttribute("resources", resources);
                            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/com/sample/rm/requirementselectorresults.jsp");
                            rd.forward(httpServletRequest, httpServletResponse);
                }
                //a empty search should return an empty list and not NULL!
                throw new WebApplicationException(Status.NOT_FOUND);

            } else {
                try {
                    RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/com/sample/rm/requirementselector.jsp");
                    rd.forward(httpServletRequest, httpServletResponse);
                } catch (Exception e) {
                    throw new ServletException(e);
                }
            }
        } catch (Exception e) {
            throw new WebApplicationException(e);
        }
    }

    @GET
    @Path("{requirementId}")
    @Produces({OslcMediaType.APPLICATION_RDF_XML, OslcMediaType.APPLICATION_XML, OslcMediaType.APPLICATION_JSON, OslcMediaType.TEXT_TURTLE})
    @ApiOperation(
        value = "GET for resources of type {" + Oslc_rmDomainConstants.REQUIREMENT_LOCALNAME + "}",
        notes = "GET for resources of type {" + "<a href=\"" + Oslc_rmDomainConstants.REQUIREMENT_TYPE + "\">" + Oslc_rmDomainConstants.REQUIREMENT_LOCALNAME + "</a>" + "}" +
            ", with respective resource shapes {" + "<a href=\"" + "../services/" + OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_rmDomainConstants.REQUIREMENT_PATH + "\">" + Oslc_rmDomainConstants.REQUIREMENT_LOCALNAME + "</a>" + "}",
        produces = OslcMediaType.APPLICATION_RDF_XML + ", " + OslcMediaType.APPLICATION_XML + ", " + OslcMediaType.APPLICATION_JSON + ", " + OslcMediaType.TEXT_TURTLE + ", " + MediaType.TEXT_HTML + ", " + OslcMediaType.APPLICATION_X_OSLC_COMPACT_XML
    )
    public Requirement getRequirement(
                @PathParam("requirementId") final String requirementId
        ) throws IOException, ServletException, URISyntaxException
    {
        // Start of user code getResource_init
        // End of user code

        final Requirement aRequirement = RMToolManager.getRequirement(httpServletRequest, requirementId);

        if (aRequirement != null) {
            // Start of user code getRequirement
            // End of user code
            httpServletResponse.addHeader(RMToolConstants.HDR_OSLC_VERSION, RMToolConstants.OSLC_VERSION_V2);
            return aRequirement;
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    @Path("{requirementId}")
    @Produces({ MediaType.TEXT_HTML })
    @ApiOperation(
        value = "GET for resources of type {" + Oslc_rmDomainConstants.REQUIREMENT_LOCALNAME + "}",
        notes = "GET for resources of type {" + "<a href=\"" + Oslc_rmDomainConstants.REQUIREMENT_TYPE + "\">" + Oslc_rmDomainConstants.REQUIREMENT_LOCALNAME + "</a>" + "}" +
            ", with respective resource shapes {" + "<a href=\"" + "../services/" + OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_rmDomainConstants.REQUIREMENT_PATH + "\">" + Oslc_rmDomainConstants.REQUIREMENT_LOCALNAME + "</a>" + "}",
        produces = OslcMediaType.APPLICATION_RDF_XML + ", " + OslcMediaType.APPLICATION_XML + ", " + OslcMediaType.APPLICATION_JSON + ", " + OslcMediaType.TEXT_TURTLE + ", " + MediaType.TEXT_HTML + ", " + OslcMediaType.APPLICATION_X_OSLC_COMPACT_XML
    )
    public Response getRequirementAsHtml(
        @PathParam("requirementId") final String requirementId
        ) throws ServletException, IOException, URISyntaxException
    {
        // Start of user code getRequirementAsHtml_init
        // End of user code

        final Requirement aRequirement = RMToolManager.getRequirement(httpServletRequest, requirementId);

        if (aRequirement != null) {
            httpServletRequest.setAttribute("aRequirement", aRequirement);
            // Start of user code getRequirementAsHtml_setAttributes
            // End of user code

            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/com/sample/rm/requirement.jsp");
            rd.forward(httpServletRequest,httpServletResponse);
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    @Path("{requirementId}")
    @Produces({OslcMediaType.APPLICATION_X_OSLC_COMPACT_XML})
    @ApiOperation(
        value = "GET for resources of type {" + Oslc_rmDomainConstants.REQUIREMENT_LOCALNAME + "}",
        notes = "GET for resources of type {" + "<a href=\"" + Oslc_rmDomainConstants.REQUIREMENT_TYPE + "\">" + Oslc_rmDomainConstants.REQUIREMENT_LOCALNAME + "</a>" + "}" +
            ", with respective resource shapes {" + "<a href=\"" + "../services/" + OslcConstants.PATH_RESOURCE_SHAPES + "/" + Oslc_rmDomainConstants.REQUIREMENT_PATH + "\">" + Oslc_rmDomainConstants.REQUIREMENT_LOCALNAME + "</a>" + "}",
        produces = OslcMediaType.APPLICATION_RDF_XML + ", " + OslcMediaType.APPLICATION_XML + ", " + OslcMediaType.APPLICATION_JSON + ", " + OslcMediaType.TEXT_TURTLE + ", " + MediaType.TEXT_HTML + ", " + OslcMediaType.APPLICATION_X_OSLC_COMPACT_XML
    )
    public Compact getRequirementCompact(
        @PathParam("requirementId") final String requirementId
        ) throws ServletException, IOException, URISyntaxException
    {
        String iconUri = OSLC4JUtils.getPublicURI() + "/images/ui_preview_icon.gif";
        String smallPreviewHintHeight = "10em";
        String smallPreviewHintWidth = "45em";
        String largePreviewHintHeight = "20em";
        String largePreviewHintWidth = "45em";

        // Start of user code getRequirementCompact_init
        //TODO: adjust the preview height & width values from the default values provided above.
        // End of user code

        final Requirement aRequirement = RMToolManager.getRequirement(httpServletRequest, requirementId);

        if (aRequirement != null) {
            final Compact compact = new Compact();

            compact.setAbout(aRequirement.getAbout());
            compact.setTitle(aRequirement.toString());

            compact.setIcon(new URI(iconUri));

            //Create and set attributes for OSLC preview resource
            final Preview smallPreview = new Preview();
            smallPreview.setHintHeight(smallPreviewHintHeight);
            smallPreview.setHintWidth(smallPreviewHintWidth);
            smallPreview.setDocument(UriBuilder.fromUri(aRequirement.getAbout()).path("smallPreview").build());
            compact.setSmallPreview(smallPreview);

            final Preview largePreview = new Preview();
            largePreview.setHintHeight(largePreviewHintHeight);
            largePreview.setHintWidth(largePreviewHintWidth);
            largePreview.setDocument(UriBuilder.fromUri(aRequirement.getAbout()).path("largePreview").build());
            compact.setLargePreview(largePreview);

            httpServletResponse.addHeader(RMToolConstants.HDR_OSLC_VERSION, RMToolConstants.OSLC_VERSION_V2);
            return compact;
        }
        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    @Path("{requirementId}/smallPreview")
    @Produces({ MediaType.TEXT_HTML })
    public void getRequirementAsHtmlSmallPreview(
        @PathParam("requirementId") final String requirementId
        ) throws ServletException, IOException, URISyntaxException
    {
        // Start of user code getRequirementAsHtmlSmallPreview_init
        // End of user code

        final Requirement aRequirement = RMToolManager.getRequirement(httpServletRequest, requirementId);

        if (aRequirement != null) {
            httpServletRequest.setAttribute("aRequirement", aRequirement);
            // Start of user code getRequirementAsHtmlSmallPreview_setAttributes
            // End of user code

            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/com/sample/rm/requirementsmallpreview.jsp");
            httpServletResponse.addHeader(RMToolConstants.HDR_OSLC_VERSION, RMToolConstants.OSLC_VERSION_V2);
            rd.forward(httpServletRequest, httpServletResponse);
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }

    @GET
    @Path("{requirementId}/largePreview")
    @Produces({ MediaType.TEXT_HTML })
    public void getRequirementAsHtmlLargePreview(
        @PathParam("requirementId") final String requirementId
        ) throws ServletException, IOException, URISyntaxException
    {
        // Start of user code getRequirementAsHtmlLargePreview_init
        // End of user code

        final Requirement aRequirement = RMToolManager.getRequirement(httpServletRequest, requirementId);

        if (aRequirement != null) {
            httpServletRequest.setAttribute("aRequirement", aRequirement);
            // Start of user code getRequirementAsHtmlLargePreview_setAttributes
            // End of user code

            RequestDispatcher rd = httpServletRequest.getRequestDispatcher("/com/sample/rm/requirementlargepreview.jsp");
            httpServletResponse.addHeader(RMToolConstants.HDR_OSLC_VERSION, RMToolConstants.OSLC_VERSION_V2);
            rd.forward(httpServletRequest, httpServletResponse);
        }

        throw new WebApplicationException(Status.NOT_FOUND);
    }
}
